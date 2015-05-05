/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import ejb.exceptions.ClienteNonPresenteException;
import ejb.exceptions.ProdottoNonDisponibileException;
import ejb.exceptions.ProdottoNonPresenteException;
import ejb.exceptions.ProdottoPresenteException;
import ejb.facade.ClienteFacadeLocal;
import ejb.facade.DettaglioOrdineFacadeLocal;
import ejb.facade.OrdineFacadeLocal;
import ejb.facade.ProdottoFacadeLocal;
import entities.Cliente;
import entities.DettaglioOrdine;
import entities.Ordine;
import entities.Prodotto;
import java.util.*;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author sflesca
 */
@Stateful
public class Carrello implements CarrelloLocal {

    @EJB
    private ProdottoFacadeLocal prodottoFacade;
    @EJB
    private DettaglioOrdineFacadeLocal dettaglioOrdineFacade;
    @EJB
    private OrdineFacadeLocal ordineFacade;
    @EJB
    private ClienteFacadeLocal clienteFacade;

    private HashMap<Prodotto, DettaglioOrdine> items
            = new HashMap<Prodotto, DettaglioOrdine>();

    @Override
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void add(Prodotto prodotto) throws ProdottoPresenteException {
        if (items.containsKey(prodotto)) {
            throw new ProdottoPresenteException();
        }
        DettaglioOrdine dt = new DettaglioOrdine();
        dt.setProdotto(prodotto);
        dt.setQta(1);
        items.put(dt.getProdotto(), dt);
    }

    @Override
    public void remove(Prodotto prodotto) throws ProdottoNonPresenteException {
        if (!items.containsKey(prodotto)) {
            throw new ProdottoNonPresenteException();
        }
        items.remove(prodotto);
    }

    @Override
    public void setQta(Prodotto prodotto, int qta) throws ProdottoNonPresenteException {
        if (!items.containsKey(prodotto)) {
            throw new ProdottoNonPresenteException();
        }
        DettaglioOrdine dt = items.get(prodotto);
        dt.setQta(qta);
    }

    @Override
    public void svuota() {
        items.clear();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void ordina(Cliente cliente) throws ClienteNonPresenteException, ProdottoNonDisponibileException {
        // controllo cliente
        Cliente cl = clienteFacade.find(cliente.getId());
        if (cl == null) {
            throw new ClienteNonPresenteException();
        }

        Ordine o = new Ordine();
        o.setCliente(cl);
        cl.getOrdini().add(o);
        ordineFacade.create(o);

        // controllo quantità disponibili
        for (Prodotto p : items.keySet()) {
            DettaglioOrdine dt = items.get(p);
            Prodotto pp = prodottoFacade.find(p.getId());
            if (dt.getQta() >= pp.getQtaAvailable()) {
                throw new ProdottoNonDisponibileException(pp, dt);
            }
            pp.setQtaAvailable(pp.getQtaAvailable() - dt.getQta());
            dt.setOrdine(o);
            o.getDettagli().add(dt);
            dt.setProdotto(pp);
        }

    }

    @Override
    public void ordina() {
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Collection<DettaglioOrdine> contenuto() {
        return items.values();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public int itemCount() {
        return items.size();
    }

}
