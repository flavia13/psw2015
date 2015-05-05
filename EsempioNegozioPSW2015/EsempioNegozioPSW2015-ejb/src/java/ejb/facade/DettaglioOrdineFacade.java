/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.facade;

import entities.DettaglioOrdine;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sflesca
 */
@Stateless
public class DettaglioOrdineFacade extends AbstractFacade<DettaglioOrdine> implements DettaglioOrdineFacadeLocal {
    @PersistenceContext(unitName = "EsempioNegozioPSW2015-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DettaglioOrdineFacade() {
        super(DettaglioOrdine.class);
    }
    
}
