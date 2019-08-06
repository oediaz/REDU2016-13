/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.susolabs.redu.modelo.entidades;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PEPE
 */
@Entity
@Table(name = "resonanciamagnetica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resonanciamagnetica.findAll", query = "SELECT r FROM Resonanciamagnetica r")
    , @NamedQuery(name = "Resonanciamagnetica.findByIdresonanciamagnetica", query = "SELECT r FROM Resonanciamagnetica r WHERE r.idresonanciamagnetica = :idresonanciamagnetica")
    , @NamedQuery(name = "Resonanciamagnetica.findByFecharm", query = "SELECT r FROM Resonanciamagnetica r WHERE r.fecharm = :fecharm")
    , @NamedQuery(name = "Resonanciamagnetica.findByDescripcionrm", query = "SELECT r FROM Resonanciamagnetica r WHERE r.descripcionrm = :descripcionrm")
    , @NamedQuery(name = "Resonanciamagnetica.findByRazonrm", query = "SELECT r FROM Resonanciamagnetica r WHERE r.razonrm = :razonrm")
    , @NamedQuery(name = "Resonanciamagnetica.findByObservacionrm", query = "SELECT r FROM Resonanciamagnetica r WHERE r.observacionrm = :observacionrm")
    , @NamedQuery(name = "Resonanciamagnetica.findByIndicacionespecificidadrm", query = "SELECT r FROM Resonanciamagnetica r WHERE r.indicacionespecificidadrm = :indicacionespecificidadrm")
    , @NamedQuery(name = "Resonanciamagnetica.findByPatronreforzamientorm", query = "SELECT r FROM Resonanciamagnetica r WHERE r.patronreforzamientorm = :patronreforzamientorm")
    , @NamedQuery(name = "Resonanciamagnetica.findByProtocolorm", query = "SELECT r FROM Resonanciamagnetica r WHERE r.protocolorm = :protocolorm")
    , @NamedQuery(name = "Resonanciamagnetica.findByObservacionesprotocolorm", query = "SELECT r FROM Resonanciamagnetica r WHERE r.observacionesprotocolorm = :observacionesprotocolorm")})
public class Resonanciamagnetica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDRESONANCIAMAGNETICA")
    private Integer idresonanciamagnetica;
    @Column(name = "FECHARM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharm;
    @Size(max = 64)
    @Column(name = "DESCRIPCIONRM")
    private String descripcionrm;
    @Size(max = 32)
    @Column(name = "RAZONRM")
    private String razonrm;
    @Size(max = 128)
    @Column(name = "OBSERVACIONRM")
    private String observacionrm;
    @Size(max = 64)
    @Column(name = "INDICACIONESPECIFICIDADRM")
    private String indicacionespecificidadrm;
    @Size(max = 16)
    @Column(name = "PATRONREFORZAMIENTORM")
    private String patronreforzamientorm;
    @Size(max = 32)
    @Column(name = "PROTOCOLORM")
    private String protocolorm;
    @Size(max = 64)
    @Column(name = "OBSERVACIONESPROTOCOLORM")
    private String observacionesprotocolorm;
    @JoinColumn(name = "IDSCREENING", referencedColumnName = "IDSCREENING")
    @ManyToOne(optional = false)
    private Screening idscreening;
    @JoinColumn(name = "IDRESPONSABLEI", referencedColumnName = "IDRESPONSABLEI")
    @ManyToOne(optional = false)
    private Responsableimagen idresponsablei;
    @JoinColumn(name = "IDLABORATORIO", referencedColumnName = "IDLABORATORIO")
    @ManyToOne(optional = false)
    private Laboratorio idlaboratorio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idresonanciamagnetica")
    private List<Resultadosresonanciamagnetica> resultadosresonanciamagneticaList;

    public Resonanciamagnetica() {
    }

    public Resonanciamagnetica(Integer idresonanciamagnetica) {
        this.idresonanciamagnetica = idresonanciamagnetica;
    }

    public Integer getIdresonanciamagnetica() {
        return idresonanciamagnetica;
    }

    public void setIdresonanciamagnetica(Integer idresonanciamagnetica) {
        this.idresonanciamagnetica = idresonanciamagnetica;
    }

    public Date getFecharm() {
        return fecharm;
    }

    public void setFecharm(Date fecharm) {
        this.fecharm = fecharm;
    }

    public String getDescripcionrm() {
        return descripcionrm;
    }

    public void setDescripcionrm(String descripcionrm) {
        this.descripcionrm = descripcionrm;
    }

    public String getRazonrm() {
        return razonrm;
    }

    public void setRazonrm(String razonrm) {
        this.razonrm = razonrm;
    }

    public String getObservacionrm() {
        return observacionrm;
    }

    public void setObservacionrm(String observacionrm) {
        this.observacionrm = observacionrm;
    }

    public String getIndicacionespecificidadrm() {
        return indicacionespecificidadrm;
    }

    public void setIndicacionespecificidadrm(String indicacionespecificidadrm) {
        this.indicacionespecificidadrm = indicacionespecificidadrm;
    }

    public String getPatronreforzamientorm() {
        return patronreforzamientorm;
    }

    public void setPatronreforzamientorm(String patronreforzamientorm) {
        this.patronreforzamientorm = patronreforzamientorm;
    }

    public String getProtocolorm() {
        return protocolorm;
    }

    public void setProtocolorm(String protocolorm) {
        this.protocolorm = protocolorm;
    }

    public String getObservacionesprotocolorm() {
        return observacionesprotocolorm;
    }

    public void setObservacionesprotocolorm(String observacionesprotocolorm) {
        this.observacionesprotocolorm = observacionesprotocolorm;
    }

    public Screening getIdscreening() {
        return idscreening;
    }

    public void setIdscreening(Screening idscreening) {
        this.idscreening = idscreening;
    }

    public Responsableimagen getIdresponsablei() {
        return idresponsablei;
    }

    public void setIdresponsablei(Responsableimagen idresponsablei) {
        this.idresponsablei = idresponsablei;
    }

    public Laboratorio getIdlaboratorio() {
        return idlaboratorio;
    }

    public void setIdlaboratorio(Laboratorio idlaboratorio) {
        this.idlaboratorio = idlaboratorio;
    }

    @XmlTransient
    public List<Resultadosresonanciamagnetica> getResultadosresonanciamagneticaList() {
        return resultadosresonanciamagneticaList;
    }

    public void setResultadosresonanciamagneticaList(List<Resultadosresonanciamagnetica> resultadosresonanciamagneticaList) {
        this.resultadosresonanciamagneticaList = resultadosresonanciamagneticaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idresonanciamagnetica != null ? idresonanciamagnetica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resonanciamagnetica)) {
            return false;
        }
        Resonanciamagnetica other = (Resonanciamagnetica) object;
        if ((this.idresonanciamagnetica == null && other.idresonanciamagnetica != null) || (this.idresonanciamagnetica != null && !this.idresonanciamagnetica.equals(other.idresonanciamagnetica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
       String dato=""+new SimpleDateFormat("dd-MM-yyyy").format(fecharm);
        String fecha=dato.replace('-', '/');
        return "" +fecha  + "-"+idresonanciamagnetica;
    }
    
}
