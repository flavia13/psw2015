/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sflesca
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Professore.findAll", query = "SELECT p FROM Professore p"),
    @NamedQuery(name = "Professore.findByIdProfessore", query = "SELECT p FROM Professore p WHERE p.idProfessore = :idProfessore"),
    @NamedQuery(name = "Professore.findByCognome", query = "SELECT p FROM Professore p WHERE p.cognome = :cognome"),
    @NamedQuery(name = "Professore.findByNome", query = "SELECT p FROM Professore p WHERE p.nome = :nome"),
    @NamedQuery(name = "Professore.findBySettore", query = "SELECT p FROM Professore p WHERE p.settore = :settore")})
public class Professore implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idProfessore;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String cognome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    private String settore;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "titolare")
    private Collection<Corso> corsoCollection;

    public Professore() {
    }

    public Professore(Integer idProfessore) {
        this.idProfessore = idProfessore;
    }

    public Professore(Integer idProfessore, String cognome, String nome, String settore) {
        this.idProfessore = idProfessore;
        this.cognome = cognome;
        this.nome = nome;
        this.settore = settore;
    }

    public Integer getIdProfessore() {
        return idProfessore;
    }

    public void setIdProfessore(Integer idProfessore) {
        this.idProfessore = idProfessore;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSettore() {
        return settore;
    }

    public void setSettore(String settore) {
        this.settore = settore;
    }

    @XmlTransient
    public Collection<Corso> getCorsoCollection() {
        return corsoCollection;
    }

    public void setCorsoCollection(Collection<Corso> corsoCollection) {
        this.corsoCollection = corsoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfessore != null ? idProfessore.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professore)) {
            return false;
        }
        Professore other = (Professore) object;
        if ((this.idProfessore == null && other.idProfessore != null) || (this.idProfessore != null && !this.idProfessore.equals(other.idProfessore))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Professore[ idProfessore=" + idProfessore + " ]";
    }
    
}
