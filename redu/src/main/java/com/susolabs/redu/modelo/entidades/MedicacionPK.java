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
public class MedicacionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTRTAMIENTOCM")
    private int idtrtamientocm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDMEDICACION")
    private int idmedicacion;

    public MedicacionPK() {
    }

    public MedicacionPK(int idtrtamientocm, int idmedicacion) {
        this.idtrtamientocm = idtrtamientocm;
        this.idmedicacion = idmedicacion;
    }

    public int getIdtrtamientocm() {
        return idtrtamientocm;
    }

    public void setIdtrtamientocm(int idtrtamientocm) {
        this.idtrtamientocm = idtrtamientocm;
    }

    public int getIdmedicacion() {
        return idmedicacion;
    }

    public void setIdmedicacion(int idmedicacion) {
        this.idmedicacion = idmedicacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idtrtamientocm;
        hash += (int) idmedicacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicacionPK)) {
            return false;
        }
        MedicacionPK other = (MedicacionPK) object;
        if (this.idtrtamientocm != other.idtrtamientocm) {
            return false;
        }
        if (this.idmedicacion != other.idmedicacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.susolabs.redu.modelo.entidades.MedicacionPK[ idtrtamientocm=" + idtrtamientocm + ", idmedicacion=" + idmedicacion + " ]";
    }
    
}
