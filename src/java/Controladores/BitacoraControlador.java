/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.BitacoraServicioSocial;
import Entidades.Estudiante;
import Entidades.ZonaServicioSocial;
import Facade.BitacoraServicioSocialFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author jusag
 */
@Named(value = "bitacoraControlador")
@SessionScoped
public class BitacoraControlador implements Serializable {

    /**
     * Creates a new instance of bitacoraControlador
     */
    public BitacoraControlador() {
        estudiante = new Estudiante();
        zona = new ZonaServicioSocial();
        bitacora = new BitacoraServicioSocial();
        bitacoraFacade = new BitacoraServicioSocialFacade();
    }
    
    private BitacoraServicioSocial bitacora;
    private Estudiante estudiante;
    private ZonaServicioSocial zona;
    
    @EJB
    BitacoraServicioSocialFacade bitacoraFacade;
    
    
    
    public String registrar(){
        bitacora.setEstudiante(estudiante);
        bitacora.setZonadeServicio(zona);
        bitacoraFacade.create(bitacora);
        bitacora = new BitacoraServicioSocial();// nose olvide d esscjnxs jv xjvn cxnsjv dsnvj ds --Kevin: Kha?
        return "bitacora";
    }

    
     public String Remover(BitacoraServicioSocial bitacoraRemover) {
        bitacora = bitacoraRemover;
        bitacora.setEstado(2);
        bitacoraFacade.edit(bitacora);
        return "BitacoraSS.xhtml";
    }
    
    public List<BitacoraServicioSocial> consultarBitacora(){
        return bitacoraFacade.consultarBitacoraServicioSocial(1);
    }

    public BitacoraServicioSocial getBitacora() {
        return bitacora;
    }

    public void setBitacora(BitacoraServicioSocial bitacora) {
        this.bitacora = bitacora;
    }


    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public ZonaServicioSocial getZona() {
        return zona;
    }

    public void setZona(ZonaServicioSocial zona) {
        this.zona = zona;
    }
    
}
