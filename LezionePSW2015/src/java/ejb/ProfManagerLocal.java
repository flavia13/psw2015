/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entity.Professore;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sflesca
 */
@Local
public interface ProfManagerLocal {

    List<Professore> GetListaProf();
    
}
