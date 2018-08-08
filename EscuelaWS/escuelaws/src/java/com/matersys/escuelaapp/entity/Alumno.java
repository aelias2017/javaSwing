/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author eiste
 */
@Entity
@Table(name = "alumno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a"),
    @NamedQuery(name = "Alumno.findByNumalumno", query = "SELECT a FROM Alumno a WHERE a.numalumno = :numalumno"),
    @NamedQuery(name = "Alumno.findByCurp", query = "SELECT a FROM Alumno a WHERE a.curp = :curp"),
    @NamedQuery(name = "Alumno.findByMatricula", query = "SELECT a FROM Alumno a WHERE a.matricula = :matricula"),
    @NamedQuery(name = "Alumno.findByNombre", query = "SELECT a FROM Alumno a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Alumno.findByApellido1", query = "SELECT a FROM Alumno a WHERE a.apellido1 = :apellido1"),
    @NamedQuery(name = "Alumno.findByApellido2", query = "SELECT a FROM Alumno a WHERE a.apellido2 = :apellido2"),
    @NamedQuery(name = "Alumno.findByFechanac", query = "SELECT a FROM Alumno a WHERE a.fechanac = :fechanac"),
    @NamedQuery(name = "Alumno.findByNumhnos", query = "SELECT a FROM Alumno a WHERE a.numhnos = :numhnos"),
    @NamedQuery(name = "Alumno.findByPoshnos", query = "SELECT a FROM Alumno a WHERE a.poshnos = :poshnos"),
    @NamedQuery(name = "Alumno.findByParentutor", query = "SELECT a FROM Alumno a WHERE a.parentutor = :parentutor"),
    @NamedQuery(name = "Alumno.findByEstatusalum", query = "SELECT a FROM Alumno a WHERE a.estatusalum = :estatusalum")})
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numalumno")
    private Integer numalumno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "curp")
    private String curp;
    @Size(max = 45)
    @Column(name = "matricula")
    private String matricula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido1")
    private String apellido1;
    @Size(max = 45)
    @Column(name = "apellido2")
    private String apellido2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechanac")
    @Temporal(TemporalType.DATE)
    private Date fechanac;
    @Size(max = 2)
    @Column(name = "numhnos")
    private String numhnos;
    @Size(max = 2)
    @Column(name = "poshnos")
    private String poshnos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "parentutor")
    private String parentutor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estatusalum")
    private String estatusalum;
    @JoinColumn(name = "idpadretutor", referencedColumnName = "idusuario")
    @ManyToOne
    private Padretutor idpadretutor;
    @JoinColumns({
        @JoinColumn(name = "escuela", referencedColumnName = "escuela"),
        @JoinColumn(name = "nivel", referencedColumnName = "nivel"),
        @JoinColumn(name = "grado", referencedColumnName = "grado"),
        @JoinColumn(name = "grupo", referencedColumnName = "grupo")})
    @ManyToOne(optional = false)
    private Grupo grupo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numalumno")
    private List<Citatorios> citatoriosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numalumno")
    private List<Reportes> reportesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numalumno")
    private List<Justificantes> justificantesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private List<Calificaciones> calificacionesList;

    public Alumno() {
    }

    public Alumno(Integer numalumno) {
        this.numalumno = numalumno;
    }

    public Alumno(Integer numalumno, String curp, String nombre, String apellido1, Date fechanac, String parentutor, String estatusalum) {
        this.numalumno = numalumno;
        this.curp = curp;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.fechanac = fechanac;
        this.parentutor = parentutor;
        this.estatusalum = estatusalum;
    }

    public Integer getNumalumno() {
        return numalumno;
    }

    public void setNumalumno(Integer numalumno) {
        this.numalumno = numalumno;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Date getFechanac() {
        return fechanac;
    }

    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    public String getNumhnos() {
        return numhnos;
    }

    public void setNumhnos(String numhnos) {
        this.numhnos = numhnos;
    }

    public String getPoshnos() {
        return poshnos;
    }

    public void setPoshnos(String poshnos) {
        this.poshnos = poshnos;
    }

    public String getParentutor() {
        return parentutor;
    }

    public void setParentutor(String parentutor) {
        this.parentutor = parentutor;
    }

    public String getEstatusalum() {
        return estatusalum;
    }

    public void setEstatusalum(String estatusalum) {
        this.estatusalum = estatusalum;
    }

    public Padretutor getIdpadretutor() {
        return idpadretutor;
    }

    public void setIdpadretutor(Padretutor idpadretutor) {
        this.idpadretutor = idpadretutor;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @XmlTransient
    public List<Citatorios> getCitatoriosList() {
        return citatoriosList;
    }

    public void setCitatoriosList(List<Citatorios> citatoriosList) {
        this.citatoriosList = citatoriosList;
    }

    @XmlTransient
    public List<Reportes> getReportesList() {
        return reportesList;
    }

    public void setReportesList(List<Reportes> reportesList) {
        this.reportesList = reportesList;
    }

    @XmlTransient
    public List<Justificantes> getJustificantesList() {
        return justificantesList;
    }

    public void setJustificantesList(List<Justificantes> justificantesList) {
        this.justificantesList = justificantesList;
    }

    @XmlTransient
    public List<Calificaciones> getCalificacionesList() {
        return calificacionesList;
    }

    public void setCalificacionesList(List<Calificaciones> calificacionesList) {
        this.calificacionesList = calificacionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numalumno != null ? numalumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.numalumno == null && other.numalumno != null) || (this.numalumno != null && !this.numalumno.equals(other.numalumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.matersys.escuelaapp.entity.Alumno[ numalumno=" + numalumno + " ]";
    }
    
}
