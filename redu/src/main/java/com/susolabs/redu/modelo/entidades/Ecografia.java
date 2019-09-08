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
@Table(name = "ecografia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ecografia.findAll", query = "SELECT e FROM Ecografia e")
    , @NamedQuery(name = "Ecografia.findByIdecografia", query = "SELECT e FROM Ecografia e WHERE e.idecografia = :idecografia")
    , @NamedQuery(name = "Ecografia.findByFechaecografia", query = "SELECT e FROM Ecografia e WHERE e.fechaecografia = :fechaecografia")
    , @NamedQuery(name = "Ecografia.findByDescripcionecografia", query = "SELECT e FROM Ecografia e WHERE e.descripcionecografia = :descripcionecografia")
    , @NamedQuery(name = "Ecografia.findByRazonecografia", query = "SELECT e FROM Ecografia e WHERE e.razonecografia = :razonecografia")
    , @NamedQuery(name = "Ecografia.findByObservacionecografia", query = "SELECT e FROM Ecografia e WHERE e.observacionecografia = :observacionecografia")
    , @NamedQuery(name = "Ecografia.findByProtocoloecografia", query = "SELECT e FROM Ecografia e WHERE e.protocoloecografia = :protocoloecografia")
    , @NamedQuery(name = "Ecografia.findByObservacionesprotocoloe", query = "SELECT e FROM Ecografia e WHERE e.observacionesprotocoloe = :observacionesprotocoloe")})
public class Ecografia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDECOGRAFIA")
    private Integer idecografia;
    @Column(name = "FECHAECOGRAFIA")
    @Temporal(TemporalType.DATE)
    private Date fechaecografia = new Date();
    @Size(max = 64)
    @Column(name = "DESCRIPCIONECOGRAFIA")
    private String descripcionecografia;
    @Size(max = 32)
    @Column(name = "RAZONECOGRAFIA")
    private String razonecografia;
    @Size(max = 32)
    @Column(name = "OBSERVACIONECOGRAFIA")
    private String observacionecografia;
    @Size(max = 32)
    @Column(name = "PROTOCOLOECOGRAFIA")
    private String protocoloecografia;
    @Size(max = 64)
    @Column(name = "OBSERVACIONESPROTOCOLOE")
    private String observacionesprotocoloe;
    @OneToMany(mappedBy = "idecografia")
    private List<Resultadosecografia> resultadosecografiaList;
    @JoinColumn(name = "IDSCREENING", referencedColumnName = "IDSCREENING")
    @ManyToOne(optional = false)
    private Screening idscreening;
    @JoinColumn(name = "IDRESPONSABLEI", referencedColumnName = "IDRESPONSABLEI")
    @ManyToOne(optional = false)
    private Responsableimagen idresponsablei;
    @JoinColumn(name = "IDLABORATORIO", referencedColumnName = "IDLABORATORIO")
    @ManyToOne(optional = false)
    private Laboratorio idlaboratorio;

    public Ecografia() {
    }

    public Ecografia(Integer idecografia) {
        this.idecografia = idecografia;
    }

    public Integer getIdecografia() {
        return idecografia;
    }

    public void setIdecografia(Integer idecografia) {
        this.idecografia = idecografia;
    }

    public Date getFechaecografia() {
        this.fechaecografia = new Date();
        return fechaecografia;
    }

    public void setFechaecografia(Date fechaecografia) {
        this.fechaecografia = new Date();
    }

    public String getDescripcionecografia() {
        return descripcionecografia;
    }

    public void setDescripcionecografia(String descripcionecografia) {
        this.descripcionecografia = descripcionecografia;
    }

    public String getRazonecografia() {
        return razonecografia;
    }

    public void setRazonecografia(String razonecografia) {
        this.razonecografia = razonecografia;
    }

    public String getObservacionecografia() {
        return observacionecografia;
    }

    public void setObservacionecografia(String observacionecografia) {
        this.observacionecografia = observacionecografia;
    }

    public String getProtocoloecografia() {
        return protocoloecografia;
    }

    public void setProtocoloecografia(String protocoloecografia) {
        this.protocoloecografia = protocoloecografia;
    }

    public String getObservacionesprotocoloe() {
        return observacionesprotocoloe;
    }

    public void setObservacionesprotocoloe(String observacionesprotocoloe) {
        this.observacionesprotocoloe = observacionesprotocoloe;
    }

    @XmlTransient
    public List<Resultadosecografia> getResultadosecografiaList() {
        return resultadosecografiaList;
    }

    public void setResultadosecografiaList(List<Resultadosecografia> resultadosecografiaList) {
        this.resultadosecografiaList = resultadosecografiaList;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idecografia != null ? idecografia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ecografia)) {
            return false;
        }
        Ecografia other = (Ecografia) object;
        if ((this.idecografia == null && other.idecografia != null) || (this.idecografia != null && !this.idecografia.equals(other.idecografia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String dato = "" + new SimpleDateFormat("dd-MM-yyyy").format(fechaecografia);
        String fecha = dato.replace('-', '/');
        return "" + fecha + "-" + idecografia;
    }

}
