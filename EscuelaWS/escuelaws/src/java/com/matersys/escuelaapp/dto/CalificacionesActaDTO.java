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
public class CalificacionesActaDTO implements java.io.Serializable {
    private int numalumno;
    private String calificacion;
    
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

}
