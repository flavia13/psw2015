package entities;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(length=31,name="DTYPE",discriminatorType=DiscriminatorType.STRING)
public  class Persona implements Serializable {

    @Basic
    private String cognome;

    @Basic
    private String nome;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    public Persona(){

    }


   public String getCognome() {
        return this.cognome;
    }


  public void setCognome (String cognome) {
        this.cognome = cognome;
    }



   public String getNome() {
        return this.nome;
    }


  public void setNome (String nome) {
        this.nome = nome;
    }



   public Long getId() {
        return this.id;
    }


  public void setId (Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persona{" + "cognome=" + cognome + ", nome=" + nome + ", id=" + id + '}';
    }

}

