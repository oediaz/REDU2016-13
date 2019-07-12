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
@Table(name = "mamografiaemisionpositrones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mamografiaemisionpositrones.findAll", query = "SELECT m FROM Mamografiaemisionpositrones m")
    , @NamedQuery(name = "Mamografiaemisionpositrones.findByIdlaboratorio", query = "SELECT m FROM Mamografiaemisionpositrones m WHERE m.mamografiaemisionpositronesPK.idlaboratorio = :idlaboratorio")
    , @NamedQuery(name = "Mamografiaemisionpositrones.findByIdscreening", query = "SELECT m FROM Mamografiaemisionpositrones m WHERE m.mamografiaemisionpositronesPK.idscreening = :idscreening")
    , @NamedQuery(name = "Mamografiaemisionpositrones.findByIdresponsablei", query = "SELECT m FROM Mamografiaemisionpositrones m WHERE m.mamografiaemisionpositronesPK.idresponsablei = :idresponsablei")
    , @NamedQuery(name = "Mamografiaemisionpositrones.findByIdmamografiaep", query = "SELECT m FROM Mamografiaemisionpositrones m WHERE m.mamografiaemisionpositronesPK.idmamografiaep = :idmamografiaep")
    , @NamedQuery(name = "Mamografiaemisionpositrones.findByFechamamografiaep", query = "SELECT m FROM Mamografiaemisionpositrones m WHERE m.fechamamografiaep = :fechamamografiaep")
    , @NamedQuery(name = "Mamografiaemisionpositrones.findByDiagnosticopreviomamografiaep", query = "SELECT m FROM Mamografiaemisionpositrones m WHERE m.diagnosticopreviomamografiaep = :diagnosticopreviomamografiaep")
    , @NamedQuery(name = "Mamografiaemisionpositrones.findByRazonmamografiaep", query = "SELECT m FROM Mamografiaemisionpositrones m WHERE m.razonmamografiaep = :razonmamografiaep")
    , @NamedQuery(name = "Mamografiaemisionpositrones.findBySensibilidadmetastasisep", query = "SELECT m FROM Mamografiaemisionpositrones m WHERE m.sensibilidadmetastasisep = :sensibilidadmetastasisep")
    , @NamedQuery(name = "Mamografiaemisionpositrones.findByEspecificadadmetastasisep", query = "SELECT m FROM Mamografiaemisionpositrones m WHERE m.especificadadmetastasisep = :especificadadmetastasisep")
    , @NamedQuery(name = "Mamografiaemisionpositrones.findByObservacionesmetastasisep", query = "SELECT m FROM Mamografiaemisionpositrones m WHERE m.observacionesmetastasisep = :observacionesmetastasisep")})
public class Mamografiaemisionpositrones implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MamografiaemisionpositronesPK mamografiaemisionpositronesPK;
    @Column(name = "FECHAMAMOGRAFIAEP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamamografiaep;
    @Size(max = 64)
    @Column(name = "DIAGNOSTICOPREVIOMAMOGRAFIAEP")
    private String diagnosticopreviomamografiaep;
    @Size(max = 32)
    @Column(name = "RAZONMAMOGRAFIAEP")
    private String razonmamografiaep;
    @Size(max = 32)
    @Column(name = "SENSIBILIDADMETASTASISEP")
    private String sensibilidadmetastasisep;
    @Size(max = 32)
    @Column(name = "ESPECIFICADADMETASTASISEP")
    private String especificadadmetastasisep;
    @Size(max = 64)
    @Column(name = "OBSERVACIONESMETASTASISEP")
    private String observacionesmetastasisep;
    @OneToMany(mappedBy = "mamografiaemisionpositrones")
    private List<Resultadosmamografiaep> resultadosmamografiaepList;
    @JoinColumn(name = "IDSCREENING", referencedColumnName = "IDSCREENING", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Screening screening;
    @JoinColumn(name = "IDRESPONSABLEI", referencedColumnName = "IDRESPONSABLEI", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Responsableimagen responsableimagen;
    @JoinColumn(name = "IDLABORATORIO", referencedColumnName = "IDLABORATORIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Laboratorio laboratorio;

    public Mamografiaemisionpositrones() {
    }

    public Mamografiaemisionpositrones(MamografiaemisionpositronesPK mamografiaemisionpositronesPK) {
        this.mamografiaemisionpositronesPK = mamografiaemisionpositronesPK;
    }

    public Mamografiaemisionpositrones(int idlaboratorio, int idscreening, int idresponsablei, int idmamografiaep) {
        this.mamografiaemisionpositronesPK = new MamografiaemisionpositronesPK(idlaboratorio, idscreening, idresponsablei, idmamografiaep);
    }

    public MamografiaemisionpositronesPK getMamografiaemisionpositronesPK() {
        return mamografiaemisionpositronesPK;
    }

    public void setMamografiaemisionpositronesPK(MamografiaemisionpositronesPK mamografiaemisionpositronesPK) {
        this.mamografiaemisionpositronesPK = mamografiaemisionpositronesPK;
    }

    public Date getFechamamografiaep() {
        return fechamamografiaep;
    }

    public void setFechamamografiaep(Date fechamamografiaep) {
        this.fechamamografiaep = fechamamografiaep;
    }

    public String getDiagnosticopreviomamografiaep() {
        return diagnosticopreviomamografiaep;
    }

    public void setDiagnosticopreviomamografiaep(String diagnosticopreviomamografiaep) {
        this.diagnosticopreviomamografiaep = diagnosticopreviomamografiaep;
    }

    public String getRazonmamografiaep() {
        return razonmamografiaep;
    }

    public void setRazonmamografiaep(String razonmamografiaep) {
        this.razonmamografiaep = razonmamografiaep;
    }

    public String getSensibilidadmetastasisep() {
        return sensibilidadmetastasisep;
    }

    public void setSensibilidadmetastasisep(String sensibilidadmetastasisep) {
        this.sensibilidadmetastasisep = sensibilidadmetastasisep;
    }

    public String getEspecificadadmetastasisep() {
        return especificadadmetastasisep;
    }

    public void setEspecificadadmetastasisep(String especificadadmetastasisep) {
        this.especificadadmetastasisep = especificadadmetastasisep;
    }

    public String getObservacionesmetastasisep() {
        return observacionesmetastasisep;
    }

    public void setObservacionesmetastasisep(String observacionesmetastasisep) {
        this.observacionesmetastasisep = observacionesmetastasisep;
    }

    @XmlTransient
    public List<Resultadosmamografiaep> getResultadosmamografiaepList() {
        return resultadosmamografiaepList;
    }

    public void setResultadosmamografiaepList(List<Resultadosmamografiaep> resultadosmamografiaepList) {
        this.resultadosmamografiaepList = resultadosmamografiaepList;
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
        hash += (mamografiaemisionpositronesPK != null ? mamografiaemisionpositronesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mamografiaemisionpositrones)) {
            return false;
        }
        Mamografiaemisionpositrones other = (Mamografiaemisionpositrones) object;
        if ((this.mamografiaemisionpositronesPK == null && other.mamografiaemisionpositronesPK != null) || (this.mamografiaemisionpositronesPK != null && !this.mamografiaemisionpositronesPK.equals(other.mamografiaemisionpositronesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return mamografiaemisionpositronesPK +", Screening:"+screening.toString();
    }
    
}
