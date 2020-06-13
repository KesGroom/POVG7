/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


/**
 *
 * @author kesgr
**/

import Entidades.Materia;
import Facade.MateriaFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;


@Named(value = "materiaControlador")
@SessionScoped
public class MateriaControlador implements Serializable {

    /**
     * Creates a new instance of MateriaControlador
     */
    public MateriaControlador() {
        materia = new Materia();
    }

    Materia materia;
    
    @EJB
    MateriaFacade materiaFacade;

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
    public List<Materia>consultarMateria(){
        return materiaFacade.consultarMateria(1);
    }
    
    public void registrarMateria(){
       
    }
    
}
