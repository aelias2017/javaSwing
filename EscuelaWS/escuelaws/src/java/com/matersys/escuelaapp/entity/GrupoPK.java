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
public class GrupoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "escuela")
    private String escuela;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "nivel")
    private String nivel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "grado")
    private String grado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "grupo")
    private String grupo;

    public GrupoPK() {
    }

    public GrupoPK(String escuela, String nivel, String grado, String grupo) {
        this.escuela = escuela;
        this.nivel = nivel;
        this.grado = grado;
        this.grupo = grupo;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (escuela != null ? escuela.hashCode() : 0);
        hash += (nivel != null ? nivel.hashCode() : 0);
        hash += (grado != null ? grado.hashCode() : 0);
        hash += (grupo != null ? grupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoPK)) {
            return false;
        }
        GrupoPK other = (GrupoPK) object;
        if ((this.escuela == null && other.escuela != null) || (this.escuela != null && !this.escuela.equals(other.escuela))) {
            return false;
        }
        if ((this.nivel == null && other.nivel != null) || (this.nivel != null && !this.nivel.equals(other.nivel))) {
            return false;
        }
        if ((this.grado == null && other.grado != null) || (this.grado != null && !this.grado.equals(other.grado))) {
            return false;
        }
        if ((this.grupo == null && other.grupo != null) || (this.grupo != null && !this.grupo.equals(other.grupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matersys.escuelaapp.entity.GrupoPK[ escuela=" + escuela + ", nivel=" + nivel + ", grado=" + grado + ", grupo=" + grupo + " ]";
    }
    
}
