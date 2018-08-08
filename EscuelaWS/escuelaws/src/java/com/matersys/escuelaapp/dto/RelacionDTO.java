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
public class RelacionDTO implements java.io.Serializable {
    private CredencialesDTO cdto;
    private AsignacionesProfesDTO asignacion;
    private List<AlumnoDTO> alumno;

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
     * @return the alumno
     */
    public List<AlumnoDTO> getAlumno() {
        return alumno;
    }

    /**
     * @param alumno the alumno to set
     */
    public void setAlumno(List<AlumnoDTO> alumno) {
        this.alumno = alumno;
    }

   
}
