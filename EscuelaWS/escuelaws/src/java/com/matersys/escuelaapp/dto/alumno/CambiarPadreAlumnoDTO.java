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
public class CambiarPadreAlumnoDTO implements java.io.Serializable {
    private CredencialesDTO cdto;
    private String curpAlumno;
    private String parentutor;
    private String idpadretutor;

    /**
     * @return the parentutor
     */
    public String getParentutor() {
        return parentutor;
    }

    /**
     * @param parentutor the parentutor to set
     */
    public void setParentutor(String parentutor) {
        this.parentutor = parentutor;
    }

    /**
     * @return the idpadretutor
     */
    public String getIdpadretutor() {
        return idpadretutor;
    }

    /**
     * @param idpadretutor the idpadretutor to set
     */
    public void setIdpadretutor(String idpadretutor) {
        this.idpadretutor = idpadretutor;
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
