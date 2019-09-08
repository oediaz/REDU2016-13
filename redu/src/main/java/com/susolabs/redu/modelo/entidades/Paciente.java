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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PEPE
 */
@Entity
@Table(name = "paciente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p")
    , @NamedQuery(name = "Paciente.findByIdpaciente", query = "SELECT p FROM Paciente p WHERE p.idpaciente = :idpaciente")
    , @NamedQuery(name = "Paciente.findByCedulapaciente", query = "SELECT p FROM Paciente p WHERE p.cedulapaciente = :cedulapaciente")
    , @NamedQuery(name = "Paciente.findByApellidopaciente", query = "SELECT p FROM Paciente p WHERE p.apellidopaciente = :apellidopaciente")
    , @NamedQuery(name = "Paciente.findByNombrepaciente", query = "SELECT p FROM Paciente p WHERE p.nombrepaciente = :nombrepaciente")
    , @NamedQuery(name = "Paciente.findByFechanacimientopaciente", query = "SELECT p FROM Paciente p WHERE p.fechanacimientopaciente = :fechanacimientopaciente")
    , @NamedQuery(name = "Paciente.findByFonopaciente", query = "SELECT p FROM Paciente p WHERE p.fonopaciente = :fonopaciente")
    , @NamedQuery(name = "Paciente.findByDireccionpaciente", query = "SELECT p FROM Paciente p WHERE p.direccionpaciente = :direccionpaciente")
    , @NamedQuery(name = "Paciente.findByMailpaciente", query = "SELECT p FROM Paciente p WHERE p.mailpaciente = :mailpaciente")
    , @NamedQuery(name = "Paciente.findByCelularpaciente", query = "SELECT p FROM Paciente p WHERE p.celularpaciente = :celularpaciente")})
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPACIENTE")
    private Integer idpaciente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CEDULAPACIENTE",unique = true)
    private String cedulapaciente;
    @Size(max = 32)
    @Column(name = "APELLIDOPACIENTE")
    private String apellidopaciente;
    @Size(max = 32)
    @Column(name = "NOMBREPACIENTE")
    private String nombrepaciente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHANACIMIENTOPACIENTE")
    @Temporal(TemporalType.DATE)
    private Date fechanacimientopaciente;
    @Size(max = 16)
    @Column(name = "FONOPACIENTE")
    private String fonopaciente;
    @Size(max = 64)
    @Column(name = "DIRECCIONPACIENTE")
    private String direccionpaciente;
    @Size(max = 64)
    @Column(name = "MAILPACIENTE")
    private String mailpaciente;
    @Size(max = 16)
    @Column(name = "CELULARPACIENTE")
    private String celularpaciente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpaciente")
    private List<Screening> screeningList;

    public Paciente() {
    }

    public Paciente(Integer idpaciente) {
        this.idpaciente = idpaciente;
    }

    public Paciente(Integer idpaciente, String cedulapaciente, Date fechanacimientopaciente) {
        this.idpaciente = idpaciente;
        this.cedulapaciente = cedulapaciente;
        this.fechanacimientopaciente = fechanacimientopaciente;
    }

    public Integer getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Integer idpaciente) {
        this.idpaciente = idpaciente;
    }

    public String getCedulapaciente() {
        return cedulapaciente;
    }

    public void setCedulapaciente(String cedulapaciente) {
        this.cedulapaciente = cedulapaciente;
    }

    public String getApellidopaciente() {
        return apellidopaciente;
    }

    public void setApellidopaciente(String apellidopaciente) {
        this.apellidopaciente = apellidopaciente;
    }

    public String getNombrepaciente() {
        return nombrepaciente;
    }

    public void setNombrepaciente(String nombrepaciente) {
        this.nombrepaciente = nombrepaciente;
    }

    public Date getFechanacimientopaciente() {
        return fechanacimientopaciente;
    }

    public void setFechanacimientopaciente(Date fechanacimientopaciente) {
        this.fechanacimientopaciente = fechanacimientopaciente;
    }

    public String getFonopaciente() {
        return fonopaciente;
    }

    public void setFonopaciente(String fonopaciente) {
        this.fonopaciente = fonopaciente;
    }

    public String getDireccionpaciente() {
        return direccionpaciente;
    }

    public void setDireccionpaciente(String direccionpaciente) {
        this.direccionpaciente = direccionpaciente;
    }

    public String getMailpaciente() {
        return mailpaciente;
    }

    public void setMailpaciente(String mailpaciente) {
        this.mailpaciente = mailpaciente;
    }

    public String getCelularpaciente() {
        return celularpaciente;
    }

    public void setCelularpaciente(String celularpaciente) {
        this.celularpaciente = celularpaciente;
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
        hash += (idpaciente != null ? idpaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.idpaciente == null && other.idpaciente != null) || (this.idpaciente != null && !this.idpaciente.equals(other.idpaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombrepaciente+" "+apellidopaciente+"-"+cedulapaciente;
    }
    
}
