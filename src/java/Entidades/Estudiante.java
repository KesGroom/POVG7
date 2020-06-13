/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kesgr
 */
@Entity
@Table(name = "estudiantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e")
    , @NamedQuery(name = "Estudiante.findByIdUsuario", query = "SELECT e FROM Estudiante e WHERE e.idUsuario = :idUsuario")
    , @NamedQuery(name = "Estudiante.findByEstado", query = "SELECT e FROM Estudiante e WHERE e.estado = :estado")
    , @NamedQuery(name = "Estudiante.findByEstadoServicioSocial", query = "SELECT e FROM Estudiante e WHERE e.estadoServicioSocial = :estadoServicioSocial")
    , @NamedQuery(name = "Estudiante.findByTeimpoServicio", query = "SELECT e FROM Estudiante e WHERE e.teimpoServicio = :teimpoServicio")})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_Usuario")
    private Integer idUsuario;
    @Column(name = "Estado")
    private Integer estado;
    @Column(name = "EstadoServicioSocial")
    private Integer estadoServicioSocial;
    @Column(name = "TeimpoServicio")
    private Integer teimpoServicio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante", fetch = FetchType.LAZY)
    private List<RegistroNota> registroNotaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante", fetch = FetchType.LAZY)
    private List<BitacoraServicioSocial> bitacoraServicioSocialList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante", fetch = FetchType.LAZY)
    private List<RegistroAsistencia> registroAsistenciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante", fetch = FetchType.LAZY)
    private List<AgendaWeb> agendaWebList;
    @JoinColumn(name = "Id_Acudiente", referencedColumnName = "Id_Usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Acudiente idAcudiente;
    @JoinColumn(name = "Id_Curso", referencedColumnName = "Id_Curso")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Curso idCurso;
    @JoinColumn(name = "Id_Usuario", referencedColumnName = "Id_Usuario", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuario;

    public Estudiante() {
    }

    public Estudiante(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getEstadoServicioSocial() {
        return estadoServicioSocial;
    }

    public void setEstadoServicioSocial(Integer estadoServicioSocial) {
        this.estadoServicioSocial = estadoServicioSocial;
    }

    public Integer getTeimpoServicio() {
        return teimpoServicio;
    }

    public void setTeimpoServicio(Integer teimpoServicio) {
        this.teimpoServicio = teimpoServicio;
    }

    @XmlTransient
    public List<RegistroNota> getRegistroNotaList() {
        return registroNotaList;
    }

    public void setRegistroNotaList(List<RegistroNota> registroNotaList) {
        this.registroNotaList = registroNotaList;
    }

    @XmlTransient
    public List<BitacoraServicioSocial> getBitacoraServicioSocialList() {
        return bitacoraServicioSocialList;
    }

    public void setBitacoraServicioSocialList(List<BitacoraServicioSocial> bitacoraServicioSocialList) {
        this.bitacoraServicioSocialList = bitacoraServicioSocialList;
    }

    @XmlTransient
    public List<RegistroAsistencia> getRegistroAsistenciaList() {
        return registroAsistenciaList;
    }

    public void setRegistroAsistenciaList(List<RegistroAsistencia> registroAsistenciaList) {
        this.registroAsistenciaList = registroAsistenciaList;
    }

    @XmlTransient
    public List<AgendaWeb> getAgendaWebList() {
        return agendaWebList;
    }

    public void setAgendaWebList(List<AgendaWeb> agendaWebList) {
        this.agendaWebList = agendaWebList;
    }

    public Acudiente getIdAcudiente() {
        return idAcudiente;
    }

    public void setIdAcudiente(Acudiente idAcudiente) {
        this.idAcudiente = idAcudiente;
    }

    public Curso getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Curso idCurso) {
        this.idCurso = idCurso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Estudiante[ idUsuario=" + idUsuario + " ]";
    }
    
}
