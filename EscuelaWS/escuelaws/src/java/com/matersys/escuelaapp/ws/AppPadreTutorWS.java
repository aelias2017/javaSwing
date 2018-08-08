/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.ws;

import com.matersys.escuelaapp.dao.CalificacionesDAO;
import com.matersys.escuelaapp.dao.imp.CalificacionesDAOImp;
import com.matersys.escuelaapp.dto.AlumnoDTO;
import com.matersys.escuelaapp.dto.CalificacionesDTO;
import com.matersys.escuelaapp.dto.CredencialesDTO;
import com.matersys.escuelaapp.entity.Alumno;
import com.matersys.escuelaapp.entity.Calificaciones;
import com.matersys.escuelaapp.entity.Usuario;
import com.matersys.escuelaapp.util.EscuelaAppUtil;
import com.matersys.escuelaapp.util.EstatusAlumno;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author eiste
 */
@WebService(serviceName = "padre/AppPadreTutorWS")
public class AppPadreTutorWS {

    private CalificacionesDAO cdao;

    @WebMethod(operationName = "consultarHijosInscritos")
    public List<AlumnoDTO> consultarHijosInscritos(@WebParam(name = "credenciales") CredencialesDTO cdto) throws Exception {
        Usuario padre = EscuelaAppUtil.validarAcceso(cdto, this.getClass());
        return assemblerAlumnoDTOList(padre.getPadretutor().getAlumnoList());
    }

    @WebMethod(operationName = "consultarBoleta")
    public List<CalificacionesDTO> consultarBoleta(@WebParam(name = "credenciales") CredencialesDTO cdto,
            @WebParam(name = "curp") String curp) throws Exception {
        Usuario padre = EscuelaAppUtil.validarAcceso(cdto, this.getClass());
        Alumno alumno = new Alumno();
        for (Alumno a : padre.getPadretutor().getAlumnoList()) {
            if (a.getEstatusalum().equals(EstatusAlumno.INSCRITO)
                    && a.getCurp().equals(curp)) {
                alumno = a;
            }
        }
        cdao = new CalificacionesDAOImp();
        return assembrerCalificacionesDTOList(cdao.consultarCalificacionesAlumno(alumno.getNumalumno()));
    }

    private List<CalificacionesDTO> assembrerCalificacionesDTOList(List<Calificaciones> calificaciones) {
        List<CalificacionesDTO> calificacionesDTO = new ArrayList<>();
        for (Calificaciones c : calificaciones) {
            if (c.getCalificacionesPK().getCiclo().equals(EscuelaAppUtil.obtenerCicloEscolar())) {
                CalificacionesDTO dto = new CalificacionesDTO();
                dto.setNumalumno(c.getAlumno().getNumalumno());
                dto.setIdasignatura(c.getCalificacionesPK().getIdasignatura());
                dto.setCiclo(c.getCalificacionesPK().getCiclo());
                dto.setPeriodo(c.getCalificacionesPK().getPeriodo());
                dto.setCalificacion(c.getCalificacion());
                calificacionesDTO.add(dto);
            }
        }
        return calificacionesDTO;
    }

    private List<AlumnoDTO> assemblerAlumnoDTOList(List<Alumno> alumnos) {
        List<AlumnoDTO> alumnosDTO = new ArrayList<>();
        for (Alumno a : alumnos) {
            if (a.getEstatusalum().equals(EstatusAlumno.INSCRITO)) {
                AlumnoDTO adto = new AlumnoDTO();
                adto.setApellido1(a.getApellido1());
                adto.setApellido2(a.getApellido2());
                adto.setCurp(a.getCurp());
                adto.setEscuela(a.getGrupo().getGrupoPK().getEscuela());
                adto.setFechanac(a.getFechanac());
                adto.setGrado(a.getGrupo().getGrupoPK().getGrado());
                adto.setGrupo(a.getGrupo().getGrupoPK().getGrupo());
                adto.setMatricula(a.getMatricula());
                adto.setNivel(a.getGrupo().getGrupoPK().getNivel());
                adto.setNombre(a.getNombre());
                adto.setNumalumno(a.getNumalumno());
                adto.setParentutor(a.getParentutor());
                adto.setNumhnos(a.getNumhnos());
                adto.setPoshnos(a.getPoshnos());
                alumnosDTO.add(adto);
            }
        }
        return alumnosDTO;
    }
}
