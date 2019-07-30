/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.susolabs.redu.modelo.entidades;

import java.io.Serializable;
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
@Table(name = "tratamientocancermama")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tratamientocancermama.findAll", query = "SELECT t FROM Tratamientocancermama t")
    , @NamedQuery(name = "Tratamientocancermama.findByIdtrtamientocm", query = "SELECT t FROM Tratamientocancermama t WHERE t.idtrtamientocm = :idtrtamientocm")
    , @NamedQuery(name = "Tratamientocancermama.findByFechainiciotcm", query = "SELECT t FROM Tratamientocancermama t WHERE t.fechainiciotcm = :fechainiciotcm")
    , @NamedQuery(name = "Tratamientocancermama.findByDescripciontcm", query = "SELECT t FROM Tratamientocancermama t WHERE t.descripciontcm = :descripciontcm")
    , @NamedQuery(name = "Tratamientocancermama.findByObservaciontcm", query = "SELECT t FROM Tratamientocancermama t WHERE t.observaciontcm = :observaciontcm")})
public class Tratamientocancermama implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTRTAMIENTOCM")
    private Integer idtrtamientocm;
    @Column(name = "FECHAINICIOTCM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainiciotcm;
    @Size(max = 64)
    @Column(name = "DESCRIPCIONTCM")
    private String descripciontcm;
    @Size(max = 64)
    @Column(name = "OBSERVACIONTCM")
    private String observaciontcm;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtrtamientocm")
    private List<Biopsia> biopsiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtrtamientocm")
    private List<Cirugia> cirugiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtrtamientocm")
    private List<Radioterapia> radioterapiaList;
    @JoinColumn(name = "IDBIRADS", referencedColumnName = "IDBIRADS")
    @ManyToOne(optional = false)
    private Birads idbirads;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtrtamientocm")
    private List<Quimioterapia> quimioterapiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtrtamientocm")
    private List<Medicacion> medicacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtrtamientocm")
    private List<Examinacion> examinacionList;

    public Tratamientocancermama() {
    }

    public Tratamientocancermama(Integer idtrtamientocm) {
        this.idtrtamientocm = idtrtamientocm;
    }

    public Integer getIdtrtamientocm() {
        return idtrtamientocm;
    }

    public void setIdtrtamientocm(Integer idtrtamientocm) {
        this.idtrtamientocm = idtrtamientocm;
    }

    public Date getFechainiciotcm() {
        return fechainiciotcm;
    }

    public void setFechainiciotcm(Date fechainiciotcm) {
        this.fechainiciotcm = fechainiciotcm;
    }

    public String getDescripciontcm() {
        return descripciontcm;
    }

    public void setDescripciontcm(String descripciontcm) {
        this.descripciontcm = descripciontcm;
    }

    public String getObservaciontcm() {
        return observaciontcm;
    }

    public void setObservaciontcm(String observaciontcm) {
        this.observaciontcm = observaciontcm;
    }

    @XmlTransient
    public List<Biopsia> getBiopsiaList() {
        return biopsiaList;
    }

    public void setBiopsiaList(List<Biopsia> biopsiaList) {
        this.biopsiaList = biopsiaList;
    }

    @XmlTransient
    public List<Cirugia> getCirugiaList() {
        return cirugiaList;
    }

    public void setCirugiaList(List<Cirugia> cirugiaList) {
        this.cirugiaList = cirugiaList;
    }

    @XmlTransient
    public List<Radioterapia> getRadioterapiaList() {
        return radioterapiaList;
    }

    public void setRadioterapiaList(List<Radioterapia> radioterapiaList) {
        this.radioterapiaList = radioterapiaList;
    }

    public Birads getIdbirads() {
        return idbirads;
    }

    public void setIdbirads(Birads idbirads) {
        this.idbirads = idbirads;
    }

    @XmlTransient
    public List<Quimioterapia> getQuimioterapiaList() {
        return quimioterapiaList;
    }

    public void setQuimioterapiaList(List<Quimioterapia> quimioterapiaList) {
        this.quimioterapiaList = quimioterapiaList;
    }

    @XmlTransient
    public List<Medicacion> getMedicacionList() {
        return medicacionList;
    }

    public void setMedicacionList(List<Medicacion> medicacionList) {
        this.medicacionList = medicacionList;
    }

    @XmlTransient
    public List<Examinacion> getExaminacionList() {
        return examinacionList;
    }

    public void setExaminacionList(List<Examinacion> examinacionList) {
        this.examinacionList = examinacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtrtamientocm != null ? idtrtamientocm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tratamientocancermama)) {
            return false;
        }
        Tratamientocancermama other = (Tratamientocancermama) object;
        if ((this.idtrtamientocm == null && other.idtrtamientocm != null) || (this.idtrtamientocm != null && !this.idtrtamientocm.equals(other.idtrtamientocm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.susolabs.redu.modelo.entidades.Tratamientocancermama[ idtrtamientocm=" + idtrtamientocm + " ]";
    }
    
}
