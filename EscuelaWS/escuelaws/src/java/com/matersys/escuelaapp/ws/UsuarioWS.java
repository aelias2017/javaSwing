/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.ws;

import com.matersys.escuelaapp.assambler.UsuarioAssembler;
import com.matersys.escuelaapp.dao.UsuarioDAO;
import com.matersys.escuelaapp.dao.imp.UsuarioDAOImp;
import com.matersys.escuelaapp.dto.CredencialesDTO;
import com.matersys.escuelaapp.dto.UsuarioDTO;
import com.matersys.escuelaapp.entity.Usuario;
import com.matersys.escuelaapp.util.EscuelaAppUtil;
import com.matersys.escuelaapp.util.EstatusUsuario;
import com.matersys.escuelaapp.util.TipoUsuario;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author eiste
 */
@WebService(serviceName = "admin/UsuarioWS")
public class UsuarioWS {

    private UsuarioDAO dao;

    @WebMethod(operationName = "consultarUsuario")
    public UsuarioDTO consultarUsuario(@WebParam(name = "cdto") CredencialesDTO cdto, 
            @WebParam(name = "username") String username) throws Exception {
        EscuelaAppUtil.validarAcceso(cdto, this.getClass());
        dao = new UsuarioDAOImp();
        Usuario usuario = dao.consultarUsuario(username);
        if (usuario == null) {
            return null;
        }
        return UsuarioAssembler.assemblerUsuarioDTO(usuario);
    }     
    
    @WebMethod(operationName = "crearUsuarioPadretutor")
    public String crearUsuarioPadretutor(@WebParam(name = "usuario") String idusuario) {
        Usuario usuario = new Usuario();
        usuario.setIdusuario(idusuario);
        String password = EscuelaAppUtil.generaPassword(idusuario);
        String encripta = EscuelaAppUtil.encripta(idusuario, password);
        usuario.setPassword(encripta);
        usuario.setTipo(TipoUsuario.PADRE);
        usuario.setEstatus(EstatusUsuario.ACTIVO);
        dao = new UsuarioDAOImp();
        try {
            dao.insertarUsuario(usuario);
        } catch (Exception e) {
            System.out.println("Exception [" + e.getMessage() + "]");
            return "failure";
        }
        return password;
    }

    @WebMethod(operationName = "crearUsuarioProfesor")
    public String crearUsuarioProfesor(@WebParam(name = "usuario") String idusuario) {
        Usuario usuario = new Usuario();
        usuario.setIdusuario(idusuario);
        String password = EscuelaAppUtil.generaPassword(idusuario);
        String encripta = EscuelaAppUtil.encripta(idusuario, password);
        usuario.setPassword(encripta);
        usuario.setTipo(TipoUsuario.PROFESOR);
        usuario.setEstatus(EstatusUsuario.ACTIVO);
        dao = new UsuarioDAOImp();
        try {
            dao.insertarUsuario(usuario);
        } catch (Exception e) {
            System.out.println("Exception [" + e.getMessage() + "]");
            return "failure";
        }
        return password;
    }

    @WebMethod(operationName = "crearUsuarioAdministrativo")
    public String crearUsuarioAdministrativo(@WebParam(name = "usuario") String idusuario) {
        Usuario usuario = new Usuario();
        usuario.setIdusuario(idusuario);
        String password = EscuelaAppUtil.generaPassword(idusuario);
        String encripta = EscuelaAppUtil.encripta(idusuario, password);
        usuario.setPassword(encripta);
        usuario.setTipo(TipoUsuario.ADMINISTRATIVO);
        usuario.setEstatus(EstatusUsuario.ACTIVO);
        dao = new UsuarioDAOImp();
        try {
            dao.insertarUsuario(usuario);
        } catch (Exception e) {
            System.out.println("Exception [" + e.getMessage() + "]");
            return "failure";
        }
        return password;
    }

    @WebMethod(operationName = "generarPasswordUsuario")
    public String generarPasswordUsuario(@WebParam(name = "usuario") String idusuario) {
        dao = new UsuarioDAOImp();
        Usuario usuario = dao.consultarUsuario(idusuario);
        if (usuario == null || !usuario.getEstatus().equals(EstatusUsuario.ACTIVO)) {
            return "noactivo";
        }
        String password = EscuelaAppUtil.generaPassword(idusuario);
        String encripta = EscuelaAppUtil.encripta(idusuario, password);
        usuario.setPassword(encripta);
        dao = new UsuarioDAOImp();
        try {
            dao.actualizarUsuario(usuario);
        } catch (Exception e) {
            System.out.println("Exception [" + e.getMessage() + "]");
            return "failure";
        }
        return password;
    }

    @WebMethod(operationName = "bloquearUsuario")
    public String bloquearUsuario(@WebParam(name = "usuario") String idusuario) {
        dao = new UsuarioDAOImp();
        Usuario usuario = dao.consultarUsuario(idusuario);
        if (usuario == null || usuario.getEstatus().equals(EstatusUsuario.BAJA)) {
            return "nouser";
        }
        usuario.setEstatus(EstatusUsuario.INACTIVO);
        dao = new UsuarioDAOImp();
        try {
            dao.actualizarUsuario(usuario);
        } catch (Exception e) {
            System.out.println("Exception [" + e.getMessage() + "]");
            return "failure";
        }
        return "success";
    }

    @WebMethod(operationName = "activarUsuario")
    public String activarUsuario(@WebParam(name = "usuario") String idusuario) {
        dao = new UsuarioDAOImp();
        Usuario usuario = dao.consultarUsuario(idusuario);
        if (usuario == null || usuario.getEstatus().equals(EstatusUsuario.BAJA)) {
            return "nouser";
        }
        usuario.setEstatus(EstatusUsuario.ACTIVO);
        dao = new UsuarioDAOImp();
        try {
            dao.actualizarUsuario(usuario);
        } catch (Exception e) {
            System.out.println("Exception [" + e.getMessage() + "]");
            return "failure";
        }
        return "success";
    }
}
