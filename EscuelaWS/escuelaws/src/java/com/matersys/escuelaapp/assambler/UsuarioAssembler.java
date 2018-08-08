/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.assambler;

import com.matersys.escuelaapp.dto.AdministrativoDTO;
import com.matersys.escuelaapp.dto.PadretutorDTO;
import com.matersys.escuelaapp.dto.ProfesorDTO;
import com.matersys.escuelaapp.dto.UsuarioDTO;
import com.matersys.escuelaapp.entity.Usuario;
import com.matersys.escuelaapp.util.TipoUsuario;

/**
 *
 * @author eiste
 */
public class UsuarioAssembler {
    public static UsuarioDTO assemblerUsuarioDTO(Usuario usuario) {
        UsuarioDTO udto = new UsuarioDTO();
        udto.setIdusuario(usuario.getIdusuario());
        udto.setPassword(usuario.getPassword());
        udto.setTipo(usuario.getTipo());
        udto.setEstatus(usuario.getEstatus());
        switch(usuario.getTipo()){
            case TipoUsuario.PADRE:
                udto.setPadreTutorDTO(UsuarioAssembler.assemblerPadretutorDTO(usuario));
                break;
            case TipoUsuario.PROFESOR:
                udto.setProfesorDTO(UsuarioAssembler.assemblerProfesorDTO(usuario));
                break;
            case TipoUsuario.ADMINISTRATIVO:
                udto.setAdministrativoDTO(UsuarioAssembler.assemblerAdministrativoDTO(usuario));
        }
        return udto;
    }
    
    public static PadretutorDTO assemblerPadretutorDTO(Usuario usuario) {
        if (usuario.getPadretutor() == null) {
            return null;
        }
        PadretutorDTO padret = new PadretutorDTO();
        padret.setIdusuario(usuario.getIdusuario());
        padret.setIdusuario(usuario.getPadretutor().getIdusuario());
        padret.setNombre(usuario.getPadretutor().getNombre());
        padret.setEscolaridad(usuario.getPadretutor().getEscolaridad());
        padret.setOcupacion(usuario.getPadretutor().getOcupacion());
        padret.setEstadocivil(usuario.getPadretutor().getEstadocivil());
        padret.setEmail(usuario.getPadretutor().getEmail());
        padret.setCelular(usuario.getPadretutor().getCelular());
        padret.setCelAlt1(usuario.getPadretutor().getCelAlt1());
        padret.setCelAlt2(usuario.getPadretutor().getCelAlt2());
        padret.setTelCasa(usuario.getPadretutor().getTelCasa());
        padret.setTelOfi(usuario.getPadretutor().getTelOfi());
        return padret;
    }
    
    public static ProfesorDTO assemblerProfesorDTO(Usuario usuario) {
        if (usuario.getProfesor() == null) {
            return null;
        }
        ProfesorDTO prof = new ProfesorDTO();
        prof.setIdusuario(usuario.getIdusuario());
        prof.setIdprofesor(usuario.getProfesor().getIdprofesor());
        prof.setNombre(usuario.getProfesor().getNombre());
        prof.setEmail(usuario.getProfesor().getEmail());
        prof.setCelular(usuario.getProfesor().getCelular());
        prof.setNivelestudios(usuario.getProfesor().getNivelestudios());
        return prof;
    }
    
    public static AdministrativoDTO assemblerAdministrativoDTO(Usuario usuario) {
        if (usuario.getAdministrativo()== null) {
            return null;
        }
        AdministrativoDTO administrativo = new AdministrativoDTO();
        administrativo.setIdadministrativo(usuario.getAdministrativo().getAdministrativoPK().getIdadministrativo());
        administrativo.setEscuela(usuario.getAdministrativo().getAdministrativoPK().getEscuela());
        administrativo.setIdusuario(usuario.getIdusuario());
        administrativo.setNombre(usuario.getAdministrativo().getNombre());
        administrativo.setPuesto(usuario.getAdministrativo().getPuesto());
        administrativo.setEmail(usuario.getAdministrativo().getEmail());
        administrativo.setCelular(usuario.getAdministrativo().getCelular());
        return administrativo;
    }
}
