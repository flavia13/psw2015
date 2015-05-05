/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sflesca
 */
public class DettaglioOrdinePK implements Serializable {
    private long prodotto;
    private long ordine;

    public DettaglioOrdinePK() {
    }

    public DettaglioOrdinePK(long prodotto, long ordine) {
        this.prodotto = prodotto;
        this.ordine = ordine;
    }

    public long getProdotto() {
        return prodotto;
    }

    public void setProdotto(long prodotto) {
        this.prodotto = prodotto;
    }

    public long getOrdine() {
        return ordine;
    }

    public void setOrdine(long ordine) {
        this.ordine = ordine;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) prodotto;
        hash += (int) ordine;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DettaglioOrdinePK)) {
            return false;
        }
        DettaglioOrdinePK other = (DettaglioOrdinePK) object;
        if (this.prodotto != other.prodotto) {
            return false;
        }
        if (this.ordine != other.ordine) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DettaglioordinePK[ prodotto=" + prodotto + ", ordine=" + ordine + " ]";
    }
    
}
