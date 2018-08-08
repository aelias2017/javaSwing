/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.dto.alumno;

import com.matersys.escuelaapp.dto.CredencialesDTO;

/**
 *
 * @author eiste
 */
public class ActualizarMatriculaAlumnoDTO implements java.io.Serializable {
    private CredencialesDTO cdto;
    private String curpAlumno;
    private String matricula;

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
     * @return the curpAlumno
     */
    public String getCurpAlumno() {
        return curpAlumno;
    }

    /**
     * @param curpAlumno the curpAlumno to set
     */
    public void setCurpAlumno(String curpAlumno) {
        this.curpAlumno = curpAlumno;
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
    
}
