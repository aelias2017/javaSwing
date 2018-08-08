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
public class AdministrativoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "idadministrativo")
    private String idadministrativo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "escuela")
    private String escuela;

    public AdministrativoPK() {
    }

    public AdministrativoPK(String idadministrativo, String escuela) {
        this.idadministrativo = idadministrativo;
        this.escuela = escuela;
    }

    public String getIdadministrativo() {
        return idadministrativo;
    }

    public void setIdadministrativo(String idadministrativo) {
        this.idadministrativo = idadministrativo;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idadministrativo != null ? idadministrativo.hashCode() : 0);
        hash += (escuela != null ? escuela.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdministrativoPK)) {
            return false;
        }
        AdministrativoPK other = (AdministrativoPK) object;
        if ((this.idadministrativo == null && other.idadministrativo != null) || (this.idadministrativo != null && !this.idadministrativo.equals(other.idadministrativo))) {
            return false;
        }
        if ((this.escuela == null && other.escuela != null) || (this.escuela != null && !this.escuela.equals(other.escuela))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matersys.escuelaapp.entity.AdministrativoPK[ idadministrativo=" + idadministrativo + ", escuela=" + escuela + " ]";
    }
    
}
