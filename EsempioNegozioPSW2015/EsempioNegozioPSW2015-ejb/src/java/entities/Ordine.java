package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Ordine implements Serializable {

    @ManyToOne(optional = false, targetEntity = Cliente.class)
    private Cliente cliente;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy="Ordine", cascade={CascadeType.ALL})
    private Collection<DettaglioOrdine> dettagli = new LinkedList<DettaglioOrdine>();

    public Ordine() {

    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Collection<DettaglioOrdine> getDettagli() {
        return dettagli;
    }

    public void setDettagli(Collection<DettaglioOrdine> dettagli) {
        this.dettagli = dettagli;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Ordine other = (Ordine) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ordine{" + "cliente=" + cliente + ", id=" + id + '}';
    }
    
    

}
