/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Acudiente;
import Facade.AcudienteFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author PC
 */
@Named(value = "acudienteControlador")
@SessionScoped
public class AcudienteControlador implements Serializable {

    /**
     * Creates a new instance of AcudienteControladores
     */
    public AcudienteControlador() {
        acudiente = new Acudiente();
    }
    Acudiente acudiente;
    @EJB
    AcudienteFacade acudienteFacade;

    public Acudiente getAcudiente() {
        return acudiente;
    }

    public void setAcudiente(Acudiente acudiente) {
        this.acudiente = acudiente;
    }
    
    public List<Acudiente> consultarAcudiente(){
        return acudienteFacade.consultarAcudiente(1);
    }
    
}
