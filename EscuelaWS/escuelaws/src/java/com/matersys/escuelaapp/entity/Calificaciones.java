/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eiste
 */
@Entity
@Table(name = "calificaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificaciones.findAll", query = "SELECT c FROM Calificaciones c"),
    @NamedQuery(name = "Calificaciones.findByNumalumno", query = "SELECT c FROM Calificaciones c WHERE c.calificacionesPK.numalumno = :numalumno"),
    @NamedQuery(name = "Calificaciones.findByIdasignatura", query = "SELECT c FROM Calificaciones c WHERE c.calificacionesPK.idasignatura = :idasignatura"),
    @NamedQuery(name = "Calificaciones.findByCiclo", query = "SELECT c FROM Calificaciones c WHERE c.calificacionesPK.ciclo = :ciclo"),
    @NamedQuery(name = "Calificaciones.findByPeriodo", query = "SELECT c FROM Calificaciones c WHERE c.calificacionesPK.periodo = :periodo"),
    @NamedQuery(name = "Calificaciones.findByCalificacion", query = "SELECT c FROM Calificaciones c WHERE c.calificacion = :calificacion")})
public class Calificaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CalificacionesPK calificacionesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "calificacion")
    private String calificacion;
    @JoinColumn(name = "idasignatura", referencedColumnName = "idasignatura", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Asignatura asignatura;
    @JoinColumn(name = "numalumno", referencedColumnName = "numalumno", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno;

    public Calificaciones() {
    }

    public Calificaciones(CalificacionesPK calificacionesPK) {
        this.calificacionesPK = calificacionesPK;
    }

    public Calificaciones(CalificacionesPK calificacionesPK, String calificacion) {
        this.calificacionesPK = calificacionesPK;
        this.calificacion = calificacion;
    }

    public Calificaciones(int numalumno, int idasignatura, String ciclo, String periodo) {
        this.calificacionesPK = new CalificacionesPK(numalumno, idasignatura, ciclo, periodo);
    }

    public CalificacionesPK getCalificacionesPK() {
        return calificacionesPK;
    }

    public void setCalificacionesPK(CalificacionesPK calificacionesPK) {
        this.calificacionesPK = calificacionesPK;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calificacionesPK != null ? calificacionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificaciones)) {
            return false;
        }
        Calificaciones other = (Calificaciones) object;
        if ((this.calificacionesPK == null && other.calificacionesPK != null) || (this.calificacionesPK != null && !this.calificacionesPK.equals(other.calificacionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matersys.escuelaapp.entity.Calificaciones[ calificacionesPK=" + calificacionesPK + " ]";
    }
    
}
