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
@Table(name = "docentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d")
    , @NamedQuery(name = "Docente.findByIdUsuario", query = "SELECT d FROM Docente d WHERE d.idUsuario = :idUsuario")
    , @NamedQuery(name = "Docente.findByEstado", query = "SELECT d FROM Docente d WHERE d.estado = :estado")})
public class Docente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_Usuario")
    private Integer idUsuario;
    @Column(name = "Estado")
    private Integer estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDocente", fetch = FetchType.LAZY)
    private List<CursoDocente> cursoDocenteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docenteACargo", fetch = FetchType.LAZY)
    private List<Atencionarea> atencionareaList;
    @JoinColumn(name = "Id_Usuario", referencedColumnName = "Id_Usuario", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDocente", fetch = FetchType.LAZY)
    private List<DocenteMateria> docenteMateriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docenteACargo", fetch = FetchType.LAZY)
    private List<Atencioncurso> atencioncursoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDocente", fetch = FetchType.LAZY)
    private List<DocenteCita> docenteCitaList;

    public Docente() {
    }

    public Docente(Integer idUsuario) {
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

    @XmlTransient
    public List<CursoDocente> getCursoDocenteList() {
        return cursoDocenteList;
    }

    public void setCursoDocenteList(List<CursoDocente> cursoDocenteList) {
        this.cursoDocenteList = cursoDocenteList;
    }

    @XmlTransient
    public List<Atencionarea> getAtencionareaList() {
        return atencionareaList;
    }

    public void setAtencionareaList(List<Atencionarea> atencionareaList) {
        this.atencionareaList = atencionareaList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public List<DocenteMateria> getDocenteMateriaList() {
        return docenteMateriaList;
    }

    public void setDocenteMateriaList(List<DocenteMateria> docenteMateriaList) {
        this.docenteMateriaList = docenteMateriaList;
    }

    @XmlTransient
    public List<Atencioncurso> getAtencioncursoList() {
        return atencioncursoList;
    }

    public void setAtencioncursoList(List<Atencioncurso> atencioncursoList) {
        this.atencioncursoList = atencioncursoList;
    }

    @XmlTransient
    public List<DocenteCita> getDocenteCitaList() {
        return docenteCitaList;
    }

    public void setDocenteCitaList(List<DocenteCita> docenteCitaList) {
        this.docenteCitaList = docenteCitaList;
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
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Docente[ idUsuario=" + idUsuario + " ]";
    }
    
}
