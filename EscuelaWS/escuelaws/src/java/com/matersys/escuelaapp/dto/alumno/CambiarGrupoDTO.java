/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.dto.alumno;

import com.matersys.escuelaapp.dto.CredencialesDTO;


/**
 *
 * @author Alejandro Elias
 */
public class CambiarGrupoDTO implements java.io.Serializable{
    private String curpalumno;
    private String newgrupo;
    private CredencialesDTO cdto;

    /**
     * @return the curpalumno
     */
    public String getCurp() {
        return getCurpalumno();
    }

    /**
     * @param curp the curpalumno to set
     */
    public void setCurp(String curp) {
        this.setCurpalumno(curp);
    }

    /**
     * @return the newgrupo
     */
    public String getNewgrupo() {
        return newgrupo;
    }

    /**
     * @param newgrupo the newgrupo to set
     */
    public void setNewgrupo(String newgrupo) {
        this.newgrupo = newgrupo;
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
     * @return the curpalumno
     */
    public String getCurpalumno() {
        return curpalumno;
    }

    /**
     * @param curpalumno the curpalumno to set
     */
    public void setCurpalumno(String curpalumno) {
        this.curpalumno = curpalumno;
    }
    
}
