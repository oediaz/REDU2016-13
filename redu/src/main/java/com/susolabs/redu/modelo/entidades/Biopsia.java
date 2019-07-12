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
@Table(name = "biopsia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Biopsia.findAll", query = "SELECT b FROM Biopsia b")
    , @NamedQuery(name = "Biopsia.findByIdtrtamientocm", query = "SELECT b FROM Biopsia b WHERE b.biopsiaPK.idtrtamientocm = :idtrtamientocm")
    , @NamedQuery(name = "Biopsia.findByIdbiopsia", query = "SELECT b FROM Biopsia b WHERE b.biopsiaPK.idbiopsia = :idbiopsia")
    , @NamedQuery(name = "Biopsia.findByFechabiopsia", query = "SELECT b FROM Biopsia b WHERE b.fechabiopsia = :fechabiopsia")})
public class Biopsia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BiopsiaPK biopsiaPK;
    @Column(name = "FECHABIOPSIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechabiopsia;
    @JoinColumn(name = "IDTRTAMIENTOCM", referencedColumnName = "IDTRTAMIENTOCM", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tratamientocancermama tratamientocancermama;

    public Biopsia() {
    }

    public Biopsia(BiopsiaPK biopsiaPK) {
        this.biopsiaPK = biopsiaPK;
    }

    public Biopsia(int idtrtamientocm, int idbiopsia) {
        this.biopsiaPK = new BiopsiaPK(idtrtamientocm, idbiopsia);
    }

    public BiopsiaPK getBiopsiaPK() {
        return biopsiaPK;
    }

    public void setBiopsiaPK(BiopsiaPK biopsiaPK) {
        this.biopsiaPK = biopsiaPK;
    }

    public Date getFechabiopsia() {
        return fechabiopsia;
    }

    public void setFechabiopsia(Date fechabiopsia) {
        this.fechabiopsia = fechabiopsia;
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
        hash += (biopsiaPK != null ? biopsiaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Biopsia)) {
            return false;
        }
        Biopsia other = (Biopsia) object;
        if ((this.biopsiaPK == null && other.biopsiaPK != null) || (this.biopsiaPK != null && !this.biopsiaPK.equals(other.biopsiaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.susolabs.redu.modelo.entidades.Biopsia[ biopsiaPK=" + biopsiaPK + " ]";
    }
    
}
