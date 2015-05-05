/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.facade;

import entities.Ordine;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sflesca
 */
@Local
public interface OrdineFacadeLocal {

    void create(Ordine ordine);

    void edit(Ordine ordine);

    void remove(Ordine ordine);

    Ordine find(Object id);

    List<Ordine> findAll();

    List<Ordine> findRange(int[] range);

    int count();
    
}
