/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.susolabs.redu.modelo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PEPE
 */
@Entity
@Table(name = "receta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receta.findAll", query = "SELECT r FROM Receta r")
    , @NamedQuery(name = "Receta.findByIdreceta", query = "SELECT r FROM Receta r WHERE r.idreceta = :idreceta")
    , @NamedQuery(name = "Receta.findByDocismedicamento", query = "SELECT r FROM Receta r WHERE r.docismedicamento = :docismedicamento")
    , @NamedQuery(name = "Receta.findByFrecuenciamedicacion", query = "SELECT r FROM Receta r WHERE r.frecuenciamedicacion = :frecuenciamedicacion")})
public class Receta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDRECETA")
    private Integer idreceta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DOCISMEDICAMENTO")
    private BigDecimal docismedicamento;
    @Size(max = 32)
    @Column(name = "FRECUENCIAMEDICACION")
    private String frecuenciamedicacion;
    @JoinColumn(name = "IDMEDICACION", referencedColumnName = "IDMEDICACION")
    @ManyToOne(optional = false)
    private Medicacion idmedicacion;
    @JoinColumn(name = "IDMEDICAMENTO", referencedColumnName = "IDMEDICAMENTO")
    @ManyToOne(optional = false)
    private Medicamento idmedicamento;

    public Receta() {
    }

    public Receta(Integer idreceta) {
        this.idreceta = idreceta;
    }

    public Integer getIdreceta() {
        return idreceta;
    }

    public void setIdreceta(Integer idreceta) {
        this.idreceta = idreceta;
    }

    public BigDecimal getDocismedicamento() {
        return docismedicamento;
    }

    public void setDocismedicamento(BigDecimal docismedicamento) {
        this.docismedicamento = docismedicamento;
    }

    public String getFrecuenciamedicacion() {
        return frecuenciamedicacion;
    }

    public void setFrecuenciamedicacion(String frecuenciamedicacion) {
        this.frecuenciamedicacion = frecuenciamedicacion;
    }

    public Medicacion getIdmedicacion() {
        return idmedicacion;
    }

    public void setIdmedicacion(Medicacion idmedicacion) {
        this.idmedicacion = idmedicacion;
    }

    public Medicamento getIdmedicamento() {
        return idmedicamento;
    }

    public void setIdmedicamento(Medicamento idmedicamento) {
        this.idmedicamento = idmedicamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreceta != null ? idreceta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receta)) {
            return false;
        }
        Receta other = (Receta) object;
        if ((this.idreceta == null && other.idreceta != null) || (this.idreceta != null && !this.idreceta.equals(other.idreceta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.susolabs.redu.modelo.entidades.Receta[ idreceta=" + idreceta + " ]";
    }
    
}
