/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Categorianoticia;
import Facade.CategorianoticiaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author kesgr
 */
@Named(value = "categoriaControlador")
@SessionScoped
public class CategoriaControlador implements Serializable {

    /**
     * Creates a new instance of CategoriaControlador
     */
    public CategoriaControlador() {
        categoria = new Categorianoticia();
        categoriaFacade = new CategorianoticiaFacade();
    }
    
    private Categorianoticia categoria;
    
    @EJB
    CategorianoticiaFacade categoriaFacade;

    public List<Categorianoticia> consultarCategorias(){
        return categoriaFacade.consultarCategoria(1);
    }
    
    
    public Categorianoticia getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorianoticia categoria) {
        this.categoria = categoria;
    }
    
    
    
    
}
