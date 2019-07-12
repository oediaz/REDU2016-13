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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author t4nk
 */
@Entity
@Table(name = "medico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medico.findAll", query = "SELECT m FROM Medico m")
    , @NamedQuery(name = "Medico.findByIdmedico", query = "SELECT m FROM Medico m WHERE m.idmedico = :idmedico")
    , @NamedQuery(name = "Medico.findByCedulamedico", query = "SELECT m FROM Medico m WHERE m.cedulamedico = :cedulamedico")
    , @NamedQuery(name = "Medico.findByApellidomedico", query = "SELECT m FROM Medico m WHERE m.apellidomedico = :apellidomedico")
    , @NamedQuery(name = "Medico.findByNombremedico", query = "SELECT m FROM Medico m WHERE m.nombremedico = :nombremedico")
    , @NamedQuery(name = "Medico.findByTipomedico", query = "SELECT m FROM Medico m WHERE m.tipomedico = :tipomedico")
    , @NamedQuery(name = "Medico.findByFonomedico", query = "SELECT m FROM Medico m WHERE m.fonomedico = :fonomedico")
    , @NamedQuery(name = "Medico.findByDireccionmedico", query = "SELECT m FROM Medico m WHERE m.direccionmedico = :direccionmedico")
    , @NamedQuery(name = "Medico.findByMailmedico", query = "SELECT m FROM Medico m WHERE m.mailmedico = :mailmedico")
    , @NamedQuery(name = "Medico.findByCelularmedico", query = "SELECT m FROM Medico m WHERE m.celularmedico = :celularmedico")})
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDMEDICO")
    private Integer idmedico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CEDULAMEDICO")
    private String cedulamedico;
    @Size(max = 32)
    @Column(name = "APELLIDOMEDICO")
    private String apellidomedico;
    @Size(max = 32)
    @Column(name = "NOMBREMEDICO")
    private String nombremedico;
    @Size(max = 32)
    @Column(name = "TIPOMEDICO")
    private String tipomedico;
    @Size(max = 16)
    @Column(name = "FONOMEDICO")
    private String fonomedico;
    @Size(max = 64)
    @Column(name = "DIRECCIONMEDICO")
    private String direccionmedico;
    @Size(max = 64)
    @Column(name = "MAILMEDICO")
    private String mailmedico;
    @Size(max = 16)
    @Column(name = "CELULARMEDICO")
    private String celularmedico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmedico")
    private List<Screening> screeningList;

    public Medico() {
    }

    public Medico(Integer idmedico) {
        this.idmedico = idmedico;
    }

    public Medico(Integer idmedico, String cedulamedico) {
        this.idmedico = idmedico;
        this.cedulamedico = cedulamedico;
    }

    public Integer getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(Integer idmedico) {
        this.idmedico = idmedico;
    }

    public String getCedulamedico() {
        return cedulamedico;
    }

    public void setCedulamedico(String cedulamedico) {
        this.cedulamedico = cedulamedico;
    }

    public String getApellidomedico() {
        return apellidomedico;
    }

    public void setApellidomedico(String apellidomedico) {
        this.apellidomedico = apellidomedico;
    }

    public String getNombremedico() {
        return nombremedico;
    }

    public void setNombremedico(String nombremedico) {
        this.nombremedico = nombremedico;
    }

    public String getTipomedico() {
        return tipomedico;
    }

    public void setTipomedico(String tipomedico) {
        this.tipomedico = tipomedico;
    }

    public String getFonomedico() {
        return fonomedico;
    }

    public void setFonomedico(String fonomedico) {
        this.fonomedico = fonomedico;
    }

    public String getDireccionmedico() {
        return direccionmedico;
    }

    public void setDireccionmedico(String direccionmedico) {
        this.direccionmedico = direccionmedico;
    }

    public String getMailmedico() {
        return mailmedico;
    }

    public void setMailmedico(String mailmedico) {
        this.mailmedico = mailmedico;
    }

    public String getCelularmedico() {
        return celularmedico;
    }

    public void setCelularmedico(String celularmedico) {
        this.celularmedico = celularmedico;
    }

    @XmlTransient
    public List<Screening> getScreeningList() {
        return screeningList;
    }

    public void setScreeningList(List<Screening> screeningList) {
        this.screeningList = screeningList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmedico != null ? idmedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.idmedico == null && other.idmedico != null) || (this.idmedico != null && !this.idmedico.equals(other.idmedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "com.susolabs.redu.modelo.entidades.Medico[ idmedico=" + idmedico + " ]";
        return cedulamedico+" - "+nombremedico + " " + apellidomedico;
    }
    
    public String nombreCedula(){
        return cedulamedico+" - "+nombremedico + " " + apellidomedico;
    }
    
}
