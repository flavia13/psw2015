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
import entities.Cliente;
import entities.DettaglioOrdine;
import entities.Prodotto;
import java.util.*;
import javax.ejb.Local;

/**
 *
 * @author sflesca
 */
@Local
public interface CarrelloLocal {

    void add(Prodotto prodotto) throws ProdottoPresenteException;

    void remove(Prodotto prodotto) throws ejb.exceptions.ProdottoNonPresenteException;

    void setQta(Prodotto prodotto, int qta) throws ProdottoNonPresenteException;

    void svuota();

    void ordina(Cliente cliente) throws ClienteNonPresenteException, ProdottoNonDisponibileException;

    void ordina();

    Collection<DettaglioOrdine> contenuto();

    int itemCount();
    
}
