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
@Table(name = "laboratorio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Laboratorio.findAll", query = "SELECT l FROM Laboratorio l")
    , @NamedQuery(name = "Laboratorio.findByIdlaboratorio", query = "SELECT l FROM Laboratorio l WHERE l.idlaboratorio = :idlaboratorio")
    , @NamedQuery(name = "Laboratorio.findByNombrelaboratorio", query = "SELECT l FROM Laboratorio l WHERE l.nombrelaboratorio = :nombrelaboratorio")
    , @NamedQuery(name = "Laboratorio.findByDireccionlaboratorio", query = "SELECT l FROM Laboratorio l WHERE l.direccionlaboratorio = :direccionlaboratorio")
    , @NamedQuery(name = "Laboratorio.findByFonolaboratorio", query = "SELECT l FROM Laboratorio l WHERE l.fonolaboratorio = :fonolaboratorio")})
public class Laboratorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDLABORATORIO")
    private Integer idlaboratorio;
    @Size(max = 64)
    @Column(name = "NOMBRELABORATORIO")
    private String nombrelaboratorio;
    @Size(max = 64)
    @Column(name = "DIRECCIONLABORATORIO")
    private String direccionlaboratorio;
    @Size(max = 16)
    @Column(name = "FONOLABORATORIO")
    private String fonolaboratorio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idlaboratorio")
    private List<Mamografia> mamografiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idlaboratorio")
    private List<Resonanciamagnetica> resonanciamagneticaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idlaboratorio")
    private List<Ecografia> ecografiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idlaboratorio")
    private List<Mamografiaemisionpositrones> mamografiaemisionpositronesList;

    public Laboratorio() {
    }

    public Laboratorio(Integer idlaboratorio) {
        this.idlaboratorio = idlaboratorio;
    }

    public Integer getIdlaboratorio() {
        return idlaboratorio;
    }

    public void setIdlaboratorio(Integer idlaboratorio) {
        this.idlaboratorio = idlaboratorio;
    }

    public String getNombrelaboratorio() {
        return nombrelaboratorio;
    }

    public void setNombrelaboratorio(String nombrelaboratorio) {
        this.nombrelaboratorio = nombrelaboratorio;
    }

    public String getDireccionlaboratorio() {
        return direccionlaboratorio;
    }

    public void setDireccionlaboratorio(String direccionlaboratorio) {
        this.direccionlaboratorio = direccionlaboratorio;
    }

    public String getFonolaboratorio() {
        return fonolaboratorio;
    }

    public void setFonolaboratorio(String fonolaboratorio) {
        this.fonolaboratorio = fonolaboratorio;
    }

    @XmlTransient
    public List<Mamografia> getMamografiaList() {
        return mamografiaList;
    }

    public void setMamografiaList(List<Mamografia> mamografiaList) {
        this.mamografiaList = mamografiaList;
    }

    @XmlTransient
    public List<Resonanciamagnetica> getResonanciamagneticaList() {
        return resonanciamagneticaList;
    }

    public void setResonanciamagneticaList(List<Resonanciamagnetica> resonanciamagneticaList) {
        this.resonanciamagneticaList = resonanciamagneticaList;
    }

    @XmlTransient
    public List<Ecografia> getEcografiaList() {
        return ecografiaList;
    }

    public void setEcografiaList(List<Ecografia> ecografiaList) {
        this.ecografiaList = ecografiaList;
    }

    @XmlTransient
    public List<Mamografiaemisionpositrones> getMamografiaemisionpositronesList() {
        return mamografiaemisionpositronesList;
    }

    public void setMamografiaemisionpositronesList(List<Mamografiaemisionpositrones> mamografiaemisionpositronesList) {
        this.mamografiaemisionpositronesList = mamografiaemisionpositronesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlaboratorio != null ? idlaboratorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Laboratorio)) {
            return false;
        }
        Laboratorio other = (Laboratorio) object;
        if ((this.idlaboratorio == null && other.idlaboratorio != null) || (this.idlaboratorio != null && !this.idlaboratorio.equals(other.idlaboratorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.susolabs.redu.modelo.entidades.Laboratorio[ idlaboratorio=" + idlaboratorio + " ]";
    }
    
}
