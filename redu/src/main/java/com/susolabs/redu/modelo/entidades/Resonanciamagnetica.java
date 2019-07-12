/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.susolabs.redu.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
 * @author t4nk
 */
@Entity
@Table(name = "resonanciamagnetica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resonanciamagnetica.findAll", query = "SELECT r FROM Resonanciamagnetica r")
    , @NamedQuery(name = "Resonanciamagnetica.findByIdscreening", query = "SELECT r FROM Resonanciamagnetica r WHERE r.resonanciamagneticaPK.idscreening = :idscreening")
    , @NamedQuery(name = "Resonanciamagnetica.findByIdresponsablei", query = "SELECT r FROM Resonanciamagnetica r WHERE r.resonanciamagneticaPK.idresponsablei = :idresponsablei")
    , @NamedQuery(name = "Resonanciamagnetica.findByIdlaboratorio", query = "SELECT r FROM Resonanciamagnetica r WHERE r.resonanciamagneticaPK.idlaboratorio = :idlaboratorio")
    , @NamedQuery(name = "Resonanciamagnetica.findByIdresonanciamagnetica", query = "SELECT r FROM Resonanciamagnetica r WHERE r.resonanciamagneticaPK.idresonanciamagnetica = :idresonanciamagnetica")
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
    @EmbeddedId
    protected ResonanciamagneticaPK resonanciamagneticaPK;
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
    @OneToMany(mappedBy = "resonanciamagnetica")
    private List<Resultadosresonanciamagnetica> resultadosresonanciamagneticaList;
    @JoinColumn(name = "IDSCREENING", referencedColumnName = "IDSCREENING", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Screening screening;
    @JoinColumn(name = "IDRESPONSABLEI", referencedColumnName = "IDRESPONSABLEI", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Responsableimagen responsableimagen;
    @JoinColumn(name = "IDLABORATORIO", referencedColumnName = "IDLABORATORIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Laboratorio laboratorio;

    public Resonanciamagnetica() {
    }

    public Resonanciamagnetica(ResonanciamagneticaPK resonanciamagneticaPK) {
        this.resonanciamagneticaPK = resonanciamagneticaPK;
    }

    public Resonanciamagnetica(int idscreening, int idresponsablei, int idlaboratorio, int idresonanciamagnetica) {
        this.resonanciamagneticaPK = new ResonanciamagneticaPK(idscreening, idresponsablei, idlaboratorio, idresonanciamagnetica);
    }

    public ResonanciamagneticaPK getResonanciamagneticaPK() {
        return resonanciamagneticaPK;
    }

    public void setResonanciamagneticaPK(ResonanciamagneticaPK resonanciamagneticaPK) {
        this.resonanciamagneticaPK = resonanciamagneticaPK;
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

    @XmlTransient
    public List<Resultadosresonanciamagnetica> getResultadosresonanciamagneticaList() {
        return resultadosresonanciamagneticaList;
    }

    public void setResultadosresonanciamagneticaList(List<Resultadosresonanciamagnetica> resultadosresonanciamagneticaList) {
        this.resultadosresonanciamagneticaList = resultadosresonanciamagneticaList;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public Responsableimagen getResponsableimagen() {
        return responsableimagen;
    }

    public void setResponsableimagen(Responsableimagen responsableimagen) {
        this.responsableimagen = responsableimagen;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resonanciamagneticaPK != null ? resonanciamagneticaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resonanciamagnetica)) {
            return false;
        }
        Resonanciamagnetica other = (Resonanciamagnetica) object;
        if ((this.resonanciamagneticaPK == null && other.resonanciamagneticaPK != null) || (this.resonanciamagneticaPK != null && !this.resonanciamagneticaPK.equals(other.resonanciamagneticaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return resonanciamagneticaPK +", Screening:"+screening.toString();
    }
    
}
