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
@Table(name = "ecografia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ecografia.findAll", query = "SELECT e FROM Ecografia e")
    , @NamedQuery(name = "Ecografia.findByIdscreening", query = "SELECT e FROM Ecografia e WHERE e.ecografiaPK.idscreening = :idscreening")
    , @NamedQuery(name = "Ecografia.findByIdresponsablei", query = "SELECT e FROM Ecografia e WHERE e.ecografiaPK.idresponsablei = :idresponsablei")
    , @NamedQuery(name = "Ecografia.findByIdlaboratorio", query = "SELECT e FROM Ecografia e WHERE e.ecografiaPK.idlaboratorio = :idlaboratorio")
    , @NamedQuery(name = "Ecografia.findByIdecografia", query = "SELECT e FROM Ecografia e WHERE e.ecografiaPK.idecografia = :idecografia")
    , @NamedQuery(name = "Ecografia.findByFechaecografia", query = "SELECT e FROM Ecografia e WHERE e.fechaecografia = :fechaecografia")
    , @NamedQuery(name = "Ecografia.findByDescripcionecografia", query = "SELECT e FROM Ecografia e WHERE e.descripcionecografia = :descripcionecografia")
    , @NamedQuery(name = "Ecografia.findByRazonecografia", query = "SELECT e FROM Ecografia e WHERE e.razonecografia = :razonecografia")
    , @NamedQuery(name = "Ecografia.findByObservacionecografia", query = "SELECT e FROM Ecografia e WHERE e.observacionecografia = :observacionecografia")
    , @NamedQuery(name = "Ecografia.findByProtocoloecografia", query = "SELECT e FROM Ecografia e WHERE e.protocoloecografia = :protocoloecografia")
    , @NamedQuery(name = "Ecografia.findByObservacionesprotocoloe", query = "SELECT e FROM Ecografia e WHERE e.observacionesprotocoloe = :observacionesprotocoloe")})
public class Ecografia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EcografiaPK ecografiaPK;
    @Column(name = "FECHAECOGRAFIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaecografia;
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
    @JoinColumn(name = "IDSCREENING", referencedColumnName = "IDSCREENING", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Screening screening;
    @JoinColumn(name = "IDRESPONSABLEI", referencedColumnName = "IDRESPONSABLEI", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Responsableimagen responsableimagen;
    @JoinColumn(name = "IDLABORATORIO", referencedColumnName = "IDLABORATORIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Laboratorio laboratorio;
    @OneToMany(mappedBy = "ecografia")
    private List<Resultadosecografia> resultadosecografiaList;

    public Ecografia() {
    }

    public Ecografia(EcografiaPK ecografiaPK) {
        this.ecografiaPK = ecografiaPK;
    }

    public Ecografia(int idscreening, int idresponsablei, int idlaboratorio, int idecografia) {
        this.ecografiaPK = new EcografiaPK(idscreening, idresponsablei, idlaboratorio, idecografia);
    }

    public EcografiaPK getEcografiaPK() {
        return ecografiaPK;
    }

    public void setEcografiaPK(EcografiaPK ecografiaPK) {
        this.ecografiaPK = ecografiaPK;
    }

    public Date getFechaecografia() {
        return fechaecografia;
    }

    public void setFechaecografia(Date fechaecografia) {
        this.fechaecografia = fechaecografia;
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

    @XmlTransient
    public List<Resultadosecografia> getResultadosecografiaList() {
        return resultadosecografiaList;
    }

    public void setResultadosecografiaList(List<Resultadosecografia> resultadosecografiaList) {
        this.resultadosecografiaList = resultadosecografiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ecografiaPK != null ? ecografiaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ecografia)) {
            return false;
        }
        Ecografia other = (Ecografia) object;
        if ((this.ecografiaPK == null && other.ecografiaPK != null) || (this.ecografiaPK != null && !this.ecografiaPK.equals(other.ecografiaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ecografiaPK +", Screening:"+screening.toString();
    }
    
}
