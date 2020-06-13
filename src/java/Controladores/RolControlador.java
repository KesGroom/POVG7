/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Rol;
import Facade.RolFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author jusag
 */
@Named(value = "rolControlador")
@SessionScoped
public class RolControlador implements Serializable {

    /**
     * Creates a new instance of rolControlador
     */
    public RolControlador() {
        rol = new Rol();
        rolFacade = new RolFacade();
    }
    private Rol rol;
    
    @EJB 
    RolFacade rolFacade;
    
   
    public String registrar(){
        rol.setEstado(1);
        rolFacade.create(rol);
        
        rol = new Rol();
        return "Roles";
    }
    
    public List<Rol> consultarRol(){
        return rolFacade.consultarRol(1);
    }
    
    public void remover(Rol rolRemover){
        rol = rolRemover;
        rol.setEstado(2);
        rolFacade.edit(rol);
    }        

    
    public void consultarId(int id){
        rol = rolFacade.find(id);
    }
    
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
}
