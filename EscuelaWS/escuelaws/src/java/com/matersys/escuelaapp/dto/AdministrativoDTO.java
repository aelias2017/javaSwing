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
public class AdministrativoDTO implements java.io.Serializable {
    private CredencialesDTO cdto;
    private String idadministrativo;
    private String escuela;
    private String idusuario;
    private String nombre;
    private String puesto;
    private String email;
    private String celular;

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
     * @return the idadministrativo
     */
    public String getIdadministrativo() {
        return idadministrativo;
    }

    /**
     * @param idadministrativo the idadministrativo to set
     */
    public void setIdadministrativo(String idadministrativo) {
        this.idadministrativo = idadministrativo;
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
     * @return the puesto
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * @param puesto the puesto to set
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
}
