/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.dto;

import java.util.Date;

/**
 *
 * @author eiste
 */
public class JustificantesDTO implements java.io.Serializable {
    private Integer idjustificante;
    private String cicloesc;
    private String periodo;
    private String asunto;
    private String estatusjus;
    private Date fechajusgen;
    private Date fechajusent;
    private String fotojus;
    private Integer numalumno;
    private CredencialesDTO cdto;

    /**
     * @return the idjustificante
     */
    public Integer getIdjustificante() {
        return idjustificante;
    }

    /**
     * @param idjustificante the idjustificante to set
     */
    public void setIdjustificante(Integer idjustificante) {
        this.idjustificante = idjustificante;
    }

    /**
     * @return the cicloesc
     */
    public String getCicloesc() {
        return cicloesc;
    }

    /**
     * @param cicloesc the cicloesc to set
     */
    public void setCicloesc(String cicloesc) {
        this.cicloesc = cicloesc;
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
     * @return the asunto
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * @param asunto the asunto to set
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    /**
     * @return the estatusjus
     */
    public String getEstatusjus() {
        return estatusjus;
    }

    /**
     * @param estatusjus the estatusjus to set
     */
    public void setEstatusjus(String estatusjus) {
        this.estatusjus = estatusjus;
    }

    /**
     * @return the fechajusgen
     */
    public Date getFechajusgen() {
        return fechajusgen;
    }

    /**
     * @param fechajusgen the fechajusgen to set
     */
    public void setFechajusgen(Date fechajusgen) {
        this.fechajusgen = fechajusgen;
    }

    /**
     * @return the fechajusent
     */
    public Date getFechajusent() {
        return fechajusent;
    }

    /**
     * @param fechajusent the fechajusent to set
     */
    public void setFechajusent(Date fechajusent) {
        this.fechajusent = fechajusent;
    }

    /**
     * @return the fotojus
     */
    public String getFotojus() {
        return fotojus;
    }

    /**
     * @param fotojus the fotojus to set
     */
    public void setFotojus(String fotojus) {
        this.fotojus = fotojus;
    }

    /**
     * @return the numalumno
     */
    public Integer getNumalumno() {
        return numalumno;
    }

    /**
     * @param numalumno the numalumno to set
     */
    public void setNumalumno(Integer numalumno) {
        this.numalumno = numalumno;
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
