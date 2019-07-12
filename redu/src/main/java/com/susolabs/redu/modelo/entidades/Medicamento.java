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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "medicamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicamento.findAll", query = "SELECT m FROM Medicamento m")
    , @NamedQuery(name = "Medicamento.findByIdmedicamento", query = "SELECT m FROM Medicamento m WHERE m.idmedicamento = :idmedicamento")
    , @NamedQuery(name = "Medicamento.findByNombremedicamento", query = "SELECT m FROM Medicamento m WHERE m.nombremedicamento = :nombremedicamento")
    , @NamedQuery(name = "Medicamento.findByNombregenericomedicamento", query = "SELECT m FROM Medicamento m WHERE m.nombregenericomedicamento = :nombregenericomedicamento")
    , @NamedQuery(name = "Medicamento.findByDescripcionmedicamento", query = "SELECT m FROM Medicamento m WHERE m.descripcionmedicamento = :descripcionmedicamento")})
public class Medicamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDMEDICAMENTO")
    private Integer idmedicamento;
    @Size(max = 64)
    @Column(name = "NOMBREMEDICAMENTO")
    private String nombremedicamento;
    @Size(max = 64)
    @Column(name = "NOMBREGENERICOMEDICAMENTO")
    private String nombregenericomedicamento;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "PRESENTACIONMEDICAMENTO")
    private String presentacionmedicamento;
    @Size(max = 64)
    @Column(name = "DESCRIPCIONMEDICAMENTO")
    private String descripcionmedicamento;
    @JoinTable(name = "receta", joinColumns = {
        @JoinColumn(name = "IDMEDICAMENTO", referencedColumnName = "IDMEDICAMENTO")}, inverseJoinColumns = {
        @JoinColumn(name = "IDTRTAMIENTOCM", referencedColumnName = "IDTRTAMIENTOCM")
        , @JoinColumn(name = "IDMEDICACION", referencedColumnName = "IDMEDICACION")})
    @ManyToMany
    private List<Medicacion> medicacionList;

    public Medicamento() {
    }

    public Medicamento(Integer idmedicamento) {
        this.idmedicamento = idmedicamento;
    }

    public Integer getIdmedicamento() {
        return idmedicamento;
    }

    public void setIdmedicamento(Integer idmedicamento) {
        this.idmedicamento = idmedicamento;
    }

    public String getNombremedicamento() {
        return nombremedicamento;
    }

    public void setNombremedicamento(String nombremedicamento) {
        this.nombremedicamento = nombremedicamento;
    }

    public String getNombregenericomedicamento() {
        return nombregenericomedicamento;
    }

    public void setNombregenericomedicamento(String nombregenericomedicamento) {
        this.nombregenericomedicamento = nombregenericomedicamento;
    }

    public String getPresentacionmedicamento() {
        return presentacionmedicamento;
    }

    public void setPresentacionmedicamento(String presentacionmedicamento) {
        this.presentacionmedicamento = presentacionmedicamento;
    }

    public String getDescripcionmedicamento() {
        return descripcionmedicamento;
    }

    public void setDescripcionmedicamento(String descripcionmedicamento) {
        this.descripcionmedicamento = descripcionmedicamento;
    }

    @XmlTransient
    public List<Medicacion> getMedicacionList() {
        return medicacionList;
    }

    public void setMedicacionList(List<Medicacion> medicacionList) {
        this.medicacionList = medicacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmedicamento != null ? idmedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicamento)) {
            return false;
        }
        Medicamento other = (Medicamento) object;
        if ((this.idmedicamento == null && other.idmedicamento != null) || (this.idmedicamento != null && !this.idmedicamento.equals(other.idmedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.susolabs.redu.modelo.entidades.Medicamento[ idmedicamento=" + idmedicamento + " ]";
    }
    
}
