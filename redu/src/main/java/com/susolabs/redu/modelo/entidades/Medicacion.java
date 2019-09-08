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
@Table(name = "medicacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicacion.findAll", query = "SELECT m FROM Medicacion m")
    , @NamedQuery(name = "Medicacion.findByIdmedicacion", query = "SELECT m FROM Medicacion m WHERE m.idmedicacion = :idmedicacion")
    , @NamedQuery(name = "Medicacion.findByFechamedicacion", query = "SELECT m FROM Medicacion m WHERE m.fechamedicacion = :fechamedicacion")
    , @NamedQuery(name = "Medicacion.findByDescripcionmedicacion", query = "SELECT m FROM Medicacion m WHERE m.descripcionmedicacion = :descripcionmedicacion")})
public class Medicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDMEDICACION")
    private Integer idmedicacion;
    @Column(name = "FECHAMEDICACION")
    @Temporal(TemporalType.DATE)
    private Date fechamedicacion;
    @Size(max = 64)
    @Column(name = "DESCRIPCIONMEDICACION")
    private String descripcionmedicacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmedicacion")
    private List<Receta> recetaList;
    @JoinColumn(name = "IDTRTAMIENTOCM", referencedColumnName = "IDTRTAMIENTOCM")
    @ManyToOne(optional = false)
    private Tratamientocancermama idtrtamientocm;

    public Medicacion() {
    }

    public Medicacion(Integer idmedicacion) {
        this.idmedicacion = idmedicacion;
    }

    public Integer getIdmedicacion() {
        return idmedicacion;
    }

    public void setIdmedicacion(Integer idmedicacion) {
        this.idmedicacion = idmedicacion;
    }

    public Date getFechamedicacion() {
        return fechamedicacion;
    }

    public void setFechamedicacion(Date fechamedicacion) {
        this.fechamedicacion = fechamedicacion;
    }

    public String getDescripcionmedicacion() {
        return descripcionmedicacion;
    }

    public void setDescripcionmedicacion(String descripcionmedicacion) {
        this.descripcionmedicacion = descripcionmedicacion;
    }

    @XmlTransient
    public List<Receta> getRecetaList() {
        return recetaList;
    }

    public void setRecetaList(List<Receta> recetaList) {
        this.recetaList = recetaList;
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
        hash += (idmedicacion != null ? idmedicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicacion)) {
            return false;
        }
        Medicacion other = (Medicacion) object;
        if ((this.idmedicacion == null && other.idmedicacion != null) || (this.idmedicacion != null && !this.idmedicacion.equals(other.idmedicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.susolabs.redu.modelo.entidades.Medicacion[ idmedicacion=" + idmedicacion + " ]";
    }
    
}
