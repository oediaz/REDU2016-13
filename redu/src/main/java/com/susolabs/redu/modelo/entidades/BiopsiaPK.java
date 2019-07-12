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
public class BiopsiaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTRTAMIENTOCM")
    private int idtrtamientocm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDBIOPSIA")
    private int idbiopsia;

    public BiopsiaPK() {
    }

    public BiopsiaPK(int idtrtamientocm, int idbiopsia) {
        this.idtrtamientocm = idtrtamientocm;
        this.idbiopsia = idbiopsia;
    }

    public int getIdtrtamientocm() {
        return idtrtamientocm;
    }

    public void setIdtrtamientocm(int idtrtamientocm) {
        this.idtrtamientocm = idtrtamientocm;
    }

    public int getIdbiopsia() {
        return idbiopsia;
    }

    public void setIdbiopsia(int idbiopsia) {
        this.idbiopsia = idbiopsia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idtrtamientocm;
        hash += (int) idbiopsia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BiopsiaPK)) {
            return false;
        }
        BiopsiaPK other = (BiopsiaPK) object;
        if (this.idtrtamientocm != other.idtrtamientocm) {
            return false;
        }
        if (this.idbiopsia != other.idbiopsia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.susolabs.redu.modelo.entidades.BiopsiaPK[ idtrtamientocm=" + idtrtamientocm + ", idbiopsia=" + idbiopsia + " ]";
    }
    
}
