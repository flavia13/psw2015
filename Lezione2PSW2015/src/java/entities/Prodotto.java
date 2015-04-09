package entities;


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public  class Prodotto implements Serializable {

    @ManyToOne(optional=false,targetEntity=Categoria.class)
    private Categoria categoria;

    @Column(nullable=false)
    @Basic
    private int prezzo;

    @Basic
    private String nome;
    
    @Version
    private long version;
    
    private int qtaAvailable;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    public Prodotto(){

    }


   public Categoria getCategoria() {
        return this.categoria;
    }


  public void setCategoria (Categoria categoria) {
        this.categoria = categoria;
    }



   public int getPrezzo() {
        return this.prezzo;
    }


  public void setPrezzo (int prezzo) {
        this.prezzo = prezzo;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
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

    public int getQtaAvailable() {
        return qtaAvailable;
    }

    public void setQtaAvailable(int qtaAvailable) {
        this.qtaAvailable = qtaAvailable;
    }

  
  
}

