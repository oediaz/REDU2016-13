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
@Table(name = "birads")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Birads.findAll", query = "SELECT b FROM Birads b")
    , @NamedQuery(name = "Birads.findByIdbirads", query = "SELECT b FROM Birads b WHERE b.idbirads = :idbirads")
    , @NamedQuery(name = "Birads.findByFechabirads", query = "SELECT b FROM Birads b WHERE b.fechabirads = :fechabirads")
    , @NamedQuery(name = "Birads.findByRazonbirads", query = "SELECT b FROM Birads b WHERE b.razonbirads = :razonbirads")
    , @NamedQuery(name = "Birads.findByDescripcionbirads", query = "SELECT b FROM Birads b WHERE b.descripcionbirads = :descripcionbirads")
    , @NamedQuery(name = "Birads.findByCategoriabirads", query = "SELECT b FROM Birads b WHERE b.categoriabirads = :categoriabirads")
    , @NamedQuery(name = "Birads.findByDefinicionbirads", query = "SELECT b FROM Birads b WHERE b.definicionbirads = :definicionbirads")
    , @NamedQuery(name = "Birads.findByPorcentajecancerbirads", query = "SELECT b FROM Birads b WHERE b.porcentajecancerbirads = :porcentajecancerbirads")
    , @NamedQuery(name = "Birads.findByRecomendacionbirads", query = "SELECT b FROM Birads b WHERE b.recomendacionbirads = :recomendacionbirads")})
public class Birads implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDBIRADS")
    private Integer idbirads;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHABIRADS")
    @Temporal(TemporalType.DATE)
    private Date fechabirads;
    @Size(max = 32)
    @Column(name = "RAZONBIRADS")
    private String razonbirads;
    @Size(max = 64)
    @Column(name = "DESCRIPCIONBIRADS")
    private String descripcionbirads;
    @Column(name = "CATEGORIABIRADS")
    private Integer categoriabirads;
    @Size(max = 32)
    @Column(name = "DEFINICIONBIRADS")
    private String definicionbirads;
    @Lob
    @Size(max = 65535)
    @Column(name = "EVALUACIONBIRADS")
    private String evaluacionbirads;
    @Size(max = 8)
    @Column(name = "PORCENTAJECANCERBIRADS")
    private String porcentajecancerbirads;
    @Size(max = 64)
    @Column(name = "RECOMENDACIONBIRADS")
    private String recomendacionbirads;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idbirads")
    private List<Tratamientocancermama> tratamientocancermamaList;
    @JoinColumn(name = "IDRESULTADOE", referencedColumnName = "IDRESULTADOE")
    @ManyToOne(optional = false)
    private Resultadosecografia idresultadoe;
    @JoinColumn(name = "IDRESULTADOM", referencedColumnName = "IDRESULTADOM")
    @ManyToOne(optional = false)
    private Resultadosmamografia idresultadom;
    @JoinColumn(name = "IDRESULTADOSMEP", referencedColumnName = "IDRESULTADOSMEP")
    @ManyToOne
    private Resultadosmamografiaep idresultadosmep;
    @JoinColumn(name = "IDRESULTADORM", referencedColumnName = "IDRESULTADORM")
    @ManyToOne(optional = false)
    private Resultadosresonanciamagnetica idresultadorm;

    public Birads() {
    }

    public Birads(Integer idbirads) {
        this.idbirads = idbirads;
    }

    public Birads(Integer idbirads, Date fechabirads) {
        this.idbirads = idbirads;
        this.fechabirads = fechabirads;
    }

    public Integer getIdbirads() {
        return idbirads;
    }

    public void setIdbirads(Integer idbirads) {
        this.idbirads = idbirads;
    }

    public Date getFechabirads() {
        return fechabirads;
    }

    public void setFechabirads(Date fechabirads) {
        this.fechabirads = fechabirads;
    }

    public String getRazonbirads() {
        return razonbirads;
    }

    public void setRazonbirads(String razonbirads) {
        this.razonbirads = razonbirads;
    }

    public String getDescripcionbirads() {
        return descripcionbirads;
    }

    public void setDescripcionbirads(String descripcionbirads) {
        this.descripcionbirads = descripcionbirads;
    }

    public Integer getCategoriabirads() {
        return categoriabirads;
    }

    public void setCategoriabirads(Integer categoriabirads) {
        this.categoriabirads = categoriabirads;
    }

    public String getDefinicionbirads() {
        return definicionbirads;
    }

    public void setDefinicionbirads(String definicionbirads) {
        this.definicionbirads = definicionbirads;
    }

    public String getEvaluacionbirads() {
        return evaluacionbirads;
    }

    public void setEvaluacionbirads(String evaluacionbirads) {
        this.evaluacionbirads = evaluacionbirads;
    }

    public String getPorcentajecancerbirads() {
        return porcentajecancerbirads;
    }

    public void setPorcentajecancerbirads(String porcentajecancerbirads) {
        this.porcentajecancerbirads = porcentajecancerbirads;
    }

    public String getRecomendacionbirads() {
        return recomendacionbirads;
    }

    public void setRecomendacionbirads(String recomendacionbirads) {
        this.recomendacionbirads = recomendacionbirads;
    }

    @XmlTransient
    public List<Tratamientocancermama> getTratamientocancermamaList() {
        return tratamientocancermamaList;
    }

    public void setTratamientocancermamaList(List<Tratamientocancermama> tratamientocancermamaList) {
        this.tratamientocancermamaList = tratamientocancermamaList;
    }

    public Resultadosecografia getIdresultadoe() {
        return idresultadoe;
    }

    public void setIdresultadoe(Resultadosecografia idresultadoe) {
        this.idresultadoe = idresultadoe;
    }

    public Resultadosmamografia getIdresultadom() {
        return idresultadom;
    }

    public void setIdresultadom(Resultadosmamografia idresultadom) {
        this.idresultadom = idresultadom;
    }

    public Resultadosmamografiaep getIdresultadosmep() {
        return idresultadosmep;
    }

    public void setIdresultadosmep(Resultadosmamografiaep idresultadosmep) {
        this.idresultadosmep = idresultadosmep;
    }

    public Resultadosresonanciamagnetica getIdresultadorm() {
        return idresultadorm;
    }

    public void setIdresultadorm(Resultadosresonanciamagnetica idresultadorm) {
        this.idresultadorm = idresultadorm;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbirads != null ? idbirads.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Birads)) {
            return false;
        }
        Birads other = (Birads) object;
        if ((this.idbirads == null && other.idbirads != null) || (this.idbirads != null && !this.idbirads.equals(other.idbirads))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
          String dato=""+new SimpleDateFormat("dd-MM-yyyy").format(fechabirads);
        String fecha=dato.replace('-', '/');
        return "" +fecha  + "-"+idbirads;
    }
    
}
