/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.susolabs.redu.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PEPE
 */
@Entity
@Table(name = "cirugia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cirugia.findAll", query = "SELECT c FROM Cirugia c")
    , @NamedQuery(name = "Cirugia.findByIdcirugia", query = "SELECT c FROM Cirugia c WHERE c.idcirugia = :idcirugia")
    , @NamedQuery(name = "Cirugia.findByFechainiciocirugia", query = "SELECT c FROM Cirugia c WHERE c.fechainiciocirugia = :fechainiciocirugia")})
public class Cirugia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCIRUGIA")
    private Integer idcirugia;
    @Column(name = "FECHAINICIOCIRUGIA")
    @Temporal(TemporalType.DATE)
    private Date fechainiciocirugia;
    @JoinColumn(name = "IDTRTAMIENTOCM", referencedColumnName = "IDTRTAMIENTOCM")
    @ManyToOne(optional = false)
    private Tratamientocancermama idtrtamientocm;

    public Cirugia() {
    }

    public Cirugia(Integer idcirugia) {
        this.idcirugia = idcirugia;
    }

    public Integer getIdcirugia() {
        return idcirugia;
    }

    public void setIdcirugia(Integer idcirugia) {
        this.idcirugia = idcirugia;
    }

    public Date getFechainiciocirugia() {
        return fechainiciocirugia;
    }

    public void setFechainiciocirugia(Date fechainiciocirugia) {
        this.fechainiciocirugia = fechainiciocirugia;
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
        hash += (idcirugia != null ? idcirugia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cirugia)) {
            return false;
        }
        Cirugia other = (Cirugia) object;
        if ((this.idcirugia == null && other.idcirugia != null) || (this.idcirugia != null && !this.idcirugia.equals(other.idcirugia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.susolabs.redu.modelo.entidades.Cirugia[ idcirugia=" + idcirugia + " ]";
    }
    
}
