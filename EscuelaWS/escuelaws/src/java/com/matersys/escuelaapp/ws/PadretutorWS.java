/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.ws;

import com.matersys.escuelaapp.dao.PadretutorDAO;
import com.matersys.escuelaapp.dao.UsuarioDAO;
import com.matersys.escuelaapp.dao.imp.PadretutorDAOImp;
import com.matersys.escuelaapp.dao.imp.UsuarioDAOImp;
import com.matersys.escuelaapp.dto.PadretutorDTO;
import com.matersys.escuelaapp.entity.Padretutor;
import com.matersys.escuelaapp.entity.Usuario;
import com.matersys.escuelaapp.util.TipoUsuario;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author eiste
 */
@WebService(serviceName = "admin/PadretutorWS")
public class PadretutorWS {

    private UsuarioDAO udao;
    private PadretutorDAO pdao;

    /**
     * This is a sample web service operation
     *
     * @param dto
     * @return
     */
    @WebMethod(operationName = "registrar")
    public String registrar(@WebParam(name = "padre") PadretutorDTO dto) {
        udao = new UsuarioDAOImp();
        Usuario usuario = udao.consultarUsuario(dto.getIdusuario());
        if (usuario == null || !usuario.getTipo().equals(TipoUsuario.PADRE)) {
            return "nouser";
        }
        Padretutor padre = assemblerPadretutor(dto);
        padre.setUsuario(usuario);
        try {
            pdao = new PadretutorDAOImp();
            pdao.insertarPadretutor(padre);
        } catch (Exception e) {
            System.out.println("Exception ["+e.getMessage()+"]");
            return "failure";
        }
        return "success";
    }
    
    private Padretutor assemblerPadretutor(PadretutorDTO dto){
        Padretutor padre = new Padretutor();
        padre.setIdusuario(dto.getIdusuario());
        padre.setNombre(dto.getNombre());
        padre.setEscolaridad(dto.getEscolaridad());
        padre.setOcupacion(dto.getOcupacion());
        padre.setEstadocivil(dto.getEstadocivil());
        padre.setEmail(dto.getEmail());
        padre.setCelular(dto.getCelular());
        padre.setCelAlt1(dto.getCelAlt1());
        padre.setCelAlt2(dto.getCelAlt2());
        padre.setTelCasa(dto.getTelCasa());
        padre.setTelOfi(dto.getTelOfi());
        return padre;
    }
}
