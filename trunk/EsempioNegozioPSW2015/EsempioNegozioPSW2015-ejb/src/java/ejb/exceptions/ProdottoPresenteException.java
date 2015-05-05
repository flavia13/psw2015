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
public class ProdottoPresenteException extends Exception {

    /**
     * Creates a new instance of <code>ProdottoPresenteException</code> without
     * detail message.
     */
    public ProdottoPresenteException() {
    }

    /**
     * Constructs an instance of <code>ProdottoPresenteException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ProdottoPresenteException(String msg) {
        super(msg);
    }
}
