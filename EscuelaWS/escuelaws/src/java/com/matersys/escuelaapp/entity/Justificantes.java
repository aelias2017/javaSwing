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
@Table(name = "justificantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Justificantes.findAll", query = "SELECT j FROM Justificantes j"),
    @NamedQuery(name = "Justificantes.findByIdjustificante", query = "SELECT j FROM Justificantes j WHERE j.idjustificante = :idjustificante"),
    @NamedQuery(name = "Justificantes.findByCicloesc", query = "SELECT j FROM Justificantes j WHERE j.cicloesc = :cicloesc"),
    @NamedQuery(name = "Justificantes.findByPeriodo", query = "SELECT j FROM Justificantes j WHERE j.periodo = :periodo"),
    @NamedQuery(name = "Justificantes.findByAsunto", query = "SELECT j FROM Justificantes j WHERE j.asunto = :asunto"),
    @NamedQuery(name = "Justificantes.findByEstatusjus", query = "SELECT j FROM Justificantes j WHERE j.estatusjus = :estatusjus"),
    @NamedQuery(name = "Justificantes.findByFechajusgen", query = "SELECT j FROM Justificantes j WHERE j.fechajusgen = :fechajusgen"),
    @NamedQuery(name = "Justificantes.findByFechajusent", query = "SELECT j FROM Justificantes j WHERE j.fechajusent = :fechajusent"),
    @NamedQuery(name = "Justificantes.findByFotojus", query = "SELECT j FROM Justificantes j WHERE j.fotojus = :fotojus")})
public class Justificantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idjustificante")
    private Integer idjustificante;
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
    @Size(min = 1, max = 180)
    @Column(name = "asunto")
    private String asunto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estatusjus")
    private String estatusjus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechajusgen")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechajusgen;
    @Column(name = "fechajusent")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechajusent;
    @Size(max = 90)
    @Column(name = "fotojus")
    private String fotojus;
    @JoinColumn(name = "numalumno", referencedColumnName = "numalumno")
    @ManyToOne(optional = false)
    private Alumno numalumno;

    public Justificantes() {
    }

    public Justificantes(Integer idjustificante) {
        this.idjustificante = idjustificante;
    }

    public Justificantes(Integer idjustificante, String cicloesc, String periodo, String asunto, String estatusjus, Date fechajusgen) {
        this.idjustificante = idjustificante;
        this.cicloesc = cicloesc;
        this.periodo = periodo;
        this.asunto = asunto;
        this.estatusjus = estatusjus;
        this.fechajusgen = fechajusgen;
    }

    public Integer getIdjustificante() {
        return idjustificante;
    }

    public void setIdjustificante(Integer idjustificante) {
        this.idjustificante = idjustificante;
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

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getEstatusjus() {
        return estatusjus;
    }

    public void setEstatusjus(String estatusjus) {
        this.estatusjus = estatusjus;
    }

    public Date getFechajusgen() {
        return fechajusgen;
    }

    public void setFechajusgen(Date fechajusgen) {
        this.fechajusgen = fechajusgen;
    }

    public Date getFechajusent() {
        return fechajusent;
    }

    public void setFechajusent(Date fechajusent) {
        this.fechajusent = fechajusent;
    }

    public String getFotojus() {
        return fotojus;
    }

    public void setFotojus(String fotojus) {
        this.fotojus = fotojus;
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
        hash += (idjustificante != null ? idjustificante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Justificantes)) {
            return false;
        }
        Justificantes other = (Justificantes) object;
        if ((this.idjustificante == null && other.idjustificante != null) || (this.idjustificante != null && !this.idjustificante.equals(other.idjustificante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matersys.escuelaapp.entity.Justificantes[ idjustificante=" + idjustificante + " ]";
    }
    
}
