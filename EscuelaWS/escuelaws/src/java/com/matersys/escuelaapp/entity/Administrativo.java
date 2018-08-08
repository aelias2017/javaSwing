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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eiste
 */
@Entity
@Table(name = "administrativo")
@XmlRootElement
@NamedQueries({
   @NamedQuery(name = "Administrativo.findAll", query = "SELECT a FROM Administrativo a"),
   @NamedQuery(name = "Administrativo.findByIdadministrativo", query = "SELECT a FROM Administrativo a WHERE a.administrativoPK.idadministrativo = :idadministrativo"),
   @NamedQuery(name = "Administrativo.findByEscuela", query = "SELECT a FROM Administrativo a WHERE a.administrativoPK.escuela = :escuela"),
   @NamedQuery(name = "Administrativo.findByNombre", query = "SELECT a FROM Administrativo a WHERE a.nombre = :nombre"),
   @NamedQuery(name = "Administrativo.findByPuesto", query = "SELECT a FROM Administrativo a WHERE a.puesto = :puesto"),
   @NamedQuery(name = "Administrativo.findByEmail", query = "SELECT a FROM Administrativo a WHERE a.email = :email"),
   @NamedQuery(name = "Administrativo.findByCelular", query = "SELECT a FROM Administrativo a WHERE a.celular = :celular"),
   @NamedQuery(name = "Administrativo.findById", query = "SELECT a FROM Administrativo a WHERE a.administrativoPK.idadministrativo = :idadministrativo AND "
           + "a.administrativoPK.escuela = :escuela")})
public class Administrativo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AdministrativoPK administrativoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "puesto")
    private String puesto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 90)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "celular")
    private String celular;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @OneToOne(optional = false)
    private Usuario idusuario;
    @JoinColumn(name = "escuela", referencedColumnName = "clave", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Escuela escuela1;

    public Administrativo() {
    }

    public Administrativo(AdministrativoPK administrativoPK) {
        this.administrativoPK = administrativoPK;
    }

    public Administrativo(AdministrativoPK administrativoPK, String nombre, String puesto, String email, String celular) {
        this.administrativoPK = administrativoPK;
        this.nombre = nombre;
        this.puesto = puesto;
        this.email = email;
        this.celular = celular;
    }

    public Administrativo(String idadministrativo, String escuela) {
        this.administrativoPK = new AdministrativoPK(idadministrativo, escuela);
    }

    public AdministrativoPK getAdministrativoPK() {
        return administrativoPK;
    }

    public void setAdministrativoPK(AdministrativoPK administrativoPK) {
        this.administrativoPK = administrativoPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public Escuela getEscuela1() {
        return escuela1;
    }

    public void setEscuela1(Escuela escuela1) {
        this.escuela1 = escuela1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (administrativoPK != null ? administrativoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrativo)) {
            return false;
        }
        Administrativo other = (Administrativo) object;
        if ((this.administrativoPK == null && other.administrativoPK != null) || (this.administrativoPK != null && !this.administrativoPK.equals(other.administrativoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matersys.escuelaapp.entity.Administrativo[ administrativoPK=" + administrativoPK + " ]";
    }
    
}
