/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author eiste
 */
@Entity
@Table(name = "escuela")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escuela.findAll", query = "SELECT e FROM Escuela e"),
    @NamedQuery(name = "Escuela.findByClave", query = "SELECT e FROM Escuela e WHERE e.clave = :clave"),
    @NamedQuery(name = "Escuela.findByNombre", query = "SELECT e FROM Escuela e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Escuela.findByEmail", query = "SELECT e FROM Escuela e WHERE e.email = :email"),
    @NamedQuery(name = "Escuela.findByEstatus", query = "SELECT e FROM Escuela e WHERE e.estatus = :estatus")})
public class Escuela implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "clave")
    private String clave;
    @Size(max = 90)
    @Column(name = "nombre")
    private String nombre;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 90)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estatus")
    private String estatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "escuela1")
    private List<Administrativo> administrativoList;

    public Escuela() {
    }

    public Escuela(String clave) {
        this.clave = clave;
    }

    public Escuela(String clave, String estatus) {
        this.clave = clave;
        this.estatus = estatus;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @XmlTransient
    public List<Administrativo> getAdministrativoList() {
        return administrativoList;
    }

    public void setAdministrativoList(List<Administrativo> administrativoList) {
        this.administrativoList = administrativoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clave != null ? clave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escuela)) {
            return false;
        }
        Escuela other = (Escuela) object;
        if ((this.clave == null && other.clave != null) || (this.clave != null && !this.clave.equals(other.clave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matersys.escuelaapp.entity.Escuela[ clave=" + clave + " ]";
    }
    
}
