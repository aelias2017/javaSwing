/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.ws;

import com.matersys.escuelaapp.dao.ProfesorDAO;
import com.matersys.escuelaapp.dao.UsuarioDAO;
import com.matersys.escuelaapp.dao.imp.ProfesorDAOImp;
import com.matersys.escuelaapp.dao.imp.UsuarioDAOImp;
import com.matersys.escuelaapp.dto.ProfesorDTO;
import com.matersys.escuelaapp.entity.Profesor;
import com.matersys.escuelaapp.entity.Usuario;
import com.matersys.escuelaapp.util.TipoUsuario;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author eiste
 */
@WebService(serviceName = "admin/ProfesorWS")
public class ProfesorWS {
    private ProfesorDAO pdao;
    private UsuarioDAO udao;

    @WebMethod(operationName = "registrarProfesor")
    public String registrarProfesor(@WebParam(name = "profesor") ProfesorDTO dto) {
        udao = new UsuarioDAOImp();
        Usuario usuario = udao.consultarUsuario(dto.getIdusuario());
        if(usuario==null || !usuario.getTipo().equals(TipoUsuario.PROFESOR)){
            return "nouser";
        }
        Profesor profesor = assemblerProfesor(dto);
        profesor.setIdusuario(usuario);
        try{
            pdao = new ProfesorDAOImp();
            pdao.insertarProfesor(profesor);
        }catch (Exception e) {
            System.out.println("Exception ["+e.getMessage()+"]");
            return "failure";
        }
        return "success";
    }
    
    private Profesor assemblerProfesor(ProfesorDTO dto){
        Profesor profesor = new Profesor();
        profesor.setIdprofesor(dto.getIdprofesor());
        profesor.setNombre(dto.getNombre());
        profesor.setNivelestudios(dto.getNivelestudios());
        profesor.setEmail(dto.getEmail());
        profesor.setCelular(dto.getCelular());
        return profesor;
    }
}
