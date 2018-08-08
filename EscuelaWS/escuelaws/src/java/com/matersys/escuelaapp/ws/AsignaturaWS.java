/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.ws;

import com.matersys.escuelaapp.dao.AsignaturaDAO;
import com.matersys.escuelaapp.dao.imp.AsignaturaDAOImp;
import com.matersys.escuelaapp.dto.AsignaturaDTO;
import com.matersys.escuelaapp.entity.Asignatura;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author eiste
 */
@WebService(serviceName = "admin/AsignaturaWS")
public class AsignaturaWS {
    AsignaturaDAO adao;

    @WebMethod(operationName = "consultarAsignaturas")
    public List<AsignaturaDTO> consultarAsignaturas(@WebParam(name = "nivel") String nivel,
            @WebParam(name = "grado") String grado) {
        adao = new AsignaturaDAOImp();
        List<Asignatura> asignaturas = adao.consultarAsignaturasGrado(nivel, grado);
        return assemblerAsignaturasDTO(asignaturas);
    }
    
    @WebMethod(operationName = "agregarAsignatura")
    public String agregarAsignatura(@WebParam(name = "asignatura") AsignaturaDTO dto){ 
        adao = new AsignaturaDAOImp();
        Asignatura asignatura = assemblerAsignatura(dto);
        adao.insertarAsignatura(asignatura);
        return "success";
    }
    
    @WebMethod(operationName = "actualizarAsignatura")
    public String actualizarAsignatura(@WebParam(name = "asignatura") AsignaturaDTO dto){ 
        adao = new AsignaturaDAOImp();
        Asignatura asignatura = adao.consultarAsignatura(dto.getIdasignatura());
        asignatura = assemblerAsignatura(asignatura, dto);
        adao.actualizarAsignatura(asignatura);
        return "success";
    }
    
    private List<AsignaturaDTO> assemblerAsignaturasDTO(List<Asignatura> asignaturas){
        List<AsignaturaDTO> asignaturaDTOs = new ArrayList<>();
        for(Asignatura a: asignaturas){
            AsignaturaDTO adto = new AsignaturaDTO();
            adto.setIdasignatura(a.getIdasignatura());
            adto.setClave(a.getClave());
            adto.setNombre(a.getNombre());
            adto.setNivel(a.getNivel());
            adto.setGrado(a.getGrado());
            asignaturaDTOs.add(adto);
        }
        return asignaturaDTOs;
    }
    
    private Asignatura assemblerAsignatura(AsignaturaDTO dto){
        Asignatura asignatura = new Asignatura();
        asignatura.setClave(dto.getClave());
        asignatura.setNombre(dto.getNombre());
        asignatura.setNivel(dto.getNivel());
        asignatura.setGrado(dto.getGrado());
        return asignatura;
    }
    
    private Asignatura assemblerAsignatura(Asignatura asignatura, AsignaturaDTO dto){
        asignatura.setClave(dto.getClave());
        asignatura.setNombre(dto.getNombre());
        asignatura.setNivel(dto.getNivel());
        asignatura.setGrado(dto.getGrado());
        return asignatura;
    }
}
