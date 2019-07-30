/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.susolabs.redu.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PEPE
 */
@Entity
@Table(name = "resultadosresonanciamagnetica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resultadosresonanciamagnetica.findAll", query = "SELECT r FROM Resultadosresonanciamagnetica r")
    , @NamedQuery(name = "Resultadosresonanciamagnetica.findByIdresultadorm", query = "SELECT r FROM Resultadosresonanciamagnetica r WHERE r.idresultadorm = :idresultadorm")
    , @NamedQuery(name = "Resultadosresonanciamagnetica.findByTipohallazgormm", query = "SELECT r FROM Resultadosresonanciamagnetica r WHERE r.tipohallazgormm = :tipohallazgormm")
    , @NamedQuery(name = "Resultadosresonanciamagnetica.findByDescripcionhallazgorrm", query = "SELECT r FROM Resultadosresonanciamagnetica r WHERE r.descripcionhallazgorrm = :descripcionhallazgorrm")})
public class Resultadosresonanciamagnetica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDRESULTADORM")
    private Integer idresultadorm;
    @Size(max = 32)
    @Column(name = "TIPOHALLAZGORMM")
    private String tipohallazgormm;
    @Size(max = 64)
    @Column(name = "DESCRIPCIONHALLAZGORRM")
    private String descripcionhallazgorrm;
    @JoinColumn(name = "IDRESONANCIAMAGNETICA", referencedColumnName = "IDRESONANCIAMAGNETICA")
    @ManyToOne(optional = false)
    private Resonanciamagnetica idresonanciamagnetica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idresultadorm")
    private List<Birads> biradsList;

    public Resultadosresonanciamagnetica() {
    }

    public Resultadosresonanciamagnetica(Integer idresultadorm) {
        this.idresultadorm = idresultadorm;
    }

    public Integer getIdresultadorm() {
        return idresultadorm;
    }

    public void setIdresultadorm(Integer idresultadorm) {
        this.idresultadorm = idresultadorm;
    }

    public String getTipohallazgormm() {
        return tipohallazgormm;
    }

    public void setTipohallazgormm(String tipohallazgormm) {
        this.tipohallazgormm = tipohallazgormm;
    }

    public String getDescripcionhallazgorrm() {
        return descripcionhallazgorrm;
    }

    public void setDescripcionhallazgorrm(String descripcionhallazgorrm) {
        this.descripcionhallazgorrm = descripcionhallazgorrm;
    }

    public Resonanciamagnetica getIdresonanciamagnetica() {
        return idresonanciamagnetica;
    }

    public void setIdresonanciamagnetica(Resonanciamagnetica idresonanciamagnetica) {
        this.idresonanciamagnetica = idresonanciamagnetica;
    }

    @XmlTransient
    public List<Birads> getBiradsList() {
        return biradsList;
    }

    public void setBiradsList(List<Birads> biradsList) {
        this.biradsList = biradsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idresultadorm != null ? idresultadorm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultadosresonanciamagnetica)) {
            return false;
        }
        Resultadosresonanciamagnetica other = (Resultadosresonanciamagnetica) object;
        if ((this.idresultadorm == null && other.idresultadorm != null) || (this.idresultadorm != null && !this.idresultadorm.equals(other.idresultadorm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.susolabs.redu.modelo.entidades.Resultadosresonanciamagnetica[ idresultadorm=" + idresultadorm + " ]";
    }
    
}
