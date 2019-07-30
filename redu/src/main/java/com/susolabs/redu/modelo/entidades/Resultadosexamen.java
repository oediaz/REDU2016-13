/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.susolabs.redu.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PEPE
 */
@Entity
@Table(name = "resultadosexamen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resultadosexamen.findAll", query = "SELECT r FROM Resultadosexamen r")
    , @NamedQuery(name = "Resultadosexamen.findByIdresultadosexamen", query = "SELECT r FROM Resultadosexamen r WHERE r.idresultadosexamen = :idresultadosexamen")
    , @NamedQuery(name = "Resultadosexamen.findByElementoexamen", query = "SELECT r FROM Resultadosexamen r WHERE r.elementoexamen = :elementoexamen")
    , @NamedQuery(name = "Resultadosexamen.findByDatoelementoexamen", query = "SELECT r FROM Resultadosexamen r WHERE r.datoelementoexamen = :datoelementoexamen")
    , @NamedQuery(name = "Resultadosexamen.findByValorminrefelemexamen", query = "SELECT r FROM Resultadosexamen r WHERE r.valorminrefelemexamen = :valorminrefelemexamen")
    , @NamedQuery(name = "Resultadosexamen.findByValormaxrefelemexamen", query = "SELECT r FROM Resultadosexamen r WHERE r.valormaxrefelemexamen = :valormaxrefelemexamen")})
public class Resultadosexamen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDRESULTADOSEXAMEN")
    private Integer idresultadosexamen;
    @Size(max = 32)
    @Column(name = "ELEMENTOEXAMEN")
    private String elementoexamen;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DATOELEMENTOEXAMEN")
    private BigDecimal datoelementoexamen;
    @Column(name = "VALORMINREFELEMEXAMEN")
    private BigDecimal valorminrefelemexamen;
    @Column(name = "VALORMAXREFELEMEXAMEN")
    private BigDecimal valormaxrefelemexamen;
    @JoinColumn(name = "IDEXAMINACION", referencedColumnName = "IDEXAMINACION")
    @ManyToOne(optional = false)
    private Examinacion idexaminacion;
    @JoinColumn(name = "IDEXAMEN", referencedColumnName = "IDEXAMEN")
    @ManyToOne(optional = false)
    private Examen idexamen;

    public Resultadosexamen() {
    }

    public Resultadosexamen(Integer idresultadosexamen) {
        this.idresultadosexamen = idresultadosexamen;
    }

    public Integer getIdresultadosexamen() {
        return idresultadosexamen;
    }

    public void setIdresultadosexamen(Integer idresultadosexamen) {
        this.idresultadosexamen = idresultadosexamen;
    }

    public String getElementoexamen() {
        return elementoexamen;
    }

    public void setElementoexamen(String elementoexamen) {
        this.elementoexamen = elementoexamen;
    }

    public BigDecimal getDatoelementoexamen() {
        return datoelementoexamen;
    }

    public void setDatoelementoexamen(BigDecimal datoelementoexamen) {
        this.datoelementoexamen = datoelementoexamen;
    }

    public BigDecimal getValorminrefelemexamen() {
        return valorminrefelemexamen;
    }

    public void setValorminrefelemexamen(BigDecimal valorminrefelemexamen) {
        this.valorminrefelemexamen = valorminrefelemexamen;
    }

    public BigDecimal getValormaxrefelemexamen() {
        return valormaxrefelemexamen;
    }

    public void setValormaxrefelemexamen(BigDecimal valormaxrefelemexamen) {
        this.valormaxrefelemexamen = valormaxrefelemexamen;
    }

    public Examinacion getIdexaminacion() {
        return idexaminacion;
    }

    public void setIdexaminacion(Examinacion idexaminacion) {
        this.idexaminacion = idexaminacion;
    }

    public Examen getIdexamen() {
        return idexamen;
    }

    public void setIdexamen(Examen idexamen) {
        this.idexamen = idexamen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idresultadosexamen != null ? idresultadosexamen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultadosexamen)) {
            return false;
        }
        Resultadosexamen other = (Resultadosexamen) object;
        if ((this.idresultadosexamen == null && other.idresultadosexamen != null) || (this.idresultadosexamen != null && !this.idresultadosexamen.equals(other.idresultadosexamen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.susolabs.redu.modelo.entidades.Resultadosexamen[ idresultadosexamen=" + idresultadosexamen + " ]";
    }
    
}
