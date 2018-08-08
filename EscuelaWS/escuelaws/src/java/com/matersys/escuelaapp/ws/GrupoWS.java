/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.ws;

import com.matersys.escuelaapp.dao.GrupoDAO;
import com.matersys.escuelaapp.dao.imp.GrupoDAOImp;
import com.matersys.escuelaapp.dto.GrupoDTO;
import com.matersys.escuelaapp.entity.Grupo;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author eiste
 */
@WebService(serviceName = "admin/GrupoWS")
public class GrupoWS {
    private GrupoDAO gdao;

    @WebMethod(operationName = "consultarGrupos")
    public List<GrupoDTO> consultarGrupos(@WebParam(name = "cveEscuela") String cve) {
        gdao = new GrupoDAOImp();
        List<Grupo> grupos = gdao.consultarGrupos(cve);
        List<GrupoDTO> gruposDTO = assemblerGruposDTO(grupos);
        return gruposDTO;
    }
    
    private List<GrupoDTO> assemblerGruposDTO(List<Grupo> grupos){
        List<GrupoDTO> grupoDTOs = new ArrayList<>();
        for(Grupo g: grupos){
            GrupoDTO gdto = new GrupoDTO();
            gdto.setEscuela(g.getGrupoPK().getEscuela());
            gdto.setNivel(g.getGrupoPK().getNivel());
            gdto.setGrado(g.getGrupoPK().getGrado());
            gdto.setGrupo(g.getGrupoPK().getGrupo());
            grupoDTOs.add(gdto);
        }
        return grupoDTOs;
    }
}
