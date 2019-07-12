/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.susolabs.redu.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
 * @author t4nk
 */
@Entity
@Table(name = "cirugia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cirugia.findAll", query = "SELECT c FROM Cirugia c")
    , @NamedQuery(name = "Cirugia.findByIdtrtamientocm", query = "SELECT c FROM Cirugia c WHERE c.cirugiaPK.idtrtamientocm = :idtrtamientocm")
    , @NamedQuery(name = "Cirugia.findByIdcirugia", query = "SELECT c FROM Cirugia c WHERE c.cirugiaPK.idcirugia = :idcirugia")
    , @NamedQuery(name = "Cirugia.findByFechainiciocirugia", query = "SELECT c FROM Cirugia c WHERE c.fechainiciocirugia = :fechainiciocirugia")})
public class Cirugia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CirugiaPK cirugiaPK;
    @Column(name = "FECHAINICIOCIRUGIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainiciocirugia;
    @JoinColumn(name = "IDTRTAMIENTOCM", referencedColumnName = "IDTRTAMIENTOCM", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tratamientocancermama tratamientocancermama;

    public Cirugia() {
    }

    public Cirugia(CirugiaPK cirugiaPK) {
        this.cirugiaPK = cirugiaPK;
    }

    public Cirugia(int idtrtamientocm, int idcirugia) {
        this.cirugiaPK = new CirugiaPK(idtrtamientocm, idcirugia);
    }

    public CirugiaPK getCirugiaPK() {
        return cirugiaPK;
    }

    public void setCirugiaPK(CirugiaPK cirugiaPK) {
        this.cirugiaPK = cirugiaPK;
    }

    public Date getFechainiciocirugia() {
        return fechainiciocirugia;
    }

    public void setFechainiciocirugia(Date fechainiciocirugia) {
        this.fechainiciocirugia = fechainiciocirugia;
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
        hash += (cirugiaPK != null ? cirugiaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cirugia)) {
            return false;
        }
        Cirugia other = (Cirugia) object;
        if ((this.cirugiaPK == null && other.cirugiaPK != null) || (this.cirugiaPK != null && !this.cirugiaPK.equals(other.cirugiaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.susolabs.redu.modelo.entidades.Cirugia[ cirugiaPK=" + cirugiaPK + " ]";
    }
    
}
