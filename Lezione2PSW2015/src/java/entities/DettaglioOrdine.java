/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author sflesca
 */
@Entity
@IdClass(DettaglioOrdinePK.class)
public class DettaglioOrdine implements Serializable {
    private static final long serialVersionUID = 1L;

    private Ordine ordine;
    private Prodotto prodotto;
    private int qta;

    @ManyToOne
    @JoinColumn(name="ordine")
    @Id
    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    @ManyToOne
    @JoinColumn(name="prodotto")
    @Id
    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public int getQta() {
        return qta;
    }

    public void setQta(int qta) {
        this.qta = qta;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.ordine);
        hash = 37 * hash + Objects.hashCode(this.prodotto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DettaglioOrdine other = (DettaglioOrdine) obj;
        if (!Objects.equals(this.ordine, other.ordine)) {
            return false;
        }
        if (!Objects.equals(this.prodotto, other.prodotto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DettaglioOrdine{" + "ordine=" + ordine + ", prodotto=" + prodotto + '}';
    }

    
    

    
}
