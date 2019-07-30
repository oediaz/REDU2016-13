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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "resultadosmamografia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resultadosmamografia.findAll", query = "SELECT r FROM Resultadosmamografia r")
    , @NamedQuery(name = "Resultadosmamografia.findByIdresultadom", query = "SELECT r FROM Resultadosmamografia r WHERE r.idresultadom = :idresultadom")
    , @NamedQuery(name = "Resultadosmamografia.findByTipohallazgorem", query = "SELECT r FROM Resultadosmamografia r WHERE r.tipohallazgorem = :tipohallazgorem")
    , @NamedQuery(name = "Resultadosmamografia.findByDescripcionhallazgorem", query = "SELECT r FROM Resultadosmamografia r WHERE r.descripcionhallazgorem = :descripcionhallazgorem")
    , @NamedQuery(name = "Resultadosmamografia.findByGradosospechahallazgorem", query = "SELECT r FROM Resultadosmamografia r WHERE r.gradosospechahallazgorem = :gradosospechahallazgorem")
    , @NamedQuery(name = "Resultadosmamografia.findByClasificaciondistribucionhallazgorem", query = "SELECT r FROM Resultadosmamografia r WHERE r.clasificaciondistribucionhallazgorem = :clasificaciondistribucionhallazgorem")})
public class Resultadosmamografia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDRESULTADOM")
    private Integer idresultadom;
    @Size(max = 32)
    @Column(name = "TIPOHALLAZGOREM")
    private String tipohallazgorem;
    @Size(max = 64)
    @Column(name = "DESCRIPCIONHALLAZGOREM")
    private String descripcionhallazgorem;
    @Size(max = 16)
    @Column(name = "GRADOSOSPECHAHALLAZGOREM")
    private String gradosospechahallazgorem;
    @Lob
    @Size(max = 65535)
    @Column(name = "DESCRIPCIONGRADOSOSPECHAHALLAZGOREM")
    private String descripciongradosospechahallazgorem;
    @Size(max = 32)
    @Column(name = "CLASIFICACIONDISTRIBUCIONHALLAZGOREM")
    private String clasificaciondistribucionhallazgorem;
    @JoinColumn(name = "IDMAMOGRAFIA", referencedColumnName = "IDMAMOGRAFIA")
    @ManyToOne(optional = false)
    private Mamografia idmamografia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idresultadom")
    private List<Birads> biradsList;

    public Resultadosmamografia() {
    }

    public Resultadosmamografia(Integer idresultadom) {
        this.idresultadom = idresultadom;
    }

    public Integer getIdresultadom() {
        return idresultadom;
    }

    public void setIdresultadom(Integer idresultadom) {
        this.idresultadom = idresultadom;
    }

    public String getTipohallazgorem() {
        return tipohallazgorem;
    }

    public void setTipohallazgorem(String tipohallazgorem) {
        this.tipohallazgorem = tipohallazgorem;
    }

    public String getDescripcionhallazgorem() {
        return descripcionhallazgorem;
    }

    public void setDescripcionhallazgorem(String descripcionhallazgorem) {
        this.descripcionhallazgorem = descripcionhallazgorem;
    }

    public String getGradosospechahallazgorem() {
        return gradosospechahallazgorem;
    }

    public void setGradosospechahallazgorem(String gradosospechahallazgorem) {
        this.gradosospechahallazgorem = gradosospechahallazgorem;
    }

    public String getDescripciongradosospechahallazgorem() {
        return descripciongradosospechahallazgorem;
    }

    public void setDescripciongradosospechahallazgorem(String descripciongradosospechahallazgorem) {
        this.descripciongradosospechahallazgorem = descripciongradosospechahallazgorem;
    }

    public String getClasificaciondistribucionhallazgorem() {
        return clasificaciondistribucionhallazgorem;
    }

    public void setClasificaciondistribucionhallazgorem(String clasificaciondistribucionhallazgorem) {
        this.clasificaciondistribucionhallazgorem = clasificaciondistribucionhallazgorem;
    }

    public Mamografia getIdmamografia() {
        return idmamografia;
    }

    public void setIdmamografia(Mamografia idmamografia) {
        this.idmamografia = idmamografia;
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
        hash += (idresultadom != null ? idresultadom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultadosmamografia)) {
            return false;
        }
        Resultadosmamografia other = (Resultadosmamografia) object;
        if ((this.idresultadom == null && other.idresultadom != null) || (this.idresultadom != null && !this.idresultadom.equals(other.idresultadom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.susolabs.redu.modelo.entidades.Resultadosmamografia[ idresultadom=" + idresultadom + " ]";
    }
    
}
