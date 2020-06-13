/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Tipo;
import Facade.TipoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author jusag
 */
@Named(value = "tipoControlador")
@SessionScoped
public class TipoControlador implements Serializable {

    /**
     * Creates a new instance of tipoControlador
     */
    public TipoControlador() {
        tipo = new Tipo();
        tipoFacade = new TipoFacade();
    }
     private Tipo tipo;
     
     @EJB
     TipoFacade tipoFacade;
     
     public String registrar(){
         tipo.setEstado(1);
         tipoFacade.create(tipo);
         
         return "Tipos";
     }
     
     public void remove(Tipo tipoRemover){
         tipo = tipoRemover;
         tipo.setEstado(2);
         tipoFacade.edit(tipo);
     }
     
     public void consultarId(int id){
         tipoFacade.find(id);
     }
     
     public List<Tipo> consultarTodos(){
         return tipoFacade.consultarTipo(1);
     }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
     
     
}
