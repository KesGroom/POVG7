/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Acudiente;
import Entidades.Docente;
import Entidades.Pqrs;
import Facade.PqrsFacade;
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
@Named(value = "pqrsControladores")
@SessionScoped
public class PqrsControladores implements Serializable {

    /**
     * Creates a new instance of pqrsControladores
     */
    public PqrsControladores() {
        pqrs = new Pqrs();
        acudiente = new Acudiente();    
    }
    Pqrs pqrs;
    Acudiente acudiente;
    
    @EJB
    PqrsFacade pqrsFacade;

    public Pqrs getPqrs() {
        return pqrs;
    }

    public void setPqrs(Pqrs pqrs) {
        this.pqrs = pqrs;
    }

    public Acudiente getAcudiente() {
        return acudiente;
    }

    public void setAcudiente(Acudiente acudiente) {
        this.acudiente = acudiente;
    }

   
   
    public void registrarPqrs(){
        pqrs.setIdAcudiente(acudiente);
        pqrsFacade.create(pqrs);
        pqrs = new Pqrs();
    }
    public List<Pqrs> consultarPqrs(){
        return pqrsFacade.findAll();
    }
    public String preActualizar(Pqrs pqrsActualizar){
        pqrs = pqrsActualizar;
        acudiente = pqrsActualizar.getIdAcudiente();
        return "ResponderPqrs";
                
    }
    public String actualizarPqrs(){
        pqrs.setIdAcudiente(acudiente);
        pqrsFacade.edit(pqrs);
        return "PQRS";
    }
   
    
     
}
