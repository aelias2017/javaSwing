/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author eiste
 */
@Entity
@Table(name = "grupo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g"),
    @NamedQuery(name = "Grupo.findByEscuela", query = "SELECT g FROM Grupo g WHERE g.grupoPK.escuela = :escuela"),
    @NamedQuery(name = "Grupo.findByNivel", query = "SELECT g FROM Grupo g WHERE g.grupoPK.nivel = :nivel"),
    @NamedQuery(name = "Grupo.findByGrado", query = "SELECT g FROM Grupo g WHERE g.grupoPK.grado = :grado"),
    @NamedQuery(name = "Grupo.findByGrupo", query = "SELECT g FROM Grupo g WHERE g.grupoPK.grupo = :grupo"),
    @NamedQuery(name = "Grupo.findById", query = "SELECT g FROM Grupo g WHERE g.grupoPK.escuela = :escuela AND"
    + " g.grupoPK.nivel = :nivel AND g.grupoPK.grado = :grado AND g.grupoPK.grupo = :grupo ")})
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GrupoPK grupoPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupo1")
    private List<Asignacionesprofes> asignacionesprofesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupo")
    private List<Alumno> alumnoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupo")
    private List<Avisos> avisosList;

    public Grupo() {
    }

    public Grupo(GrupoPK grupoPK) {
        this.grupoPK = grupoPK;
    }

    public Grupo(String escuela, String nivel, String grado, String grupo) {
        this.grupoPK = new GrupoPK(escuela, nivel, grado, grupo);
    }

    public GrupoPK getGrupoPK() {
        return grupoPK;
    }

    public void setGrupoPK(GrupoPK grupoPK) {
        this.grupoPK = grupoPK;
    }

    @XmlTransient
    public List<Asignacionesprofes> getAsignacionesprofesList() {
        return asignacionesprofesList;
    }

    public void setAsignacionesprofesList(List<Asignacionesprofes> asignacionesprofesList) {
        this.asignacionesprofesList = asignacionesprofesList;
    }

    @XmlTransient
    public List<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void setAlumnoList(List<Alumno> alumnoList) {
        this.alumnoList = alumnoList;
    }

    @XmlTransient
    public List<Avisos> getAvisosList() {
        return avisosList;
    }

    public void setAvisosList(List<Avisos> avisosList) {
        this.avisosList = avisosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupoPK != null ? grupoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.grupoPK == null && other.grupoPK != null) || (this.grupoPK != null && !this.grupoPK.equals(other.grupoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matersys.escuelaapp.entity.Grupo[ grupoPK=" + grupoPK + " ]";
    }
    
}
