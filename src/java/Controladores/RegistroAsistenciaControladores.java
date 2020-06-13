/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.DocenteMateria;
import Entidades.Estudiante;
import Entidades.Periodo;
import Entidades.RegistroAsistencia;
import Facade.RegistroAsistenciaFacade;
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
@Named(value = "registroAsistenciaControladores")
@SessionScoped
public class RegistroAsistenciaControladores implements Serializable {

    /**
     * Creates a new instance of registro_asistenciaControladores
     */
    public RegistroAsistenciaControladores() {  
        periodo = new Periodo();
        estudiante = new Estudiante();
        registroAsistencia = new RegistroAsistencia();
        docenteMateria = new DocenteMateria();
    }
    
    DocenteMateria docenteMateria;
    Periodo periodo;
    Estudiante estudiante;
    RegistroAsistencia registroAsistencia;
    
    @EJB
    RegistroAsistenciaFacade registroAsistenciaFacade;

    public DocenteMateria getDocenteMateria() {
        return docenteMateria;
    }

    public void setDocenteMateria(DocenteMateria docenteMateria) {
        this.docenteMateria = docenteMateria;
    }
    

    public RegistroAsistencia getRegistroAsistencia() {
        return registroAsistencia;
    }

    public void setRegistroAsistencia(RegistroAsistencia registroAsistencia) {
        this.registroAsistencia = registroAsistencia;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
    public void registrarAsistencia(){
        registroAsistencia.setPeriodo(periodo);
        registroAsistencia.setEstudiante(estudiante);
        registroAsistencia.setDocenteMateria(docenteMateria);
        registroAsistenciaFacade.create(registroAsistencia);
    }
    
    public List<RegistroAsistencia> consultarAsistencia(){
        return registroAsistenciaFacade.consultarRegistroAsistencia(1);
    }
}
