/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.dto;

/**
 *
 * @author eiste
 */
public class AsignacionesProfesDTO implements java.io.Serializable {

    private int idasignatura;
    private String escuela;
    private String nivel;
    private String grado;
    private String grupo;
    private String idprofesor;
    private CredencialesDTO cdto;
    
    /**
     * @return the idasignatura
     */
    public int getIdasignatura() {
        return idasignatura;
    }

    /**
     * @param idasignatura the idasignatura to set
     */
    public void setIdasignatura(int idasignatura) {
        this.idasignatura = idasignatura;
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

    /**
     * @return the idprofesor
     */
    public String getIdprofesor() {
        return idprofesor;
    }

    /**
     * @param idprofesor the idprofesor to set
     */
    public void setIdprofesor(String idprofesor) {
        this.idprofesor = idprofesor;
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

}
