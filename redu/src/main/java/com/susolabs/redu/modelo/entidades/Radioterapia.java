/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.susolabs.redu.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author PEPE
 */
@Entity
@Table(name = "radioterapia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Radioterapia.findAll", query = "SELECT r FROM Radioterapia r")
    , @NamedQuery(name = "Radioterapia.findByIdterapiaradioterapia", query = "SELECT r FROM Radioterapia r WHERE r.idterapiaradioterapia = :idterapiaradioterapia")
    , @NamedQuery(name = "Radioterapia.findByFechainicioradioterapia", query = "SELECT r FROM Radioterapia r WHERE r.fechainicioradioterapia = :fechainicioradioterapia")})
public class Radioterapia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTERAPIARADIOTERAPIA")
    private Integer idterapiaradioterapia;
    @Column(name = "FECHAINICIORADIOTERAPIA")
    @Temporal(TemporalType.DATE)
    private Date fechainicioradioterapia;
    @JoinColumn(name = "IDTRTAMIENTOCM", referencedColumnName = "IDTRTAMIENTOCM")
    @ManyToOne(optional = false)
    private Tratamientocancermama idtrtamientocm;

    public Radioterapia() {
    }

    public Radioterapia(Integer idterapiaradioterapia) {
        this.idterapiaradioterapia = idterapiaradioterapia;
    }

    public Integer getIdterapiaradioterapia() {
        return idterapiaradioterapia;
    }

    public void setIdterapiaradioterapia(Integer idterapiaradioterapia) {
        this.idterapiaradioterapia = idterapiaradioterapia;
    }

    public Date getFechainicioradioterapia() {
        return fechainicioradioterapia;
    }

    public void setFechainicioradioterapia(Date fechainicioradioterapia) {
        this.fechainicioradioterapia = fechainicioradioterapia;
    }

    public Tratamientocancermama getIdtrtamientocm() {
        return idtrtamientocm;
    }

    public void setIdtrtamientocm(Tratamientocancermama idtrtamientocm) {
        this.idtrtamientocm = idtrtamientocm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idterapiaradioterapia != null ? idterapiaradioterapia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Radioterapia)) {
            return false;
        }
        Radioterapia other = (Radioterapia) object;
        if ((this.idterapiaradioterapia == null && other.idterapiaradioterapia != null) || (this.idterapiaradioterapia != null && !this.idterapiaradioterapia.equals(other.idterapiaradioterapia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.susolabs.redu.modelo.entidades.Radioterapia[ idterapiaradioterapia=" + idterapiaradioterapia + " ]";
    }
    
}
