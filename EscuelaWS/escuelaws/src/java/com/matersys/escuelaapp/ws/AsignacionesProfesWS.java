/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.ws;

import com.matersys.escuelaapp.dao.AsignacionesProfesoresDAO;
import com.matersys.escuelaapp.dao.AsignaturaDAO;
import com.matersys.escuelaapp.dao.GrupoDAO;
import com.matersys.escuelaapp.dao.ProfesorDAO;
import com.matersys.escuelaapp.dao.imp.AsignacionesProfesoresDAOImp;
import com.matersys.escuelaapp.dao.imp.AsignaturaDAOImp;
import com.matersys.escuelaapp.dao.imp.GrupoDAOImp;
import com.matersys.escuelaapp.dao.imp.ProfesorDAOImp;
import com.matersys.escuelaapp.dto.AsignacionesProfesDTO;
import com.matersys.escuelaapp.entity.Asignacionesprofes;
import com.matersys.escuelaapp.entity.AsignacionesprofesPK;
import com.matersys.escuelaapp.entity.Asignatura;
import com.matersys.escuelaapp.entity.Grupo;
import com.matersys.escuelaapp.entity.Profesor;
import com.matersys.escuelaapp.util.EscuelaAppUtil;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author eiste
 */
@WebService(serviceName = "admin/AsignacionesProfesWS")
public class AsignacionesProfesWS {
    private ProfesorDAO pdao;
    private AsignaturaDAO adao;
    private GrupoDAO gdao;
    private AsignacionesProfesoresDAO apdao;
    
    @WebMethod(operationName = "agregarAsignacion")
    public String agregarAsignacion(@WebParam(name = "asignacion") AsignacionesProfesDTO dto) {
        adao = new AsignaturaDAOImp();
        Asignatura asignatura = adao.consultarAsignatura(dto.getIdasignatura());
        pdao = new ProfesorDAOImp();
        Profesor profesor = pdao.consultarProfesor(dto.getIdprofesor());
        gdao = new GrupoDAOImp();
        Grupo grupo = gdao.consultarGrupo(dto.getEscuela(),
                dto.getNivel(), dto.getGrado(), dto.getGrupo());
        Asignacionesprofes asignacion = new Asignacionesprofes();
        AsignacionesprofesPK apk = new AsignacionesprofesPK();
        apk.setIdasignatura(dto.getIdasignatura());
        apk.setEscuela(dto.getEscuela());
        apk.setNivel(dto.getNivel());
        apk.setGrado(dto.getGrado());
        apk.setGrupo(dto.getGrupo());
        apk.setCicloesc(EscuelaAppUtil.obtenerCicloEscolar());
        asignacion.setAsignacionesprofesPK(apk);
        asignacion.setAsignatura(asignatura);
        asignacion.setGrupo1(grupo);
        asignacion.setIdprofesor(profesor);
        apdao = new AsignacionesProfesoresDAOImp();
        Asignacionesprofes asignacion_ = apdao.consultarAsignacion(dto);
        if(asignacion_==null){
            apdao.insertarAsignacionProfesor(asignacion);
        } else {
            asignacion_.setIdprofesor(profesor);
            apdao.acualizarAsignacionesProfesor(asignacion_);
        }       
        return "success";
    }
    
    @WebMethod(operationName = "asignarProfesorTitularGrupo")
    public String asignarProfesorTitularGrupo(@WebParam(name = "asignatura") AsignacionesProfesDTO dto) {
        pdao = new ProfesorDAOImp();
        gdao = new GrupoDAOImp();
        apdao = new AsignacionesProfesoresDAOImp();
        Profesor profesor = pdao.consultarProfesor(dto.getIdprofesor());
        Grupo grupo = gdao.consultarGrupo(dto.getEscuela(),
                dto.getNivel(), dto.getGrado(), dto.getGrupo());
        
        if(grupo.getAsignacionesprofesList()==null || grupo.getAsignacionesprofesList().size()<1){
            return "failure";
        }
        
        for(Asignacionesprofes ap: grupo.getAsignacionesprofesList()){
            if(ap.getIdprofesor()==null){
                ap.setIdprofesor(profesor);
                apdao.acualizarAsignacionesProfesor(ap);
            }
        }
        return "success";
    }
}
