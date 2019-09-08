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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "screening")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Screening.findAll", query = "SELECT s FROM Screening s")
    , @NamedQuery(name = "Screening.findByIdscreening", query = "SELECT s FROM Screening s WHERE s.idscreening = :idscreening")
    , @NamedQuery(name = "Screening.findByFechascreening", query = "SELECT s FROM Screening s WHERE s.fechascreening = :fechascreening")
    , @NamedQuery(name = "Screening.findByMetodoscreening", query = "SELECT s FROM Screening s WHERE s.metodoscreening = :metodoscreening")})
public class Screening implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDSCREENING")
    private Integer idscreening;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHASCREENING")
    @Temporal(TemporalType.DATE)
    private Date fechascreening= new Date();
    @Size(max = 32)
    @Column(name = "METODOSCREENING")
    private String metodoscreening;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "DESCRIPCIONSCREENING")
    private String descripcionscreening;
    @Lob
    @Size(max = 65535)
    @Column(name = "OBSERVACIONSCREENING")
    private String observacionscreening;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idscreening")
    private List<Mamografia> mamografiaList;
    @JoinColumn(name = "IDMEDICO", referencedColumnName = "IDMEDICO")
    @ManyToOne(optional = false)
    private Medico idmedico;
    @JoinColumn(name = "IDPACIENTE", referencedColumnName = "IDPACIENTE")
    @ManyToOne(optional = false)
    private Paciente idpaciente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idscreening")
    private List<Resonanciamagnetica> resonanciamagneticaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idscreening")
    private List<Ecografia> ecografiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idscreening")
    private List<Mamografiaemisionpositrones> mamografiaemisionpositronesList;

    public Screening() {
    }

    public Screening(Integer idscreening) {
        this.idscreening = idscreening;
    }

    public Screening(Integer idscreening, Date fechascreening, String descripcionscreening) {
        this.idscreening = idscreening;
        this.fechascreening = fechascreening;
        this.descripcionscreening = descripcionscreening;
    }

    public Integer getIdscreening() {
        return idscreening;
    }

    public void setIdscreening(Integer idscreening) {
        this.idscreening = idscreening;
    }

    public Date getFechascreening() {
        this.fechascreening= new Date();
        return fechascreening;
    }

    public void setFechascreening(Date fechascreening) {
        this.fechascreening = new Date();
    }

    public String getMetodoscreening() {
        return metodoscreening;
    }

    public void setMetodoscreening(String metodoscreening) {
        this.metodoscreening = metodoscreening;
    }

    public String getDescripcionscreening() {
        return descripcionscreening;
    }

    public void setDescripcionscreening(String descripcionscreening) {
        this.descripcionscreening = descripcionscreening;
    }

    public String getObservacionscreening() {
        return observacionscreening;
    }

    public void setObservacionscreening(String observacionscreening) {
        this.observacionscreening = observacionscreening;
    }

    @XmlTransient
    public List<Mamografia> getMamografiaList() {
        return mamografiaList;
    }

    public void setMamografiaList(List<Mamografia> mamografiaList) {
        this.mamografiaList = mamografiaList;
    }

    public Medico getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(Medico idmedico) {
        this.idmedico = idmedico;
    }

    public Paciente getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Paciente idpaciente) {
        this.idpaciente = idpaciente;
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
        hash += (idscreening != null ? idscreening.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Screening)) {
            return false;
        }
        Screening other = (Screening) object;
        if ((this.idscreening == null && other.idscreening != null) || (this.idscreening != null && !this.idscreening.equals(other.idscreening))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String dato=""+new SimpleDateFormat("dd-MM-yyyy").format(fechascreening);
        String fecha=dato.replace('-', '/');
        return "" +fecha  + "-"+idscreening;
    }
    
}
