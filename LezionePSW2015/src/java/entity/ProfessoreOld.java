/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

/**
 *
 * @author sflesca
 */
public class ProfessoreOld {
    protected int id;
    protected String cognome;
    protected String nome;

    public ProfessoreOld(int id, String cognome, String nome) {
        this.id = id;
        this.cognome = cognome;
        this.nome = nome;
    }

    ProfessoreOld() {
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    
    
}
