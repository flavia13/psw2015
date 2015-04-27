/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbeans;

import entities.Cliente;
import entities.ClienteFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author sflesca
 */
@Named(value = "clienteManagedBean")
@SessionScoped
public class ClienteManagedBean  implements Serializable{
    
    Cliente current;

    @EJB
    private ClienteFacade clienteFacade;

    List<Cliente> clienti;

    /**
     * Creates a new instance of CleinteManagedBean2
     */
    public ClienteManagedBean() {

    }

    @PostConstruct
    public void reset() {
        if (clienti == null) {
            clienti = clienteFacade.findAll();
        }
    }

    public List<Cliente> getClienti() {
        return clienti;
    }

    public void setClienti(List<Cliente> clienti) {
        this.clienti = clienti;
    }
    
    public String editCliente(Cliente c){
        current = c;
        return "edit";
    }

    public Cliente getCurrent() {
        return current;
    }

    public void setCurrent(Cliente current) {
        this.current = current;
    }
    
    
}
