/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb.exceptions;

/**
 *
 * @author sflesca
 */
public class ProdottoNonPresenteException extends Exception {

    /**
     * Creates a new instance of <code>ProdottoNonPresente</code> without detail
     * message.
     */
    public ProdottoNonPresenteException() {
    }

    /**
     * Constructs an instance of <code>ProdottoNonPresente</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ProdottoNonPresenteException(String msg) {
        super(msg);
    }
}
