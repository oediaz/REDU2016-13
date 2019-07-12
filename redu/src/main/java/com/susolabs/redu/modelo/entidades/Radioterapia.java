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
@Table(name = "radioterapia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Radioterapia.findAll", query = "SELECT r FROM Radioterapia r")
    , @NamedQuery(name = "Radioterapia.findByIdtrtamientocm", query = "SELECT r FROM Radioterapia r WHERE r.radioterapiaPK.idtrtamientocm = :idtrtamientocm")
    , @NamedQuery(name = "Radioterapia.findByIdterapiaradioterapia", query = "SELECT r FROM Radioterapia r WHERE r.radioterapiaPK.idterapiaradioterapia = :idterapiaradioterapia")
    , @NamedQuery(name = "Radioterapia.findByFechainicioradioterapia", query = "SELECT r FROM Radioterapia r WHERE r.fechainicioradioterapia = :fechainicioradioterapia")})
public class Radioterapia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RadioterapiaPK radioterapiaPK;
    @Column(name = "FECHAINICIORADIOTERAPIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainicioradioterapia;
    @JoinColumn(name = "IDTRTAMIENTOCM", referencedColumnName = "IDTRTAMIENTOCM", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tratamientocancermama tratamientocancermama;

    public Radioterapia() {
    }

    public Radioterapia(RadioterapiaPK radioterapiaPK) {
        this.radioterapiaPK = radioterapiaPK;
    }

    public Radioterapia(int idtrtamientocm, int idterapiaradioterapia) {
        this.radioterapiaPK = new RadioterapiaPK(idtrtamientocm, idterapiaradioterapia);
    }

    public RadioterapiaPK getRadioterapiaPK() {
        return radioterapiaPK;
    }

    public void setRadioterapiaPK(RadioterapiaPK radioterapiaPK) {
        this.radioterapiaPK = radioterapiaPK;
    }

    public Date getFechainicioradioterapia() {
        return fechainicioradioterapia;
    }

    public void setFechainicioradioterapia(Date fechainicioradioterapia) {
        this.fechainicioradioterapia = fechainicioradioterapia;
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
        hash += (radioterapiaPK != null ? radioterapiaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Radioterapia)) {
            return false;
        }
        Radioterapia other = (Radioterapia) object;
        if ((this.radioterapiaPK == null && other.radioterapiaPK != null) || (this.radioterapiaPK != null && !this.radioterapiaPK.equals(other.radioterapiaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.susolabs.redu.modelo.entidades.Radioterapia[ radioterapiaPK=" + radioterapiaPK + " ]";
    }
    
}
