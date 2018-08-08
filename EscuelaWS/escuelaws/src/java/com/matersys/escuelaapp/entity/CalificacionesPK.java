/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author eiste
 */
@Embeddable
public class CalificacionesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "numalumno")
    private int numalumno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idasignatura")
    private int idasignatura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "ciclo")
    private String ciclo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "periodo")
    private String periodo;

    public CalificacionesPK() {
    }

    public CalificacionesPK(int numalumno, int idasignatura, String ciclo, String periodo) {
        this.numalumno = numalumno;
        this.idasignatura = idasignatura;
        this.ciclo = ciclo;
        this.periodo = periodo;
    }

    public int getNumalumno() {
        return numalumno;
    }

    public void setNumalumno(int numalumno) {
        this.numalumno = numalumno;
    }

    public int getIdasignatura() {
        return idasignatura;
    }

    public void setIdasignatura(int idasignatura) {
        this.idasignatura = idasignatura;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numalumno;
        hash += (int) idasignatura;
        hash += (ciclo != null ? ciclo.hashCode() : 0);
        hash += (periodo != null ? periodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalificacionesPK)) {
            return false;
        }
        CalificacionesPK other = (CalificacionesPK) object;
        if (this.numalumno != other.numalumno) {
            return false;
        }
        if (this.idasignatura != other.idasignatura) {
            return false;
        }
        if ((this.ciclo == null && other.ciclo != null) || (this.ciclo != null && !this.ciclo.equals(other.ciclo))) {
            return false;
        }
        if ((this.periodo == null && other.periodo != null) || (this.periodo != null && !this.periodo.equals(other.periodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matersys.escuelaapp.entity.CalificacionesPK[ numalumno=" + numalumno + ", idasignatura=" + idasignatura + ", ciclo=" + ciclo + ", periodo=" + periodo + " ]";
    }
    
}
