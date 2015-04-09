package entities;


import java.io.Serializable;

import java.util.Collection;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public  class Categoria implements Serializable {

    @OneToMany(targetEntity=Prodotto.class,mappedBy="categoria")
    private Collection<Prodotto> prodotti;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String nome;

    public Categoria(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Categoria other = (Categoria) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Categoria{" + "id=" + id + ", nome=" + nome + '}';
    }


   public Collection<Prodotto> getProdotti() {
        return this.prodotti;
    }


  public void setProdotti (Collection<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }



   public Long getId() {
        return this.id;
    }


  public void setId (Long id) {
        this.id = id;
    }

}

