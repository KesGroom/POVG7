/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import Entidades.Noticia;
import Facade.NoticiaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author kesgr
 */
@Named(value = "noticiaControlador")
@SessionScoped
public class NoticiaControlador implements Serializable {

    /**
     * Creates a new instance of NoticiaControlador
     */
    public NoticiaControlador() {
        noticia = new Noticia();
        
    }
    
    private Noticia noticia;
    
    @EJB
    NoticiaFacade noticiaFacade;
    
    public List<Noticia> consultarNoticias(int categoria){
        return noticiaFacade.consultarNoticia(1, categoria);
    }

    public Noticia getNoticia() {
        return noticia;
    }

    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }
    
    
    
}
