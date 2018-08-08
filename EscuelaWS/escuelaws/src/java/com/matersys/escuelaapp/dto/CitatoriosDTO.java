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
public class CitatoriosDTO implements java.io.Serializable {
    private Integer idcitatorio;
    private String cicloescolar;
    private String periodo;
    private String asunto;
    private String fechahora;
    private String tipocita;
    private String estatuscita;
    private Date fechacitagen;
    private Date fechacitaent;
    private Date fechacitacum;
    private Integer numalumno;
    private CredencialesDTO cdto;

    /**
     * @return the idcitatorio
     */
    public Integer getIdcitatorio() {
        return idcitatorio;
    }

    /**
     * @param idcitatorio the idcitatorio to set
     */
    public void setIdcitatorio(Integer idcitatorio) {
        this.idcitatorio = idcitatorio;
    }

    /**
     * @return the cicloescolar
     */
    public String getCicloescolar() {
        return cicloescolar;
    }

    /**
     * @param cicloescolar the cicloescolar to set
     */
    public void setCicloescolar(String cicloescolar) {
        this.cicloescolar = cicloescolar;
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
     * @return the fechahora
     */
    public String getFechahora() {
        return fechahora;
    }

    /**
     * @param fechahora the fechahora to set
     */
    public void setFechahora(String fechahora) {
        this.fechahora = fechahora;
    }

    /**
     * @return the tipocita
     */
    public String getTipocita() {
        return tipocita;
    }

    /**
     * @param tipocita the tipocita to set
     */
    public void setTipocita(String tipocita) {
        this.tipocita = tipocita;
    }

    /**
     * @return the estatuscita
     */
    public String getEstatuscita() {
        return estatuscita;
    }

    /**
     * @param estatuscita the estatuscita to set
     */
    public void setEstatuscita(String estatuscita) {
        this.estatuscita = estatuscita;
    }

    /**
     * @return the fechacitagen
     */
    public Date getFechacitagen() {
        return fechacitagen;
    }

    /**
     * @param fechacitagen the fechacitagen to set
     */
    public void setFechacitagen(Date fechacitagen) {
        this.fechacitagen = fechacitagen;
    }

    /**
     * @return the fechacitaent
     */
    public Date getFechacitaent() {
        return fechacitaent;
    }

    /**
     * @param fechacitaent the fechacitaent to set
     */
    public void setFechacitaent(Date fechacitaent) {
        this.fechacitaent = fechacitaent;
    }

    /**
     * @return the fechacitacum
     */
    public Date getFechacitacum() {
        return fechacitacum;
    }

    /**
     * @param fechacitacum the fechacitacum to set
     */
    public void setFechacitacum(Date fechacitacum) {
        this.fechacitacum = fechacitacum;
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
