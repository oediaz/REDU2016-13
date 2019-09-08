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
@Table(name = "mamografiaemisionpositrones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mamografiaemisionpositrones.findAll", query = "SELECT m FROM Mamografiaemisionpositrones m")
    , @NamedQuery(name = "Mamografiaemisionpositrones.findByIdmamografiaep", query = "SELECT m FROM Mamografiaemisionpositrones m WHERE m.idmamografiaep = :idmamografiaep")
    , @NamedQuery(name = "Mamografiaemisionpositrones.findByFechamamografiaep", query = "SELECT m FROM Mamografiaemisionpositrones m WHERE m.fechamamografiaep = :fechamamografiaep")
    , @NamedQuery(name = "Mamografiaemisionpositrones.findByDiagnosticopreviomamografiaep", query = "SELECT m FROM Mamografiaemisionpositrones m WHERE m.diagnosticopreviomamografiaep = :diagnosticopreviomamografiaep")
    , @NamedQuery(name = "Mamografiaemisionpositrones.findByRazonmamografiaep", query = "SELECT m FROM Mamografiaemisionpositrones m WHERE m.razonmamografiaep = :razonmamografiaep")
    , @NamedQuery(name = "Mamografiaemisionpositrones.findBySensibilidadmetastasisep", query = "SELECT m FROM Mamografiaemisionpositrones m WHERE m.sensibilidadmetastasisep = :sensibilidadmetastasisep")
    , @NamedQuery(name = "Mamografiaemisionpositrones.findByEspecificadadmetastasisep", query = "SELECT m FROM Mamografiaemisionpositrones m WHERE m.especificadadmetastasisep = :especificadadmetastasisep")
    , @NamedQuery(name = "Mamografiaemisionpositrones.findByObservacionesmetastasisep", query = "SELECT m FROM Mamografiaemisionpositrones m WHERE m.observacionesmetastasisep = :observacionesmetastasisep")})
public class Mamografiaemisionpositrones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDMAMOGRAFIAEP")
    private Integer idmamografiaep;
    @Column(name = "FECHAMAMOGRAFIAEP")
    @Temporal(TemporalType.DATE)
    private Date fechamamografiaep=new Date();
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmamografiaep")
    private List<Resultadosmamografiaep> resultadosmamografiaepList;
    @JoinColumn(name = "IDSCREENING", referencedColumnName = "IDSCREENING")
    @ManyToOne(optional = false)
    private Screening idscreening;
    @JoinColumn(name = "IDRESPONSABLEI", referencedColumnName = "IDRESPONSABLEI")
    @ManyToOne(optional = false)
    private Responsableimagen idresponsablei;
    @JoinColumn(name = "IDLABORATORIO", referencedColumnName = "IDLABORATORIO")
    @ManyToOne(optional = false)
    private Laboratorio idlaboratorio;

    public Mamografiaemisionpositrones() {
    }

    public Mamografiaemisionpositrones(Integer idmamografiaep) {
        this.idmamografiaep = idmamografiaep;
    }

    public Integer getIdmamografiaep() {
        return idmamografiaep;
    }

    public void setIdmamografiaep(Integer idmamografiaep) {
        this.idmamografiaep = idmamografiaep;
    }

    public Date getFechamamografiaep() {
        this.fechamamografiaep = new Date();
        return fechamamografiaep;
    }

    public void setFechamamografiaep(Date fechamamografiaep) {
        this.fechamamografiaep = new Date();
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
        hash += (idmamografiaep != null ? idmamografiaep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mamografiaemisionpositrones)) {
            return false;
        }
        Mamografiaemisionpositrones other = (Mamografiaemisionpositrones) object;
        if ((this.idmamografiaep == null && other.idmamografiaep != null) || (this.idmamografiaep != null && !this.idmamografiaep.equals(other.idmamografiaep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String dato=""+new SimpleDateFormat("dd-MM-yyyy").format(fechamamografiaep);
        String fecha=dato.replace('-', '/');
        return "" +fecha  + "-"+idmamografiaep;
    }
    
}
