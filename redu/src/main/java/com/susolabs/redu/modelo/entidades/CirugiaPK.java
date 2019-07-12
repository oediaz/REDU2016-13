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
public class CirugiaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTRTAMIENTOCM")
    private int idtrtamientocm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCIRUGIA")
    private int idcirugia;

    public CirugiaPK() {
    }

    public CirugiaPK(int idtrtamientocm, int idcirugia) {
        this.idtrtamientocm = idtrtamientocm;
        this.idcirugia = idcirugia;
    }

    public int getIdtrtamientocm() {
        return idtrtamientocm;
    }

    public void setIdtrtamientocm(int idtrtamientocm) {
        this.idtrtamientocm = idtrtamientocm;
    }

    public int getIdcirugia() {
        return idcirugia;
    }

    public void setIdcirugia(int idcirugia) {
        this.idcirugia = idcirugia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idtrtamientocm;
        hash += (int) idcirugia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CirugiaPK)) {
            return false;
        }
        CirugiaPK other = (CirugiaPK) object;
        if (this.idtrtamientocm != other.idtrtamientocm) {
            return false;
        }
        if (this.idcirugia != other.idcirugia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.susolabs.redu.modelo.entidades.CirugiaPK[ idtrtamientocm=" + idtrtamientocm + ", idcirugia=" + idcirugia + " ]";
    }
    
}
