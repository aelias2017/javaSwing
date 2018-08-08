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
public class AvisosDTO implements java.io.Serializable {
    private Integer idavisos;
    private String info;
    private String estatusaviso;
    private GrupoDTO grupoDTO;
    private CredencialesDTO cdto;

    /**
     * @return the idavisos
     */
    public Integer getIdavisos() {
        return idavisos;
    }

    /**
     * @param idavisos the idavisos to set
     */
    public void setIdavisos(Integer idavisos) {
        this.idavisos = idavisos;
    }

    /**
     * @return the info
     */
    public String getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * @return the estatusaviso
     */
    public String getEstatusaviso() {
        return estatusaviso;
    }

    /**
     * @param estatusaviso the estatusaviso to set
     */
    public void setEstatusaviso(String estatusaviso) {
        this.estatusaviso = estatusaviso;
    }

    /**
     * @return the grupoDTO
     */
    public GrupoDTO getGrupoDTO() {
        return grupoDTO;
    }

    /**
     * @param grupoDTO the grupoDTO to set
     */
    public void setGrupoDTO(GrupoDTO grupoDTO) {
        this.grupoDTO = grupoDTO;
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
