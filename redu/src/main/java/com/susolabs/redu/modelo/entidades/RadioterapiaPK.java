/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.susolabs.redu.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author t4nk
 */
@Embeddable
public class RadioterapiaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTRTAMIENTOCM")
    private int idtrtamientocm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTERAPIARADIOTERAPIA")
    private int idterapiaradioterapia;

    public RadioterapiaPK() {
    }

    public RadioterapiaPK(int idtrtamientocm, int idterapiaradioterapia) {
        this.idtrtamientocm = idtrtamientocm;
        this.idterapiaradioterapia = idterapiaradioterapia;
    }

    public int getIdtrtamientocm() {
        return idtrtamientocm;
    }

    public void setIdtrtamientocm(int idtrtamientocm) {
        this.idtrtamientocm = idtrtamientocm;
    }

    public int getIdterapiaradioterapia() {
        return idterapiaradioterapia;
    }

    public void setIdterapiaradioterapia(int idterapiaradioterapia) {
        this.idterapiaradioterapia = idterapiaradioterapia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idtrtamientocm;
        hash += (int) idterapiaradioterapia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RadioterapiaPK)) {
            return false;
        }
        RadioterapiaPK other = (RadioterapiaPK) object;
        if (this.idtrtamientocm != other.idtrtamientocm) {
            return false;
        }
        if (this.idterapiaradioterapia != other.idterapiaradioterapia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.susolabs.redu.modelo.entidades.RadioterapiaPK[ idtrtamientocm=" + idtrtamientocm + ", idterapiaradioterapia=" + idterapiaradioterapia + " ]";
    }
    
}
