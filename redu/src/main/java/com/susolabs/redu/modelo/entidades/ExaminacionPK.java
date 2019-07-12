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
public class ExaminacionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTRTAMIENTOCM")
    private int idtrtamientocm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDEXAMINACION")
    private int idexaminacion;

    public ExaminacionPK() {
    }

    public ExaminacionPK(int idtrtamientocm, int idexaminacion) {
        this.idtrtamientocm = idtrtamientocm;
        this.idexaminacion = idexaminacion;
    }

    public int getIdtrtamientocm() {
        return idtrtamientocm;
    }

    public void setIdtrtamientocm(int idtrtamientocm) {
        this.idtrtamientocm = idtrtamientocm;
    }

    public int getIdexaminacion() {
        return idexaminacion;
    }

    public void setIdexaminacion(int idexaminacion) {
        this.idexaminacion = idexaminacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idtrtamientocm;
        hash += (int) idexaminacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExaminacionPK)) {
            return false;
        }
        ExaminacionPK other = (ExaminacionPK) object;
        if (this.idtrtamientocm != other.idtrtamientocm) {
            return false;
        }
        if (this.idexaminacion != other.idexaminacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.susolabs.redu.modelo.entidades.ExaminacionPK[ idtrtamientocm=" + idtrtamientocm + ", idexaminacion=" + idexaminacion + " ]";
    }
    
}
