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
@Table(name = "biopsia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Biopsia.findAll", query = "SELECT b FROM Biopsia b")
    , @NamedQuery(name = "Biopsia.findByIdbiopsia", query = "SELECT b FROM Biopsia b WHERE b.idbiopsia = :idbiopsia")
    , @NamedQuery(name = "Biopsia.findByFechabiopsia", query = "SELECT b FROM Biopsia b WHERE b.fechabiopsia = :fechabiopsia")})
public class Biopsia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDBIOPSIA")
    private Integer idbiopsia;
    @Column(name = "FECHABIOPSIA")
    @Temporal(TemporalType.DATE)
    private Date fechabiopsia;
    @JoinColumn(name = "IDTRTAMIENTOCM", referencedColumnName = "IDTRTAMIENTOCM")
    @ManyToOne(optional = false)
    private Tratamientocancermama idtrtamientocm;

    public Biopsia() {
    }

    public Biopsia(Integer idbiopsia) {
        this.idbiopsia = idbiopsia;
    }

    public Integer getIdbiopsia() {
        return idbiopsia;
    }

    public void setIdbiopsia(Integer idbiopsia) {
        this.idbiopsia = idbiopsia;
    }

    public Date getFechabiopsia() {
        return fechabiopsia;
    }

    public void setFechabiopsia(Date fechabiopsia) {
        this.fechabiopsia = fechabiopsia;
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
        hash += (idbiopsia != null ? idbiopsia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Biopsia)) {
            return false;
        }
        Biopsia other = (Biopsia) object;
        if ((this.idbiopsia == null && other.idbiopsia != null) || (this.idbiopsia != null && !this.idbiopsia.equals(other.idbiopsia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+idbiopsia;
    }
    
}
