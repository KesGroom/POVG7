/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Actividad;
import Entidades.Curso;
import Entidades.DocenteMateria;
import Facade.ActividadFacade;
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
@Named(value = "actividadControlador")
@SessionScoped
public class ActividadControlador implements Serializable {

    public ActividadControlador() {
        actividad = new Actividad();
        curso = new Curso();
        docenteMateria = new DocenteMateria();
    }
    
    Actividad actividad;
    Curso curso;
    DocenteMateria docenteMateria;
    
    @EJB
    ActividadFacade actividadFacade;

    public List<Actividad> consultarActividad(){
        return actividadFacade.consultarActividad(1);
    }
    
    public void registrarActividad(){
        actividad.setCurso(curso);
        actividad.setIdDocenteMateria(docenteMateria);
        actividadFacade.create(actividad);
    }
    
    public String Remover(Actividad actividadRemover) {
        actividad = actividadRemover;
        actividad.setEstado(2);
        actividadFacade.edit(actividad);
        return "Actividades";
    }
    
    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public DocenteMateria getDocenteMateria() {
        return docenteMateria;
    }

    public void setDocenteMateria(DocenteMateria docenteMateria) {
        this.docenteMateria = docenteMateria;
    }
    
}
