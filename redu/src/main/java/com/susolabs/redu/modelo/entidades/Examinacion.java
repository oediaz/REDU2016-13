/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.susolabs.redu.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PEPE
 */
@Entity
@Table(name = "examinacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examinacion.findAll", query = "SELECT e FROM Examinacion e")
    , @NamedQuery(name = "Examinacion.findByIdexaminacion", query = "SELECT e FROM Examinacion e WHERE e.idexaminacion = :idexaminacion")
    , @NamedQuery(name = "Examinacion.findByFechaexaminacion", query = "SELECT e FROM Examinacion e WHERE e.fechaexaminacion = :fechaexaminacion")
    , @NamedQuery(name = "Examinacion.findByDescripcionexaminacion", query = "SELECT e FROM Examinacion e WHERE e.descripcionexaminacion = :descripcionexaminacion")
    , @NamedQuery(name = "Examinacion.findByObservacionexaminacion", query = "SELECT e FROM Examinacion e WHERE e.observacionexaminacion = :observacionexaminacion")})
public class Examinacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDEXAMINACION")
    private Integer idexaminacion;
    @Column(name = "FECHAEXAMINACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaexaminacion;
    @Size(max = 64)
    @Column(name = "DESCRIPCIONEXAMINACION")
    private String descripcionexaminacion;
    @Size(max = 64)
    @Column(name = "OBSERVACIONEXAMINACION")
    private String observacionexaminacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idexaminacion")
    private List<Resultadosexamen> resultadosexamenList;
    @JoinColumn(name = "IDTRTAMIENTOCM", referencedColumnName = "IDTRTAMIENTOCM")
    @ManyToOne(optional = false)
    private Tratamientocancermama idtrtamientocm;

    public Examinacion() {
    }

    public Examinacion(Integer idexaminacion) {
        this.idexaminacion = idexaminacion;
    }

    public Integer getIdexaminacion() {
        return idexaminacion;
    }

    public void setIdexaminacion(Integer idexaminacion) {
        this.idexaminacion = idexaminacion;
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
    public List<Resultadosexamen> getResultadosexamenList() {
        return resultadosexamenList;
    }

    public void setResultadosexamenList(List<Resultadosexamen> resultadosexamenList) {
        this.resultadosexamenList = resultadosexamenList;
    }

    public Tratamientocancermama getIdtrtamientocm() {
        return idtrtamientocm;
    }

    public void setIdtrtamientocm(Tratamientocancermama idtrtamientocm) {
        this.idtrtamientocm = idtrtamientocm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexaminacion != null ? idexaminacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examinacion)) {
            return false;
        }
        Examinacion other = (Examinacion) object;
        if ((this.idexaminacion == null && other.idexaminacion != null) || (this.idexaminacion != null && !this.idexaminacion.equals(other.idexaminacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.susolabs.redu.modelo.entidades.Examinacion[ idexaminacion=" + idexaminacion + " ]";
    }
    
}
