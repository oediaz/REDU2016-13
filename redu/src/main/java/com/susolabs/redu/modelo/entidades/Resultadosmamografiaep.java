/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.susolabs.redu.modelo.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "resultadosmamografiaep")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resultadosmamografiaep.findAll", query = "SELECT r FROM Resultadosmamografiaep r")
    , @NamedQuery(name = "Resultadosmamografiaep.findByIdresultadosmep", query = "SELECT r FROM Resultadosmamografiaep r WHERE r.idresultadosmep = :idresultadosmep")
    , @NamedQuery(name = "Resultadosmamografiaep.findByHallazgomep", query = "SELECT r FROM Resultadosmamografiaep r WHERE r.hallazgomep = :hallazgomep")
    , @NamedQuery(name = "Resultadosmamografiaep.findByDescripcionhallazgomep", query = "SELECT r FROM Resultadosmamografiaep r WHERE r.descripcionhallazgomep = :descripcionhallazgomep")
    , @NamedQuery(name = "Resultadosmamografiaep.findByCausafalsopositivomep", query = "SELECT r FROM Resultadosmamografiaep r WHERE r.causafalsopositivomep = :causafalsopositivomep")
    , @NamedQuery(name = "Resultadosmamografiaep.findByCausafalsonegativomep", query = "SELECT r FROM Resultadosmamografiaep r WHERE r.causafalsonegativomep = :causafalsonegativomep")})
public class Resultadosmamografiaep implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDRESULTADOSMEP")
    private Integer idresultadosmep;
    @Size(max = 32)
    @Column(name = "HALLAZGOMEP")
    private String hallazgomep;
    @Size(max = 64)
    @Column(name = "DESCRIPCIONHALLAZGOMEP")
    private String descripcionhallazgomep;
    @Size(max = 32)
    @Column(name = "CAUSAFALSOPOSITIVOMEP")
    private String causafalsopositivomep;
    @Size(max = 32)
    @Column(name = "CAUSAFALSONEGATIVOMEP")
    private String causafalsonegativomep;
    @JoinColumn(name = "IDMAMOGRAFIAEP", referencedColumnName = "IDMAMOGRAFIAEP")
    @ManyToOne(optional = false)
    private Mamografiaemisionpositrones idmamografiaep;
    @OneToMany(mappedBy = "idresultadosmep")
    private List<Birads> biradsList;

    public Resultadosmamografiaep() {
    }

    public Resultadosmamografiaep(Integer idresultadosmep) {
        this.idresultadosmep = idresultadosmep;
    }

    public Integer getIdresultadosmep() {
        return idresultadosmep;
    }

    public void setIdresultadosmep(Integer idresultadosmep) {
        this.idresultadosmep = idresultadosmep;
    }

    public String getHallazgomep() {
        return hallazgomep;
    }

    public void setHallazgomep(String hallazgomep) {
        this.hallazgomep = hallazgomep;
    }

    public String getDescripcionhallazgomep() {
        return descripcionhallazgomep;
    }

    public void setDescripcionhallazgomep(String descripcionhallazgomep) {
        this.descripcionhallazgomep = descripcionhallazgomep;
    }

    public String getCausafalsopositivomep() {
        return causafalsopositivomep;
    }

    public void setCausafalsopositivomep(String causafalsopositivomep) {
        this.causafalsopositivomep = causafalsopositivomep;
    }

    public String getCausafalsonegativomep() {
        return causafalsonegativomep;
    }

    public void setCausafalsonegativomep(String causafalsonegativomep) {
        this.causafalsonegativomep = causafalsonegativomep;
    }

    public Mamografiaemisionpositrones getIdmamografiaep() {
        return idmamografiaep;
    }

    public void setIdmamografiaep(Mamografiaemisionpositrones idmamografiaep) {
        this.idmamografiaep = idmamografiaep;
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
        hash += (idresultadosmep != null ? idresultadosmep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultadosmamografiaep)) {
            return false;
        }
        Resultadosmamografiaep other = (Resultadosmamografiaep) object;
        if ((this.idresultadosmep == null && other.idresultadosmep != null) || (this.idresultadosmep != null && !this.idresultadosmep.equals(other.idresultadosmep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idresultadosmep+"-"+hallazgomep;
    }
    
}
