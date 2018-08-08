/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.ws;

import com.matersys.escuelaapp.dao.GrupoDAO;
import com.matersys.escuelaapp.dao.imp.GrupoDAOImp;
import com.matersys.escuelaapp.dto.AsignacionesProfesDTO;
import com.matersys.escuelaapp.dto.CicloEscolarDTO;
import com.matersys.escuelaapp.entity.Grupo;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author eiste
 */
@WebService(serviceName = "admin/CicloEscolarWS")
public class CicloEscolarWS {

    private AsignacionesProfesWS apws;
    private GrupoDAO gdao;

    @WebMethod(operationName = "registrarAsignaturaGradoCicloEscolar")
    public String registrarAsignaturaGradoCicloEscolar(@WebParam(name = "asignatura") CicloEscolarDTO dto) {
        gdao = new GrupoDAOImp();
        List<Grupo> grupos = gdao.consultarGrupos(dto.getEscuela());
        apws = new AsignacionesProfesWS();
        for (Grupo g : grupos) {
            if (g.getGrupoPK().getGrado().equals(dto.getGrado())) {
                AsignacionesProfesDTO asignacion = new AsignacionesProfesDTO();
                asignacion.setIdasignatura(dto.getIdasignatura());
                asignacion.setEscuela(dto.getEscuela());
                asignacion.setNivel(dto.getNivel());
                asignacion.setGrado(dto.getGrado());
                asignacion.setGrupo(g.getGrupoPK().getGrupo());
                apws.agregarAsignacion(asignacion);
            }
        }
        return "success";
    }
}
