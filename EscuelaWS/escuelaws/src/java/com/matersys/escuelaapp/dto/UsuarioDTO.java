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
public class UsuarioDTO implements java.io.Serializable {
    private String idusuario;
    private String password;
    private String tipo;
    private String estatus;
    private PadretutorDTO padreTutorDTO;
    private ProfesorDTO profesorDTO;
    private AdministrativoDTO administrativoDTO;

    /**
     * @return the idusuario
     */
    public String getIdusuario() {
        return idusuario;
    }

    /**
     * @param idusuario the idusuario to set
     */
    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the estatus
     */
    public String getEstatus() {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    /**
     * @return the padreTutorDTO
     */
    public PadretutorDTO getPadreTutorDTO() {
        return padreTutorDTO;
    }

    /**
     * @param padreTutorDTO the padreTutorDTO to set
     */
    public void setPadreTutorDTO(PadretutorDTO padreTutorDTO) {
        this.padreTutorDTO = padreTutorDTO;
    }

    /**
     * @return the profesorDTO
     */
    public ProfesorDTO getProfesorDTO() {
        return profesorDTO;
    }

    /**
     * @param profesorDTO the profesorDTO to set
     */
    public void setProfesorDTO(ProfesorDTO profesorDTO) {
        this.profesorDTO = profesorDTO;
    }

    /**
     * @return the administrativoDTO
     */
    public AdministrativoDTO getAdministrativoDTO() {
        return administrativoDTO;
    }

    /**
     * @param administrativoDTO the administrativoDTO to set
     */
    public void setAdministrativoDTO(AdministrativoDTO administrativoDTO) {
        this.administrativoDTO = administrativoDTO;
    }
    
}
