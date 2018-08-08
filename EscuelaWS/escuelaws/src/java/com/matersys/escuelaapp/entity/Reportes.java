/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eiste
 */
@Entity
@Table(name = "reportes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reportes.findAll", query = "SELECT r FROM Reportes r"),
    @NamedQuery(name = "Reportes.findByIdreporte", query = "SELECT r FROM Reportes r WHERE r.idreporte = :idreporte"),
    @NamedQuery(name = "Reportes.findByCicloesc", query = "SELECT r FROM Reportes r WHERE r.cicloesc = :cicloesc"),
    @NamedQuery(name = "Reportes.findByPeriodo", query = "SELECT r FROM Reportes r WHERE r.periodo = :periodo"),
    @NamedQuery(name = "Reportes.findByDescripcion", query = "SELECT r FROM Reportes r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "Reportes.findBySancion", query = "SELECT r FROM Reportes r WHERE r.sancion = :sancion"),
    @NamedQuery(name = "Reportes.findByEstatusrep", query = "SELECT r FROM Reportes r WHERE r.estatusrep = :estatusrep"),
    @NamedQuery(name = "Reportes.findByFecharepgen", query = "SELECT r FROM Reportes r WHERE r.fecharepgen = :fecharepgen"),
    @NamedQuery(name = "Reportes.findByFecharepent", query = "SELECT r FROM Reportes r WHERE r.fecharepent = :fecharepent"),
    @NamedQuery(name = "Reportes.findByFecharepcum", query = "SELECT r FROM Reportes r WHERE r.fecharepcum = :fecharepcum")})
public class Reportes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreporte")
    private Integer idreporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "cicloesc")
    private String cicloesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "periodo")
    private String periodo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 360)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "sancion")
    private String sancion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estatusrep")
    private String estatusrep;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecharepgen")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharepgen;
    @Column(name = "fecharepent")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharepent;
    @Column(name = "fecharepcum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharepcum;
    @JoinColumn(name = "numalumno", referencedColumnName = "numalumno")
    @ManyToOne(optional = false)
    private Alumno numalumno;

    public Reportes() {
    }

    public Reportes(Integer idreporte) {
        this.idreporte = idreporte;
    }

    public Reportes(Integer idreporte, String cicloesc, String periodo, String descripcion, String sancion, String estatusrep, Date fecharepgen) {
        this.idreporte = idreporte;
        this.cicloesc = cicloesc;
        this.periodo = periodo;
        this.descripcion = descripcion;
        this.sancion = sancion;
        this.estatusrep = estatusrep;
        this.fecharepgen = fecharepgen;
    }

    public Integer getIdreporte() {
        return idreporte;
    }

    public void setIdreporte(Integer idreporte) {
        this.idreporte = idreporte;
    }

    public String getCicloesc() {
        return cicloesc;
    }

    public void setCicloesc(String cicloesc) {
        this.cicloesc = cicloesc;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSancion() {
        return sancion;
    }

    public void setSancion(String sancion) {
        this.sancion = sancion;
    }

    public String getEstatusrep() {
        return estatusrep;
    }

    public void setEstatusrep(String estatusrep) {
        this.estatusrep = estatusrep;
    }

    public Date getFecharepgen() {
        return fecharepgen;
    }

    public void setFecharepgen(Date fecharepgen) {
        this.fecharepgen = fecharepgen;
    }

    public Date getFecharepent() {
        return fecharepent;
    }

    public void setFecharepent(Date fecharepent) {
        this.fecharepent = fecharepent;
    }

    public Date getFecharepcum() {
        return fecharepcum;
    }

    public void setFecharepcum(Date fecharepcum) {
        this.fecharepcum = fecharepcum;
    }

    public Alumno getNumalumno() {
        return numalumno;
    }

    public void setNumalumno(Alumno numalumno) {
        this.numalumno = numalumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreporte != null ? idreporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reportes)) {
            return false;
        }
        Reportes other = (Reportes) object;
        if ((this.idreporte == null && other.idreporte != null) || (this.idreporte != null && !this.idreporte.equals(other.idreporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matersys.escuelaapp.entity.Reportes[ idreporte=" + idreporte + " ]";
    }
    
}
