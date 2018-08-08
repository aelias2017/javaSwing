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
public class ProfesorDTO implements java.io.Serializable {

    private String idprofesor;
    private String nombre;
    private String nivelestudios;
    private String email;
    private String celular;
    private String idusuario;
    private CredencialesDTO cdto;

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
     * @return the nivelestudios
     */
    public String getNivelestudios() {
        return nivelestudios;
    }

    /**
     * @param nivelestudios the nivelestudios to set
     */
    public void setNivelestudios(String nivelestudios) {
        this.nivelestudios = nivelestudios;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the idusuario
     */
    public String getIdusuario() {
        return idusuario;
    }

    /**
     * @param idusuario the idusuario to set
     */
    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
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
