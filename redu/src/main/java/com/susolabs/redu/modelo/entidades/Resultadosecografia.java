/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.susolabs.redu.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "resultadosecografia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resultadosecografia.findAll", query = "SELECT r FROM Resultadosecografia r")
    , @NamedQuery(name = "Resultadosecografia.findByIdresultadoe", query = "SELECT r FROM Resultadosecografia r WHERE r.idresultadoe = :idresultadoe")
    , @NamedQuery(name = "Resultadosecografia.findByTipohallazgore", query = "SELECT r FROM Resultadosecografia r WHERE r.tipohallazgore = :tipohallazgore")
    , @NamedQuery(name = "Resultadosecografia.findByDescripcionhallazgore", query = "SELECT r FROM Resultadosecografia r WHERE r.descripcionhallazgore = :descripcionhallazgore")
    , @NamedQuery(name = "Resultadosecografia.findByValorpredictivopositivohallazgore", query = "SELECT r FROM Resultadosecografia r WHERE r.valorpredictivopositivohallazgore = :valorpredictivopositivohallazgore")
    , @NamedQuery(name = "Resultadosecografia.findBySensibilidadhallazgore", query = "SELECT r FROM Resultadosecografia r WHERE r.sensibilidadhallazgore = :sensibilidadhallazgore")})
public class Resultadosecografia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDRESULTADOE")
    private Integer idresultadoe;
    @Size(max = 32)
    @Column(name = "TIPOHALLAZGORE")
    private String tipohallazgore;
    @Size(max = 64)
    @Column(name = "DESCRIPCIONHALLAZGORE")
    private String descripcionhallazgore;
    @Size(max = 32)
    @Column(name = "VALORPREDICTIVOPOSITIVOHALLAZGORE")
    private String valorpredictivopositivohallazgore;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SENSIBILIDADHALLAZGORE")
    private BigDecimal sensibilidadhallazgore;
    @JoinColumn(name = "IDECOGRAFIA", referencedColumnName = "IDECOGRAFIA")
    @ManyToOne
    private Ecografia idecografia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idresultadoe")
    private List<Birads> biradsList;

    public Resultadosecografia() {
    }

    public Resultadosecografia(Integer idresultadoe) {
        this.idresultadoe = idresultadoe;
    }

    public Integer getIdresultadoe() {
        return idresultadoe;
    }

    public void setIdresultadoe(Integer idresultadoe) {
        this.idresultadoe = idresultadoe;
    }

    public String getTipohallazgore() {
        return tipohallazgore;
    }

    public void setTipohallazgore(String tipohallazgore) {
        this.tipohallazgore = tipohallazgore;
    }

    public String getDescripcionhallazgore() {
        return descripcionhallazgore;
    }

    public void setDescripcionhallazgore(String descripcionhallazgore) {
        this.descripcionhallazgore = descripcionhallazgore;
    }

    public String getValorpredictivopositivohallazgore() {
        return valorpredictivopositivohallazgore;
    }

    public void setValorpredictivopositivohallazgore(String valorpredictivopositivohallazgore) {
        this.valorpredictivopositivohallazgore = valorpredictivopositivohallazgore;
    }

    public BigDecimal getSensibilidadhallazgore() {
        return sensibilidadhallazgore;
    }

    public void setSensibilidadhallazgore(BigDecimal sensibilidadhallazgore) {
        this.sensibilidadhallazgore = sensibilidadhallazgore;
    }

    public Ecografia getIdecografia() {
        return idecografia;
    }

    public void setIdecografia(Ecografia idecografia) {
        this.idecografia = idecografia;
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
        hash += (idresultadoe != null ? idresultadoe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultadosecografia)) {
            return false;
        }
        Resultadosecografia other = (Resultadosecografia) object;
        if ((this.idresultadoe == null && other.idresultadoe != null) || (this.idresultadoe != null && !this.idresultadoe.equals(other.idresultadoe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.susolabs.redu.modelo.entidades.Resultadosecografia[ idresultadoe=" + idresultadoe + " ]";
    }
    
}
