/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.exceptions;

import entities.DettaglioOrdine;
import entities.Prodotto;

/**
 *
 * @author sflesca
 */
public class ProdottoNonDisponibileException extends Exception {

    public ProdottoNonDisponibileException(Prodotto pp, DettaglioOrdine dt) {
    }
    
}
