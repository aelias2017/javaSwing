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
public class ActualizarDatosAlumnoDTO implements java.io.Serializable {
    private CredencialesDTO cdto;
    private String curpAlumno;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String numhnos;

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
}
