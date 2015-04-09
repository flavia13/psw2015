/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entity.Professore;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sflesca
 */
@Stateless
public class ProfManager implements ProfManagerLocal {
    @PersistenceContext(unitName = "LezionePSW2015PU")
    private EntityManager em;
    
    

    @Override
    public List<Professore> GetListaProf() {
        Query q = em.createNamedQuery("Professore.findAll");
        List<Professore> professorList = q.getResultList();
        return professorList;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }
}
