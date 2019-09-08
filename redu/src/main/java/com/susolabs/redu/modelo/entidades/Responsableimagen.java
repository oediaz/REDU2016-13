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
@Table(name = "responsableimagen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Responsableimagen.findAll", query = "SELECT r FROM Responsableimagen r")
    , @NamedQuery(name = "Responsableimagen.findByIdresponsablei", query = "SELECT r FROM Responsableimagen r WHERE r.idresponsablei = :idresponsablei")
    , @NamedQuery(name = "Responsableimagen.findByCedularesponsablei", query = "SELECT r FROM Responsableimagen r WHERE r.cedularesponsablei = :cedularesponsablei")
    , @NamedQuery(name = "Responsableimagen.findByNombreresponsablei", query = "SELECT r FROM Responsableimagen r WHERE r.nombreresponsablei = :nombreresponsablei")
    , @NamedQuery(name = "Responsableimagen.findByFonoresponsablei", query = "SELECT r FROM Responsableimagen r WHERE r.fonoresponsablei = :fonoresponsablei")
    , @NamedQuery(name = "Responsableimagen.findByMailresponsablei", query = "SELECT r FROM Responsableimagen r WHERE r.mailresponsablei = :mailresponsablei")
    , @NamedQuery(name = "Responsableimagen.findByCelularresponsablei", query = "SELECT r FROM Responsableimagen r WHERE r.celularresponsablei = :celularresponsablei")})
public class Responsableimagen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDRESPONSABLEI")
    private Integer idresponsablei;
    @Size(max = 10)
    @Column(name = "CEDULARESPONSABLEI",unique = true)
    private String cedularesponsablei;
    @Size(max = 32)
    @Column(name = "NOMBRERESPONSABLEI")
    private String nombreresponsablei;
    @Size(max = 16)
    @Column(name = "FONORESPONSABLEI")
    private String fonoresponsablei;
    @Size(max = 32)
    @Column(name = "MAILRESPONSABLEI")
    private String mailresponsablei;
    @Size(max = 32)
    @Column(name = "CELULARRESPONSABLEI")
    private String celularresponsablei;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idresponsablei")
    private List<Mamografia> mamografiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idresponsablei")
    private List<Resonanciamagnetica> resonanciamagneticaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idresponsablei")
    private List<Ecografia> ecografiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idresponsablei")
    private List<Mamografiaemisionpositrones> mamografiaemisionpositronesList;

    public Responsableimagen() {
    }

    public Responsableimagen(Integer idresponsablei) {
        this.idresponsablei = idresponsablei;
    }

    public Integer getIdresponsablei() {
        return idresponsablei;
    }

    public void setIdresponsablei(Integer idresponsablei) {
        this.idresponsablei = idresponsablei;
    }

    public String getCedularesponsablei() {
        return cedularesponsablei;
    }

    public void setCedularesponsablei(String cedularesponsablei) {
        this.cedularesponsablei = cedularesponsablei;
    }

    public String getNombreresponsablei() {
        return nombreresponsablei;
    }

    public void setNombreresponsablei(String nombreresponsablei) {
        this.nombreresponsablei = nombreresponsablei;
    }

    public String getFonoresponsablei() {
        return fonoresponsablei;
    }

    public void setFonoresponsablei(String fonoresponsablei) {
        this.fonoresponsablei = fonoresponsablei;
    }

    public String getMailresponsablei() {
        return mailresponsablei;
    }

    public void setMailresponsablei(String mailresponsablei) {
        this.mailresponsablei = mailresponsablei;
    }

    public String getCelularresponsablei() {
        return celularresponsablei;
    }

    public void setCelularresponsablei(String celularresponsablei) {
        this.celularresponsablei = celularresponsablei;
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
        hash += (idresponsablei != null ? idresponsablei.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Responsableimagen)) {
            return false;
        }
        Responsableimagen other = (Responsableimagen) object;
        if ((this.idresponsablei == null && other.idresponsablei != null) || (this.idresponsablei != null && !this.idresponsablei.equals(other.idresponsablei))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreresponsablei+"-"+cedularesponsablei;
    }
    
}
