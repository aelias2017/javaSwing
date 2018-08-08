/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.dto;

import java.util.List;

/**
 *
 * @author eiste
 */
public class ActaPeriodoDTO implements java.io.Serializable {
    private AsignacionesProfesDTO asignacion;
    private String periodo;
    private List<CalificacionesActaDTO> alumno;

    /**
     * @return the asignacion
     */
    public AsignacionesProfesDTO getAsignacion() {
        return asignacion;
    }

    /**
     * @param asignacion the asignacion to set
     */
    public void setAsignacion(AsignacionesProfesDTO asignacion) {
        this.asignacion = asignacion;
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
     * @return the alumno
     */
    public List<CalificacionesActaDTO> getAlumno() {
        return alumno;
    }

    /**
     * @param alumno the alumno to set
     */
    public void setAlumno(List<CalificacionesActaDTO> alumno) {
        this.alumno = alumno;
    }
 
}
