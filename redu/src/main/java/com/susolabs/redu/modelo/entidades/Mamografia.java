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
@Table(name = "mamografia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mamografia.findAll", query = "SELECT m FROM Mamografia m")
    , @NamedQuery(name = "Mamografia.findByIdmamografia", query = "SELECT m FROM Mamografia m WHERE m.idmamografia = :idmamografia")
    , @NamedQuery(name = "Mamografia.findByFechamamografia", query = "SELECT m FROM Mamografia m WHERE m.fechamamografia = :fechamamografia")
    , @NamedQuery(name = "Mamografia.findByCaracteristicapredominantem", query = "SELECT m FROM Mamografia m WHERE m.caracteristicapredominantem = :caracteristicapredominantem")
    , @NamedQuery(name = "Mamografia.findByPatrondensidadm", query = "SELECT m FROM Mamografia m WHERE m.patrondensidadm = :patrondensidadm")
    , @NamedQuery(name = "Mamografia.findByPatrongrasam", query = "SELECT m FROM Mamografia m WHERE m.patrongrasam = :patrongrasam")
    , @NamedQuery(name = "Mamografia.findByEstimacionvisualdensidadm", query = "SELECT m FROM Mamografia m WHERE m.estimacionvisualdensidadm = :estimacionvisualdensidadm")
    , @NamedQuery(name = "Mamografia.findByPatronparenquimagrandularm", query = "SELECT m FROM Mamografia m WHERE m.patronparenquimagrandularm = :patronparenquimagrandularm")
    , @NamedQuery(name = "Mamografia.findByProtocolomamografia", query = "SELECT m FROM Mamografia m WHERE m.protocolomamografia = :protocolomamografia")
    , @NamedQuery(name = "Mamografia.findByObservacionesprotocolom", query = "SELECT m FROM Mamografia m WHERE m.observacionesprotocolom = :observacionesprotocolom")})
public class Mamografia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDMAMOGRAFIA")
    private Integer idmamografia;
    @Column(name = "FECHAMAMOGRAFIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamamografia;
    @Size(max = 32)
    @Column(name = "CARACTERISTICAPREDOMINANTEM")
    private String caracteristicapredominantem;
    @Size(max = 32)
    @Column(name = "PATRONDENSIDADM")
    private String patrondensidadm;
    @Size(max = 32)
    @Column(name = "PATRONGRASAM")
    private String patrongrasam;
    @Size(max = 32)
    @Column(name = "ESTIMACIONVISUALDENSIDADM")
    private String estimacionvisualdensidadm;
    @Size(max = 16)
    @Column(name = "PATRONPARENQUIMAGRANDULARM")
    private String patronparenquimagrandularm;
    @Size(max = 32)
    @Column(name = "PROTOCOLOMAMOGRAFIA")
    private String protocolomamografia;
    @Size(max = 64)
    @Column(name = "OBSERVACIONESPROTOCOLOM")
    private String observacionesprotocolom;
    @JoinColumn(name = "IDSCREENING", referencedColumnName = "IDSCREENING")
    @ManyToOne(optional = false)
    private Screening idscreening;
    @JoinColumn(name = "IDRESPONSABLEI", referencedColumnName = "IDRESPONSABLEI")
    @ManyToOne(optional = false)
    private Responsableimagen idresponsablei;
    @JoinColumn(name = "IDLABORATORIO", referencedColumnName = "IDLABORATORIO")
    @ManyToOne(optional = false)
    private Laboratorio idlaboratorio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmamografia")
    private List<Resultadosmamografia> resultadosmamografiaList;

    public Mamografia() {
    }

    public Mamografia(Integer idmamografia) {
        this.idmamografia = idmamografia;
    }

    public Integer getIdmamografia() {
        return idmamografia;
    }

    public void setIdmamografia(Integer idmamografia) {
        this.idmamografia = idmamografia;
    }

    public Date getFechamamografia() {
        return fechamamografia;
    }

    public void setFechamamografia(Date fechamamografia) {
        this.fechamamografia = fechamamografia;
    }

    public String getCaracteristicapredominantem() {
        return caracteristicapredominantem;
    }

    public void setCaracteristicapredominantem(String caracteristicapredominantem) {
        this.caracteristicapredominantem = caracteristicapredominantem;
    }

    public String getPatrondensidadm() {
        return patrondensidadm;
    }

    public void setPatrondensidadm(String patrondensidadm) {
        this.patrondensidadm = patrondensidadm;
    }

    public String getPatrongrasam() {
        return patrongrasam;
    }

    public void setPatrongrasam(String patrongrasam) {
        this.patrongrasam = patrongrasam;
    }

    public String getEstimacionvisualdensidadm() {
        return estimacionvisualdensidadm;
    }

    public void setEstimacionvisualdensidadm(String estimacionvisualdensidadm) {
        this.estimacionvisualdensidadm = estimacionvisualdensidadm;
    }

    public String getPatronparenquimagrandularm() {
        return patronparenquimagrandularm;
    }

    public void setPatronparenquimagrandularm(String patronparenquimagrandularm) {
        this.patronparenquimagrandularm = patronparenquimagrandularm;
    }

    public String getProtocolomamografia() {
        return protocolomamografia;
    }

    public void setProtocolomamografia(String protocolomamografia) {
        this.protocolomamografia = protocolomamografia;
    }

    public String getObservacionesprotocolom() {
        return observacionesprotocolom;
    }

    public void setObservacionesprotocolom(String observacionesprotocolom) {
        this.observacionesprotocolom = observacionesprotocolom;
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
    public List<Resultadosmamografia> getResultadosmamografiaList() {
        return resultadosmamografiaList;
    }

    public void setResultadosmamografiaList(List<Resultadosmamografia> resultadosmamografiaList) {
        this.resultadosmamografiaList = resultadosmamografiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmamografia != null ? idmamografia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mamografia)) {
            return false;
        }
        Mamografia other = (Mamografia) object;
        if ((this.idmamografia == null && other.idmamografia != null) || (this.idmamografia != null && !this.idmamografia.equals(other.idmamografia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
          String dato=""+new SimpleDateFormat("dd-MM-yyyy").format(fechamamografia);
        String fecha=dato.replace('-', '/');
        return "" +fecha  + "-"+idmamografia;
    }
    
}
