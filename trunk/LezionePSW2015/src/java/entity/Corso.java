/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sflesca
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Corso.findAll", query = "SELECT c FROM Corso c"),
    @NamedQuery(name = "Corso.findByIdCorso", query = "SELECT c FROM Corso c WHERE c.idCorso = :idCorso"),
    @NamedQuery(name = "Corso.findByNome", query = "SELECT c FROM Corso c WHERE c.nome = :nome"),
    @NamedQuery(name = "Corso.findByCfu", query = "SELECT c FROM Corso c WHERE c.cfu = :cfu"),
    @NamedQuery(name = "Corso.findByCorsocol", query = "SELECT c FROM Corso c WHERE c.corsocol = :corsocol"),
    @NamedQuery(name = "Corso.findByCorsocol1", query = "SELECT c FROM Corso c WHERE c.corsocol1 = :corsocol1")})
public class Corso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer idCorso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String nome;
    @Basic(optional = false)
    @NotNull
    private int cfu;
    @Size(max = 45)
    private String corsocol;
    @Size(max = 45)
    private String corsocol1;
    @JoinColumn(name = "titolare", referencedColumnName = "idProfessore")
    @ManyToOne(optional = false)
    private Professore titolare;

    public Corso() {
    }

    public Corso(Integer idCorso) {
        this.idCorso = idCorso;
    }

    public Corso(Integer idCorso, String nome, int cfu) {
        this.idCorso = idCorso;
        this.nome = nome;
        this.cfu = cfu;
    }

    public Integer getIdCorso() {
        return idCorso;
    }

    public void setIdCorso(Integer idCorso) {
        this.idCorso = idCorso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCfu() {
        return cfu;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;
    }

    public String getCorsocol() {
        return corsocol;
    }

    public void setCorsocol(String corsocol) {
        this.corsocol = corsocol;
    }

    public String getCorsocol1() {
        return corsocol1;
    }

    public void setCorsocol1(String corsocol1) {
        this.corsocol1 = corsocol1;
    }

    public Professore getTitolare() {
        return titolare;
    }

    public void setTitolare(Professore titolare) {
        this.titolare = titolare;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCorso != null ? idCorso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Corso)) {
            return false;
        }
        Corso other = (Corso) object;
        if ((this.idCorso == null && other.idCorso != null) || (this.idCorso != null && !this.idCorso.equals(other.idCorso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Corso[ idCorso=" + idCorso + " ]";
    }
    
}
