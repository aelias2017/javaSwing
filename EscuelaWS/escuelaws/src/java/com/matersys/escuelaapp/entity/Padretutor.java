/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "padretutor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Padretutor.findAll", query = "SELECT p FROM Padretutor p"),
    @NamedQuery(name = "Padretutor.findByIdusuario", query = "SELECT p FROM Padretutor p WHERE p.idusuario = :idusuario"),
    @NamedQuery(name = "Padretutor.findByNombre", query = "SELECT p FROM Padretutor p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Padretutor.findByEscolaridad", query = "SELECT p FROM Padretutor p WHERE p.escolaridad = :escolaridad"),
    @NamedQuery(name = "Padretutor.findByOcupacion", query = "SELECT p FROM Padretutor p WHERE p.ocupacion = :ocupacion"),
    @NamedQuery(name = "Padretutor.findByEstadocivil", query = "SELECT p FROM Padretutor p WHERE p.estadocivil = :estadocivil"),
    @NamedQuery(name = "Padretutor.findByEmail", query = "SELECT p FROM Padretutor p WHERE p.email = :email"),
    @NamedQuery(name = "Padretutor.findByCelular", query = "SELECT p FROM Padretutor p WHERE p.celular = :celular"),
    @NamedQuery(name = "Padretutor.findByCelAlt1", query = "SELECT p FROM Padretutor p WHERE p.celAlt1 = :celAlt1"),
    @NamedQuery(name = "Padretutor.findByCelAlt2", query = "SELECT p FROM Padretutor p WHERE p.celAlt2 = :celAlt2"),
    @NamedQuery(name = "Padretutor.findByTelCasa", query = "SELECT p FROM Padretutor p WHERE p.telCasa = :telCasa"),
    @NamedQuery(name = "Padretutor.findByTelOfi", query = "SELECT p FROM Padretutor p WHERE p.telOfi = :telOfi")})
public class Padretutor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "idusuario")
    private String idusuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "escolaridad")
    private String escolaridad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ocupacion")
    private String ocupacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estadocivil")
    private String estadocivil;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
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
    @Size(max = 10)
    @Column(name = "cel_alt1")
    private String celAlt1;
    @Size(max = 10)
    @Column(name = "cel_alt2")
    private String celAlt2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tel_casa")
    private String telCasa;
    @Size(max = 10)
    @Column(name = "tel_ofi")
    private String telOfi;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;
    @OneToMany(mappedBy = "idpadretutor")
    private List<Alumno> alumnoList;

    public Padretutor() {
    }

    public Padretutor(String idusuario) {
        this.idusuario = idusuario;
    }

    public Padretutor(String idusuario, String nombre, String escolaridad, String ocupacion, String estadocivil, String email, String celular, String telCasa) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.escolaridad = escolaridad;
        this.ocupacion = ocupacion;
        this.estadocivil = estadocivil;
        this.email = email;
        this.celular = celular;
        this.telCasa = telCasa;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
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

    public String getCelAlt1() {
        return celAlt1;
    }

    public void setCelAlt1(String celAlt1) {
        this.celAlt1 = celAlt1;
    }

    public String getCelAlt2() {
        return celAlt2;
    }

    public void setCelAlt2(String celAlt2) {
        this.celAlt2 = celAlt2;
    }

    public String getTelCasa() {
        return telCasa;
    }

    public void setTelCasa(String telCasa) {
        this.telCasa = telCasa;
    }

    public String getTelOfi() {
        return telOfi;
    }

    public void setTelOfi(String telOfi) {
        this.telOfi = telOfi;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public List<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void setAlumnoList(List<Alumno> alumnoList) {
        this.alumnoList = alumnoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Padretutor)) {
            return false;
        }
        Padretutor other = (Padretutor) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matersys.escuelaapp.entity.Padretutor[ idusuario=" + idusuario + " ]";
    }
    
}
