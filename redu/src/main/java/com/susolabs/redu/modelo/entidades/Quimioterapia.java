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
@Table(name = "quimioterapia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quimioterapia.findAll", query = "SELECT q FROM Quimioterapia q")
    , @NamedQuery(name = "Quimioterapia.findByIdtrtamientocm", query = "SELECT q FROM Quimioterapia q WHERE q.quimioterapiaPK.idtrtamientocm = :idtrtamientocm")
    , @NamedQuery(name = "Quimioterapia.findByIdquimioterapia", query = "SELECT q FROM Quimioterapia q WHERE q.quimioterapiaPK.idquimioterapia = :idquimioterapia")
    , @NamedQuery(name = "Quimioterapia.findByFechainicioquimioterapia", query = "SELECT q FROM Quimioterapia q WHERE q.fechainicioquimioterapia = :fechainicioquimioterapia")})
public class Quimioterapia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected QuimioterapiaPK quimioterapiaPK;
    @Column(name = "FECHAINICIOQUIMIOTERAPIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainicioquimioterapia;
    @JoinColumn(name = "IDTRTAMIENTOCM", referencedColumnName = "IDTRTAMIENTOCM", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tratamientocancermama tratamientocancermama;

    public Quimioterapia() {
    }

    public Quimioterapia(QuimioterapiaPK quimioterapiaPK) {
        this.quimioterapiaPK = quimioterapiaPK;
    }

    public Quimioterapia(int idtrtamientocm, int idquimioterapia) {
        this.quimioterapiaPK = new QuimioterapiaPK(idtrtamientocm, idquimioterapia);
    }

    public QuimioterapiaPK getQuimioterapiaPK() {
        return quimioterapiaPK;
    }

    public void setQuimioterapiaPK(QuimioterapiaPK quimioterapiaPK) {
        this.quimioterapiaPK = quimioterapiaPK;
    }

    public Date getFechainicioquimioterapia() {
        return fechainicioquimioterapia;
    }

    public void setFechainicioquimioterapia(Date fechainicioquimioterapia) {
        this.fechainicioquimioterapia = fechainicioquimioterapia;
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
        hash += (quimioterapiaPK != null ? quimioterapiaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quimioterapia)) {
            return false;
        }
        Quimioterapia other = (Quimioterapia) object;
        if ((this.quimioterapiaPK == null && other.quimioterapiaPK != null) || (this.quimioterapiaPK != null && !this.quimioterapiaPK.equals(other.quimioterapiaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.susolabs.redu.modelo.entidades.Quimioterapia[ quimioterapiaPK=" + quimioterapiaPK + " ]";
    }
    
}
