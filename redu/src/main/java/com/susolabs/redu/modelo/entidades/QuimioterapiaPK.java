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
public class QuimioterapiaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTRTAMIENTOCM")
    private int idtrtamientocm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDQUIMIOTERAPIA")
    private int idquimioterapia;

    public QuimioterapiaPK() {
    }

    public QuimioterapiaPK(int idtrtamientocm, int idquimioterapia) {
        this.idtrtamientocm = idtrtamientocm;
        this.idquimioterapia = idquimioterapia;
    }

    public int getIdtrtamientocm() {
        return idtrtamientocm;
    }

    public void setIdtrtamientocm(int idtrtamientocm) {
        this.idtrtamientocm = idtrtamientocm;
    }

    public int getIdquimioterapia() {
        return idquimioterapia;
    }

    public void setIdquimioterapia(int idquimioterapia) {
        this.idquimioterapia = idquimioterapia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idtrtamientocm;
        hash += (int) idquimioterapia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuimioterapiaPK)) {
            return false;
        }
        QuimioterapiaPK other = (QuimioterapiaPK) object;
        if (this.idtrtamientocm != other.idtrtamientocm) {
            return false;
        }
        if (this.idquimioterapia != other.idquimioterapia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.susolabs.redu.modelo.entidades.QuimioterapiaPK[ idtrtamientocm=" + idtrtamientocm + ", idquimioterapia=" + idquimioterapia + " ]";
    }
    
}
