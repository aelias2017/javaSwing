/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.ws;

import com.matersys.escuelaapp.assambler.UsuarioAssembler;
import com.matersys.escuelaapp.dao.UsuarioDAO;
import com.matersys.escuelaapp.dao.imp.UsuarioDAOImp;
import com.matersys.escuelaapp.dto.UsuarioDTO;
import com.matersys.escuelaapp.entity.Usuario;
import com.matersys.escuelaapp.exeption.InvalidUserException;
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
@WebService(serviceName = "GeneralWS")
public class GeneralWS {
      
    private UsuarioDAO dao;

    @WebMethod(operationName = "autentica")
    public boolean autentica(@WebParam(name = "username") String username,
            @WebParam(name = "password") String password) throws InvalidUserException {
        dao = new UsuarioDAOImp();
        Usuario usuario = dao.consultarUsuario(username);
        if(usuario == null || !usuario.getEstatus().equals(EstatusUsuario.ACTIVO)){
            throw new InvalidUserException("Acceso denegado");
        }
        String passencr = EscuelaAppUtil.encripta(username, password);
        if (usuario.getPassword().equals(passencr)) {
            switch(usuario.getTipo()){
                case TipoUsuario.PADRE:
                    return EscuelaAppUtil.validarPadreTutor(usuario);
                case TipoUsuario.PROFESOR:
                    return EscuelaAppUtil.validarProfesor(usuario);
                case TipoUsuario.ADMINISTRATIVO:
                    return EscuelaAppUtil.validarAdministrativo(usuario);
                default: 
                    return false;
            }
        }
        return false;
    }

    @WebMethod(operationName = "obtenerUsuario")
    public UsuarioDTO obtenerUsuario(@WebParam(name = "username") String username,
            @WebParam(name = "password") String password) throws InvalidUserException {
        if (autentica(username, password)) {
            dao = new UsuarioDAOImp();
            Usuario usuario = dao.consultarUsuario(username);
            return UsuarioAssembler.assemblerUsuarioDTO(usuario);
        }
        throw new InvalidUserException("Acceso denegado");
    }
}
