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
public class PadretutorDTO implements java.io.Serializable {
    private String idusuario;
    private String nombre;
    private String escolaridad;
    private String ocupacion;
    private String estadocivil;
    private String email;
    private String celular;
    private String celAlt1;
    private String celAlt2;
    private String telCasa;
    private String telOfi;
    private CredencialesDTO cdto;
    
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
     * @return the escolaridad
     */
    public String getEscolaridad() {
        return escolaridad;
    }

    /**
     * @param escolaridad the escolaridad to set
     */
    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    /**
     * @return the ocupacion
     */
    public String getOcupacion() {
        return ocupacion;
    }

    /**
     * @param ocupacion the ocupacion to set
     */
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    /**
     * @return the estadocivil
     */
    public String getEstadocivil() {
        return estadocivil;
    }

    /**
     * @param estadocivil the estadocivil to set
     */
    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
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
     * @return the celAlt1
     */
    public String getCelAlt1() {
        return celAlt1;
    }

    /**
     * @param celAlt1 the celAlt1 to set
     */
    public void setCelAlt1(String celAlt1) {
        this.celAlt1 = celAlt1;
    }

    /**
     * @return the celAlt2
     */
    public String getCelAlt2() {
        return celAlt2;
    }

    /**
     * @param celAlt2 the celAlt2 to set
     */
    public void setCelAlt2(String celAlt2) {
        this.celAlt2 = celAlt2;
    }

    /**
     * @return the telCasa
     */
    public String getTelCasa() {
        return telCasa;
    }

    /**
     * @param telCasa the telCasa to set
     */
    public void setTelCasa(String telCasa) {
        this.telCasa = telCasa;
    }

    /**
     * @return the telOfi
     */
    public String getTelOfi() {
        return telOfi;
    }

    /**
     * @param telOfi the telOfi to set
     */
    public void setTelOfi(String telOfi) {
        this.telOfi = telOfi;
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
