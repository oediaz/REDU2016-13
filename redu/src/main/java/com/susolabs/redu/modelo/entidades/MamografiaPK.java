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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author t4nk
 */
@Embeddable
public class MamografiaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSCREENING")
    private int idscreening;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDRESPONSABLEI")
    private int idresponsablei;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDLABORATORIO")
    private int idlaboratorio;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDMAMOGRAFIA")
    private int idmamografia;

    public MamografiaPK() {
    }

    public MamografiaPK(int idscreening, int idresponsablei, int idlaboratorio, int idmamografia) {
        this.idscreening = idscreening;
        this.idresponsablei = idresponsablei;
        this.idlaboratorio = idlaboratorio;
        this.idmamografia = idmamografia;
    }

    public int getIdscreening() {
        return idscreening;
    }

    public void setIdscreening(int idscreening) {
        this.idscreening = idscreening;
    }

    public int getIdresponsablei() {
        return idresponsablei;
    }

    public void setIdresponsablei(int idresponsablei) {
        this.idresponsablei = idresponsablei;
    }

    public int getIdlaboratorio() {
        return idlaboratorio;
    }

    public void setIdlaboratorio(int idlaboratorio) {
        this.idlaboratorio = idlaboratorio;
    }

    public int getIdmamografia() {
        return idmamografia;
    }

    public void setIdmamografia(int idmamografia) {
        this.idmamografia = idmamografia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idscreening;
        hash += (int) idresponsablei;
        hash += (int) idlaboratorio;
        hash += (int) idmamografia;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MamografiaPK)) {
            return false;
        }
        MamografiaPK other = (MamografiaPK) object;
        if (this.idscreening != other.idscreening) {
            return false;
        }
        if (this.idresponsablei != other.idresponsablei) {
            return false;
        }
        if (this.idlaboratorio != other.idlaboratorio) {
            return false;
        }
        if (this.idmamografia != other.idmamografia) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idmamografia+"";
    }
    
}
