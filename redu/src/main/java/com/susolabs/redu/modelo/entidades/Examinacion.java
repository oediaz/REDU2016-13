/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.susolabs.redu.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author t4nk
 */
@Entity
@Table(name = "examinacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examinacion.findAll", query = "SELECT e FROM Examinacion e")
    , @NamedQuery(name = "Examinacion.findByIdtrtamientocm", query = "SELECT e FROM Examinacion e WHERE e.examinacionPK.idtrtamientocm = :idtrtamientocm")
    , @NamedQuery(name = "Examinacion.findByIdexaminacion", query = "SELECT e FROM Examinacion e WHERE e.examinacionPK.idexaminacion = :idexaminacion")
    , @NamedQuery(name = "Examinacion.findByFechaexaminacion", query = "SELECT e FROM Examinacion e WHERE e.fechaexaminacion = :fechaexaminacion")
    , @NamedQuery(name = "Examinacion.findByDescripcionexaminacion", query = "SELECT e FROM Examinacion e WHERE e.descripcionexaminacion = :descripcionexaminacion")
    , @NamedQuery(name = "Examinacion.findByObservacionexaminacion", query = "SELECT e FROM Examinacion e WHERE e.observacionexaminacion = :observacionexaminacion")})
public class Examinacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExaminacionPK examinacionPK;
    @Column(name = "FECHAEXAMINACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaexaminacion;
    @Size(max = 64)
    @Column(name = "DESCRIPCIONEXAMINACION")
    private String descripcionexaminacion;
    @Size(max = 64)
    @Column(name = "OBSERVACIONEXAMINACION")
    private String observacionexaminacion;
    @ManyToMany(mappedBy = "examinacionList")
    private List<Examen> examenList;
    @JoinColumn(name = "IDTRTAMIENTOCM", referencedColumnName = "IDTRTAMIENTOCM", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tratamientocancermama tratamientocancermama;

    public Examinacion() {
    }

    public Examinacion(ExaminacionPK examinacionPK) {
        this.examinacionPK = examinacionPK;
    }

    public Examinacion(int idtrtamientocm, int idexaminacion) {
        this.examinacionPK = new ExaminacionPK(idtrtamientocm, idexaminacion);
    }

    public ExaminacionPK getExaminacionPK() {
        return examinacionPK;
    }

    public void setExaminacionPK(ExaminacionPK examinacionPK) {
        this.examinacionPK = examinacionPK;
    }

    public Date getFechaexaminacion() {
        return fechaexaminacion;
    }

    public void setFechaexaminacion(Date fechaexaminacion) {
        this.fechaexaminacion = fechaexaminacion;
    }

    public String getDescripcionexaminacion() {
        return descripcionexaminacion;
    }

    public void setDescripcionexaminacion(String descripcionexaminacion) {
        this.descripcionexaminacion = descripcionexaminacion;
    }

    public String getObservacionexaminacion() {
        return observacionexaminacion;
    }

    public void setObservacionexaminacion(String observacionexaminacion) {
        this.observacionexaminacion = observacionexaminacion;
    }

    @XmlTransient
    public List<Examen> getExamenList() {
        return examenList;
    }

    public void setExamenList(List<Examen> examenList) {
        this.examenList = examenList;
    }

    public Tratamientocancermama getTratamientocancermama() {
        return tratamientocancermama;
    }

    public void setTratamientocancermama(Tratamientocancermama tratamientocancermama) {
        this.tratamientocancermama = tratamientocancermama;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (examinacionPK != null ? examinacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examinacion)) {
            return false;
        }
        Examinacion other = (Examinacion) object;
        if ((this.examinacionPK == null && other.examinacionPK != null) || (this.examinacionPK != null && !this.examinacionPK.equals(other.examinacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.susolabs.redu.modelo.entidades.Examinacion[ examinacionPK=" + examinacionPK + " ]";
    }
    
}
