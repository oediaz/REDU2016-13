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
@Table(name = "quimioterapia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quimioterapia.findAll", query = "SELECT q FROM Quimioterapia q")
    , @NamedQuery(name = "Quimioterapia.findByIdquimioterapia", query = "SELECT q FROM Quimioterapia q WHERE q.idquimioterapia = :idquimioterapia")
    , @NamedQuery(name = "Quimioterapia.findByFechainicioquimioterapia", query = "SELECT q FROM Quimioterapia q WHERE q.fechainicioquimioterapia = :fechainicioquimioterapia")})
public class Quimioterapia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDQUIMIOTERAPIA")
    private Integer idquimioterapia;
    @Column(name = "FECHAINICIOQUIMIOTERAPIA")
    @Temporal(TemporalType.DATE)
    private Date fechainicioquimioterapia;
    @JoinColumn(name = "IDTRTAMIENTOCM", referencedColumnName = "IDTRTAMIENTOCM")
    @ManyToOne(optional = false)
    private Tratamientocancermama idtrtamientocm;

    public Quimioterapia() {
    }

    public Quimioterapia(Integer idquimioterapia) {
        this.idquimioterapia = idquimioterapia;
    }

    public Integer getIdquimioterapia() {
        return idquimioterapia;
    }

    public void setIdquimioterapia(Integer idquimioterapia) {
        this.idquimioterapia = idquimioterapia;
    }

    public Date getFechainicioquimioterapia() {
        return fechainicioquimioterapia;
    }

    public void setFechainicioquimioterapia(Date fechainicioquimioterapia) {
        this.fechainicioquimioterapia = fechainicioquimioterapia;
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
        hash += (idquimioterapia != null ? idquimioterapia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quimioterapia)) {
            return false;
        }
        Quimioterapia other = (Quimioterapia) object;
        if ((this.idquimioterapia == null && other.idquimioterapia != null) || (this.idquimioterapia != null && !this.idquimioterapia.equals(other.idquimioterapia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.susolabs.redu.modelo.entidades.Quimioterapia[ idquimioterapia=" + idquimioterapia + " ]";
    }
    
}
