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
@Table(name = "citatorios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Citatorios.findAll", query = "SELECT c FROM Citatorios c"),
    @NamedQuery(name = "Citatorios.findByIdcitatorio", query = "SELECT c FROM Citatorios c WHERE c.idcitatorio = :idcitatorio"),
    @NamedQuery(name = "Citatorios.findByCicloescolar", query = "SELECT c FROM Citatorios c WHERE c.cicloescolar = :cicloescolar"),
    @NamedQuery(name = "Citatorios.findByPeriodo", query = "SELECT c FROM Citatorios c WHERE c.periodo = :periodo"),
    @NamedQuery(name = "Citatorios.findByAsunto", query = "SELECT c FROM Citatorios c WHERE c.asunto = :asunto"),
    @NamedQuery(name = "Citatorios.findByFechahora", query = "SELECT c FROM Citatorios c WHERE c.fechahora = :fechahora"),
    @NamedQuery(name = "Citatorios.findByTipocita", query = "SELECT c FROM Citatorios c WHERE c.tipocita = :tipocita"),
    @NamedQuery(name = "Citatorios.findByEstatuscita", query = "SELECT c FROM Citatorios c WHERE c.estatuscita = :estatuscita"),
    @NamedQuery(name = "Citatorios.findByFechacitagen", query = "SELECT c FROM Citatorios c WHERE c.fechacitagen = :fechacitagen"),
    @NamedQuery(name = "Citatorios.findByFechacitaent", query = "SELECT c FROM Citatorios c WHERE c.fechacitaent = :fechacitaent"),
    @NamedQuery(name = "Citatorios.findByFechacitacum", query = "SELECT c FROM Citatorios c WHERE c.fechacitacum = :fechacitacum")})
public class Citatorios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcitatorio")
    private Integer idcitatorio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "cicloescolar")
    private String cicloescolar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "periodo")
    private String periodo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "asunto")
    private String asunto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fechahora")
    private String fechahora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "tipocita")
    private String tipocita;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estatuscita")
    private String estatuscita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacitagen")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacitagen;
    @Column(name = "fechacitaent")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacitaent;
    @Column(name = "fechacitacum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacitacum;
    @JoinColumn(name = "numalumno", referencedColumnName = "numalumno")
    @ManyToOne(optional = false)
    private Alumno numalumno;

    public Citatorios() {
    }

    public Citatorios(Integer idcitatorio) {
        this.idcitatorio = idcitatorio;
    }

    public Citatorios(Integer idcitatorio, String cicloescolar, String periodo, String asunto, String fechahora, String tipocita, String estatuscita, Date fechacitagen) {
        this.idcitatorio = idcitatorio;
        this.cicloescolar = cicloescolar;
        this.periodo = periodo;
        this.asunto = asunto;
        this.fechahora = fechahora;
        this.tipocita = tipocita;
        this.estatuscita = estatuscita;
        this.fechacitagen = fechacitagen;
    }

    public Integer getIdcitatorio() {
        return idcitatorio;
    }

    public void setIdcitatorio(Integer idcitatorio) {
        this.idcitatorio = idcitatorio;
    }

    public String getCicloescolar() {
        return cicloescolar;
    }

    public void setCicloescolar(String cicloescolar) {
        this.cicloescolar = cicloescolar;
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

    public String getFechahora() {
        return fechahora;
    }

    public void setFechahora(String fechahora) {
        this.fechahora = fechahora;
    }

    public String getTipocita() {
        return tipocita;
    }

    public void setTipocita(String tipocita) {
        this.tipocita = tipocita;
    }

    public String getEstatuscita() {
        return estatuscita;
    }

    public void setEstatuscita(String estatuscita) {
        this.estatuscita = estatuscita;
    }

    public Date getFechacitagen() {
        return fechacitagen;
    }

    public void setFechacitagen(Date fechacitagen) {
        this.fechacitagen = fechacitagen;
    }

    public Date getFechacitaent() {
        return fechacitaent;
    }

    public void setFechacitaent(Date fechacitaent) {
        this.fechacitaent = fechacitaent;
    }

    public Date getFechacitacum() {
        return fechacitacum;
    }

    public void setFechacitacum(Date fechacitacum) {
        this.fechacitacum = fechacitacum;
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
        hash += (idcitatorio != null ? idcitatorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citatorios)) {
            return false;
        }
        Citatorios other = (Citatorios) object;
        if ((this.idcitatorio == null && other.idcitatorio != null) || (this.idcitatorio != null && !this.idcitatorio.equals(other.idcitatorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matersys.escuelaapp.entity.Citatorios[ idcitatorio=" + idcitatorio + " ]";
    }
    
}
