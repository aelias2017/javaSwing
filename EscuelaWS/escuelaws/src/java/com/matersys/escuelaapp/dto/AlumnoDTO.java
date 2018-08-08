/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.dto;

import java.util.Date;

/**
 *
 * @author eiste
 */
public class AlumnoDTO implements java.io.Serializable {
    private Integer numalumno;
    private String curp;
    private String matricula;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Date fechanac;
    private String numhnos;
    private String poshnos;
    private String parentutor;
    private String idpadretutor;
    private String escuela;
    private String nivel;
    private String grado;
    private String grupo;
    private String estatusalum;
    private CredencialesDTO cdto;

    /**
     * @return the numalumno
     */
    public Integer getNumalumno() {
        return numalumno;
    }

    /**
     * @param numalumno the numalumno to set
     */
    public void setNumalumno(Integer numalumno) {
        this.numalumno = numalumno;
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido1
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * @param apellido1 the apellido1 to set
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * @return the apellido2
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * @param apellido2 the apellido2 to set
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * @return the fechanac
     */
    public Date getFechanac() {
        return fechanac;
    }

    /**
     * @param fechanac the fechanac to set
     */
    public void setFechanac(Date fechanac) {
        this.fechanac = fechanac;
    }

    /**
     * @return the numhnos
     */
    public String getNumhnos() {
        return numhnos;
    }

    /**
     * @param numhnos the numhnos to set
     */
    public void setNumhnos(String numhnos) {
        this.numhnos = numhnos;
    }

    /**
     * @return the poshnos
     */
    public String getPoshnos() {
        return poshnos;
    }

    /**
     * @param poshnos the poshnos to set
     */
    public void setPoshnos(String poshnos) {
        this.poshnos = poshnos;
    }

    /**
     * @return the parentutor
     */
    public String getParentutor() {
        return parentutor;
    }

    /**
     * @param parentutor the parentutor to set
     */
    public void setParentutor(String parentutor) {
        this.parentutor = parentutor;
    }

    /**
     * @return the idpadretutor
     */
    public String getIdpadretutor() {
        return idpadretutor;
    }

    /**
     * @param idpadretutor the idpadretutor to set
     */
    public void setIdpadretutor(String idpadretutor) {
        this.idpadretutor = idpadretutor;
    }

    /**
     * @return the estatusalum
     */
    public String getEstatusalum() {
        return estatusalum;
    }

    /**
     * @param estatusalum the estatusalum to set
     */
    public void setEstatusalum(String estatusalum) {
        this.estatusalum = estatusalum;
    }

    /**
     * @return the curp
     */
    public String getCurp() {
        return curp;
    }

    /**
     * @param curp the curp to set
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     * @return the cdto
     */
    public CredencialesDTO getCdto() {
        return cdto;
    }

    /**
     * @param cdto the cdto to set
     */
    public void setCdto(CredencialesDTO cdto) {
        this.cdto = cdto;
    }

    /**
     * @return the escuela
     */
    public String getEscuela() {
        return escuela;
    }

    /**
     * @param escuela the escuela to set
     */
    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    /**
     * @return the nivel
     */
    public String getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    /**
     * @return the grado
     */
    public String getGrado() {
        return grado;
    }

    /**
     * @param grado the grado to set
     */
    public void setGrado(String grado) {
        this.grado = grado;
    }

    /**
     * @return the grupo
     */
    public String getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

}
