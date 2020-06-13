/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Acudiente;
import Entidades.Cita;
import Facade.CitaFacade;
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
@Named(value = "citaControlador")
@SessionScoped
public class CitaControlador implements Serializable {

    /**
     * Creates a new instance of CitaControlador
     */
    public CitaControlador() {
        cita = new Cita();
        acudiente = new Acudiente();
    }
    
    Cita cita;
    Acudiente acudiente;
    
    @EJB
    CitaFacade citaFacade;

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public Acudiente getAcudiente() {
        return acudiente;
    }

    public void setAcudiente(Acudiente acudiente) {
        this.acudiente = acudiente;
    }
    
    public List<Cita> consultarCita(){
        return citaFacade.consultarCita(1);
    }
    public void registrarCita(){
        cita.setAcudiente(acudiente);
        citaFacade.create(cita);
    }
}
