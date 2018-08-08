/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eiste
 */
@Entity
@Table(name = "asignacionesprofes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignacionesprofes.findAll", query = "SELECT a FROM Asignacionesprofes a"),
    @NamedQuery(name = "Asignacionesprofes.findByIdasignatura", query = "SELECT a FROM Asignacionesprofes a WHERE a.asignacionesprofesPK.idasignatura = :idasignatura"),
    @NamedQuery(name = "Asignacionesprofes.findByEscuela", query = "SELECT a FROM Asignacionesprofes a WHERE a.asignacionesprofesPK.escuela = :escuela"),
    @NamedQuery(name = "Asignacionesprofes.findByNivel", query = "SELECT a FROM Asignacionesprofes a WHERE a.asignacionesprofesPK.nivel = :nivel"),
    @NamedQuery(name = "Asignacionesprofes.findByGrado", query = "SELECT a FROM Asignacionesprofes a WHERE a.asignacionesprofesPK.grado = :grado"),
    @NamedQuery(name = "Asignacionesprofes.findByGrupo", query = "SELECT a FROM Asignacionesprofes a WHERE a.asignacionesprofesPK.grupo = :grupo"),
    @NamedQuery(name = "Asignacionesprofes.findByCicloesc", query = "SELECT a FROM Asignacionesprofes a WHERE a.asignacionesprofesPK.cicloesc = :cicloesc"),
    @NamedQuery(name = "Asignacionesprofes.findById", query = "SELECT a FROM Asignacionesprofes a WHERE a.asignacionesprofesPK.idasignatura = :idasignatura AND "
                                                                                                    + "a.asignacionesprofesPK.escuela = :escuela AND "
                                                                                                    + "a.asignacionesprofesPK.nivel = :nivel AND "
                                                                                                    + "a.asignacionesprofesPK.grado = :grado AND "
                                                                                                    + "a.asignacionesprofesPK.grupo = :grupo AND "
                                                                                                    + "a.asignacionesprofesPK.cicloesc = :cicloesc")})
public class Asignacionesprofes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AsignacionesprofesPK asignacionesprofesPK;
    @JoinColumn(name = "idprofesor", referencedColumnName = "idprofesor")
    @ManyToOne
    private Profesor idprofesor;
    @JoinColumns({
        @JoinColumn(name = "escuela", referencedColumnName = "escuela", insertable = false, updatable = false),
        @JoinColumn(name = "nivel", referencedColumnName = "nivel", insertable = false, updatable = false),
        @JoinColumn(name = "grado", referencedColumnName = "grado", insertable = false, updatable = false),
        @JoinColumn(name = "grupo", referencedColumnName = "grupo", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Grupo grupo1;
    @JoinColumn(name = "idasignatura", referencedColumnName = "idasignatura", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Asignatura asignatura;

    public Asignacionesprofes() {
    }

    public Asignacionesprofes(AsignacionesprofesPK asignacionesprofesPK) {
        this.asignacionesprofesPK = asignacionesprofesPK;
    }

    public Asignacionesprofes(int idasignatura, String escuela, String nivel, String grado, String grupo, String cicloesc) {
        this.asignacionesprofesPK = new AsignacionesprofesPK(idasignatura, escuela, nivel, grado, grupo, cicloesc);
    }

    public AsignacionesprofesPK getAsignacionesprofesPK() {
        return asignacionesprofesPK;
    }

    public void setAsignacionesprofesPK(AsignacionesprofesPK asignacionesprofesPK) {
        this.asignacionesprofesPK = asignacionesprofesPK;
    }

    public Profesor getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(Profesor idprofesor) {
        this.idprofesor = idprofesor;
    }

    public Grupo getGrupo1() {
        return grupo1;
    }

    public void setGrupo1(Grupo grupo1) {
        this.grupo1 = grupo1;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asignacionesprofesPK != null ? asignacionesprofesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignacionesprofes)) {
            return false;
        }
        Asignacionesprofes other = (Asignacionesprofes) object;
        if ((this.asignacionesprofesPK == null && other.asignacionesprofesPK != null) || (this.asignacionesprofesPK != null && !this.asignacionesprofesPK.equals(other.asignacionesprofesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matersys.escuelaapp.entity.Asignacionesprofes[ asignacionesprofesPK=" + asignacionesprofesPK + " ]";
    }
    
}
