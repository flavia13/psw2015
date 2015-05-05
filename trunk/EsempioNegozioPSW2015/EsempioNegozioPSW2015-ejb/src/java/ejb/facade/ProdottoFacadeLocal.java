/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.facade;

import entities.Prodotto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sflesca
 */
@Local
public interface ProdottoFacadeLocal {

    void create(Prodotto prodotto);

    void edit(Prodotto prodotto);

    void remove(Prodotto prodotto);

    Prodotto find(Object id);

    List<Prodotto> findAll();

    List<Prodotto> findRange(int[] range);

    int count();
    
}
