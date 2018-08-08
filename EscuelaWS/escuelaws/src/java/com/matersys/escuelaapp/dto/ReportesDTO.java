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
public class ReportesDTO implements java.io.Serializable {
    private Integer idreporte;
    private String cicloesc;
    private String periodo;
    private String descripcion;
    private String sancion;
    private String estatusrep;
    private Date fecharepgen;
    private Date fecharepent;
    private Date fecharepcum;
    private Integer numalumno;
    private CredencialesDTO cdto;

    /**
     * @return the idreporte
     */
    public Integer getIdreporte() {
        return idreporte;
    }

    /**
     * @param idreporte the idreporte to set
     */
    public void setIdreporte(Integer idreporte) {
        this.idreporte = idreporte;
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
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the sancion
     */
    public String getSancion() {
        return sancion;
    }

    /**
     * @param sancion the sancion to set
     */
    public void setSancion(String sancion) {
        this.sancion = sancion;
    }

    /**
     * @return the estatusrep
     */
    public String getEstatusrep() {
        return estatusrep;
    }

    /**
     * @param estatusrep the estatusrep to set
     */
    public void setEstatusrep(String estatusrep) {
        this.estatusrep = estatusrep;
    }

    /**
     * @return the fecharepgen
     */
    public Date getFecharepgen() {
        return fecharepgen;
    }

    /**
     * @param fecharepgen the fecharepgen to set
     */
    public void setFecharepgen(Date fecharepgen) {
        this.fecharepgen = fecharepgen;
    }

    /**
     * @return the fecharepent
     */
    public Date getFecharepent() {
        return fecharepent;
    }

    /**
     * @param fecharepent the fecharepent to set
     */
    public void setFecharepent(Date fecharepent) {
        this.fecharepent = fecharepent;
    }

    /**
     * @return the fecharepcum
     */
    public Date getFecharepcum() {
        return fecharepcum;
    }

    /**
     * @param fecharepcum the fecharepcum to set
     */
    public void setFecharepcum(Date fecharepcum) {
        this.fecharepcum = fecharepcum;
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
