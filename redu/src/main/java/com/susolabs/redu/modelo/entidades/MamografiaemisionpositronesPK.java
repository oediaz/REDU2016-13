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
import javax.validation.constraints.NotNull;

/**
 *
 * @author t4nk
 */
@Embeddable
public class MamografiaemisionpositronesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDLABORATORIO")
    private int idlaboratorio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSCREENING")
    private int idscreening;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDRESPONSABLEI")
    private int idresponsablei;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDMAMOGRAFIAEP")
    private int idmamografiaep;

    public MamografiaemisionpositronesPK() {
    }

    public MamografiaemisionpositronesPK(int idlaboratorio, int idscreening, int idresponsablei, int idmamografiaep) {
        this.idlaboratorio = idlaboratorio;
        this.idscreening = idscreening;
        this.idresponsablei = idresponsablei;
        this.idmamografiaep = idmamografiaep;
    }

    public int getIdlaboratorio() {
        return idlaboratorio;
    }

    public void setIdlaboratorio(int idlaboratorio) {
        this.idlaboratorio = idlaboratorio;
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

    public int getIdmamografiaep() {
        return idmamografiaep;
    }

    public void setIdmamografiaep(int idmamografiaep) {
        this.idmamografiaep = idmamografiaep;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idlaboratorio;
        hash += (int) idscreening;
        hash += (int) idresponsablei;
        hash += (int) idmamografiaep;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MamografiaemisionpositronesPK)) {
            return false;
        }
        MamografiaemisionpositronesPK other = (MamografiaemisionpositronesPK) object;
        if (this.idlaboratorio != other.idlaboratorio) {
            return false;
        }
        if (this.idscreening != other.idscreening) {
            return false;
        }
        if (this.idresponsablei != other.idresponsablei) {
            return false;
        }
        if (this.idmamografiaep != other.idmamografiaep) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idmamografiaep + "";
    }
    
}
