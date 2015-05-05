package entities;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(
    name="findAllClienteByCognomeNome",
    query="SELECT OBJECT(cli) FROM Cliente cli WHERE cli.cognome = :cognome and cli.nome = :nome"
)
public  class Cliente extends Persona implements Serializable {

    @Basic
    private String numeroTessera;

    @OneToMany(cascade={CascadeType.ALL},targetEntity=Ordine.class,mappedBy="cliente")
    private Set<Ordine> ordini = new HashSet<Ordine>();

    public Cliente(){

    }


   public String getNumeroTessera() {
        return this.numeroTessera;
    }


  public void setNumeroTessera (String numeroTessera) {
        this.numeroTessera = numeroTessera;
    }



   public Set<Ordine> getOrdini() {
        return this.ordini;
    }


  public void setOrdini (Set<Ordine> ordini) {
        this.ordini = ordini;
    }

    @Override
    public String toString() {
        return super.toString()+" e Cliente{" + "numeroTessera=" + numeroTessera + '}';
    }

  
  
}

