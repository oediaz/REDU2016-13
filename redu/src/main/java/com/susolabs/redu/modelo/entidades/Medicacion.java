/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.susolabs.redu.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author t4nk
 */
@Entity
@Table(name = "medicacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicacion.findAll", query = "SELECT m FROM Medicacion m")
    , @NamedQuery(name = "Medicacion.findByIdtrtamientocm", query = "SELECT m FROM Medicacion m WHERE m.medicacionPK.idtrtamientocm = :idtrtamientocm")
    , @NamedQuery(name = "Medicacion.findByIdmedicacion", query = "SELECT m FROM Medicacion m WHERE m.medicacionPK.idmedicacion = :idmedicacion")
    , @NamedQuery(name = "Medicacion.findByFechamedicacion", query = "SELECT m FROM Medicacion m WHERE m.fechamedicacion = :fechamedicacion")
    , @NamedQuery(name = "Medicacion.findByDescripcionmedicacion", query = "SELECT m FROM Medicacion m WHERE m.descripcionmedicacion = :descripcionmedicacion")})
public class Medicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MedicacionPK medicacionPK;
    @Column(name = "FECHAMEDICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechamedicacion;
    @Size(max = 64)
    @Column(name = "DESCRIPCIONMEDICACION")
    private String descripcionmedicacion;
    @ManyToMany(mappedBy = "medicacionList")
    private List<Medicamento> medicamentoList;
    @JoinColumn(name = "IDTRTAMIENTOCM", referencedColumnName = "IDTRTAMIENTOCM", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tratamientocancermama tratamientocancermama;

    public Medicacion() {
    }

    public Medicacion(MedicacionPK medicacionPK) {
        this.medicacionPK = medicacionPK;
    }

    public Medicacion(int idtrtamientocm, int idmedicacion) {
        this.medicacionPK = new MedicacionPK(idtrtamientocm, idmedicacion);
    }

    public MedicacionPK getMedicacionPK() {
        return medicacionPK;
    }

    public void setMedicacionPK(MedicacionPK medicacionPK) {
        this.medicacionPK = medicacionPK;
    }

    public Date getFechamedicacion() {
        return fechamedicacion;
    }

    public void setFechamedicacion(Date fechamedicacion) {
        this.fechamedicacion = fechamedicacion;
    }

    public String getDescripcionmedicacion() {
        return descripcionmedicacion;
    }

    public void setDescripcionmedicacion(String descripcionmedicacion) {
        this.descripcionmedicacion = descripcionmedicacion;
    }

    @XmlTransient
    public List<Medicamento> getMedicamentoList() {
        return medicamentoList;
    }

    public void setMedicamentoList(List<Medicamento> medicamentoList) {
        this.medicamentoList = medicamentoList;
    }

    public Tratamientocancermama getTratamientocancermama() {
        return tratamientocancermama;
    }

    public void setTratamientocancermama(Tratamientocancermama tratamientocancermama) {
        this.tratamientocancermama = tratamientocancermama;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicacionPK != null ? medicacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicacion)) {
            return false;
        }
        Medicacion other = (Medicacion) object;
        if ((this.medicacionPK == null && other.medicacionPK != null) || (this.medicacionPK != null && !this.medicacionPK.equals(other.medicacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.susolabs.redu.modelo.entidades.Medicacion[ medicacionPK=" + medicacionPK + " ]";
    }
    
}
