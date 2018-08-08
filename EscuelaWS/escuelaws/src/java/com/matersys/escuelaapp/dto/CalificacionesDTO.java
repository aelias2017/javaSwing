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
public class CalificacionesDTO implements java.io.Serializable {
    private int numalumno;
    private int idasignatura;
    private String ciclo;
    private String periodo;
    private String calificacion;
    private CredencialesDTO cdto;
    
    /**
     * @return the numalumno
     */
    public int getNumalumno() {
        return numalumno;
    }

    /**
     * @param numalumno the numalumno to set
     */
    public void setNumalumno(int numalumno) {
        this.numalumno = numalumno;
    }

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
     * @return the ciclo
     */
    public String getCiclo() {
        return ciclo;
    }

    /**
     * @param ciclo the ciclo to set
     */
    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    /**
     * @return the periodo
     */
    public String getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    /**
     * @return the calificacion
     */
    public String getCalificacion() {
        return calificacion;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
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
