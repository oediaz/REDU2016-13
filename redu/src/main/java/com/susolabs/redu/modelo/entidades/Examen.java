/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.susolabs.redu.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PEPE
 */
@Entity
@Table(name = "examen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examen.findAll", query = "SELECT e FROM Examen e")
    , @NamedQuery(name = "Examen.findByIdexamen", query = "SELECT e FROM Examen e WHERE e.idexamen = :idexamen")
    , @NamedQuery(name = "Examen.findByNombreexamen", query = "SELECT e FROM Examen e WHERE e.nombreexamen = :nombreexamen")
    , @NamedQuery(name = "Examen.findByDescripcionexamen", query = "SELECT e FROM Examen e WHERE e.descripcionexamen = :descripcionexamen")})
public class Examen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDEXAMEN")
    private Integer idexamen;
    @Size(max = 64)
    @Column(name = "NOMBREEXAMEN")
    private String nombreexamen;
    @Size(max = 512)
    @Column(name = "DESCRIPCIONEXAMEN")
    private String descripcionexamen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idexamen")
    private List<Resultadosexamen> resultadosexamenList;

    public Examen() {
    }

    public Examen(Integer idexamen) {
        this.idexamen = idexamen;
    }

    public Integer getIdexamen() {
        return idexamen;
    }

    public void setIdexamen(Integer idexamen) {
        this.idexamen = idexamen;
    }

    public String getNombreexamen() {
        return nombreexamen;
    }

    public void setNombreexamen(String nombreexamen) {
        this.nombreexamen = nombreexamen;
    }

    public String getDescripcionexamen() {
        return descripcionexamen;
    }

    public void setDescripcionexamen(String descripcionexamen) {
        this.descripcionexamen = descripcionexamen;
    }

    @XmlTransient
    public List<Resultadosexamen> getResultadosexamenList() {
        return resultadosexamenList;
    }

    public void setResultadosexamenList(List<Resultadosexamen> resultadosexamenList) {
        this.resultadosexamenList = resultadosexamenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexamen != null ? idexamen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examen)) {
            return false;
        }
        Examen other = (Examen) object;
        if ((this.idexamen == null && other.idexamen != null) || (this.idexamen != null && !this.idexamen.equals(other.idexamen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.susolabs.redu.modelo.entidades.Examen[ idexamen=" + idexamen + " ]";
    }
    
}
