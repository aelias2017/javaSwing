/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.ws;

import com.matersys.escuelaapp.dao.AlumnoDAO;
import com.matersys.escuelaapp.dao.AsignaturaDAO;
import com.matersys.escuelaapp.dao.CalificacionesDAO;
import com.matersys.escuelaapp.dao.GrupoDAO;
import com.matersys.escuelaapp.dao.imp.AlumnoDAOImp;
import com.matersys.escuelaapp.dao.imp.AsignaturaDAOImp;
import com.matersys.escuelaapp.dao.imp.CalificacionesDAOImp;
import com.matersys.escuelaapp.dao.imp.GrupoDAOImp;
import com.matersys.escuelaapp.dto.ActaPeriodoDTO;
import com.matersys.escuelaapp.dto.AlumnoDTO;
import com.matersys.escuelaapp.dto.AsignacionesProfesDTO;
import com.matersys.escuelaapp.dto.CalificacionesActaDTO;
import com.matersys.escuelaapp.dto.RelacionDTO;
import com.matersys.escuelaapp.dto.CredencialesDTO;
import com.matersys.escuelaapp.entity.Alumno;
import com.matersys.escuelaapp.entity.Asignacionesprofes;
import com.matersys.escuelaapp.entity.Calificaciones;
import com.matersys.escuelaapp.entity.CalificacionesPK;
import com.matersys.escuelaapp.entity.Grupo;
import com.matersys.escuelaapp.entity.Usuario;
import com.matersys.escuelaapp.exeption.InvalidPermException;
import com.matersys.escuelaapp.util.EscuelaAppUtil;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author eiste
 */
@WebService(serviceName = "profesor/AppProfesorWS")
public class AppProfesorWS {

    private GrupoDAO gdao;
    private AsignaturaDAO asdao;
    private AlumnoDAO adao;
    private CalificacionesDAO cdao;

    @WebMethod(operationName = "materiasAsignadas")
    public List<AsignacionesProfesDTO> materiasAsignadas(@WebParam(name = "credenciales") CredencialesDTO dto) throws Exception {
        Usuario usuario = EscuelaAppUtil.validarAcceso(dto, this.getClass());
        List<Asignacionesprofes> materias = usuario.getProfesor().getAsignacionesprofesList();
        return assemblerAsignacionesProfesListDTO(materias);
    }

    @WebMethod(operationName = "relacionAsignatura")
    public RelacionDTO relacionAsignatura(@WebParam(name = "credenciales") CredencialesDTO dto,
            @WebParam(name = "idasignatura") int idasignatura) throws Exception {
        Usuario usuario = EscuelaAppUtil.validarAcceso(dto, this.getClass());
        List<AsignacionesProfesDTO> materias
                = assemblerAsignacionesProfesListDTO(usuario.getProfesor().getAsignacionesprofesList());
        AsignacionesProfesDTO asignacion = null;
        for (AsignacionesProfesDTO apdto : materias) {
            if (apdto.getIdasignatura() == idasignatura) {
                asignacion = apdto;
                break;
            }
        }
        if (asignacion == null) {
            return null;
        }
        gdao = new GrupoDAOImp();
        Grupo grupo = gdao.consultarGrupo(asignacion.getEscuela(), asignacion.getNivel(),
                asignacion.getGrado(), asignacion.getGrupo());
        List<Alumno> alumnos = grupo.getAlumnoList();
        RelacionDTO rdto = new RelacionDTO();
        rdto.setAsignacion(asignacion);
        rdto.setAlumno(assemblesAlumnoListDTO(alumnos));
        return rdto;
    }

    @WebMethod(operationName = "evaluarPeriodoAsignatura")
    public String evaluarPeriodoAsignatura(@WebParam(name = "acta") ActaPeriodoDTO dto) throws Exception {
        Usuario usuario = EscuelaAppUtil.validarAcceso(dto.getAsignacion().getCdto(), this.getClass());
        boolean valida = false;
        for (Asignacionesprofes a : usuario.getProfesor().getAsignacionesprofesList()) {
            if (a.getAsignacionesprofesPK().getIdasignatura() == dto.getAsignacion().getIdasignatura()
                    && a.getAsignacionesprofesPK().getEscuela().equals(dto.getAsignacion().getEscuela())
                    && a.getAsignacionesprofesPK().getNivel().equals(dto.getAsignacion().getNivel())
                    && a.getAsignacionesprofesPK().getGrado().equals(dto.getAsignacion().getGrado())
                    && a.getAsignacionesprofesPK().getGrupo().equals(dto.getAsignacion().getGrupo())
                    && a.getAsignacionesprofesPK().getCicloesc().equals(EscuelaAppUtil.obtenerCicloEscolar())) {
                valida = true;
                break;
            }
        }
        if (!valida) {
            throw new InvalidPermException("Permiso denegado");
        }
        cdao = new CalificacionesDAOImp();
        for (Calificaciones c : assemblerCalificacionesList(dto)) {
            cdao.insertarCalidacion(c);
        }
        return "success";
    }

    @WebMethod(operationName = "cambiarCalificacion")
    public String cambiarCalificacion(@WebParam(name = "acta") ActaPeriodoDTO dto) throws Exception {
        Usuario usuario = EscuelaAppUtil.validarAcceso(dto.getAsignacion().getCdto(), this.getClass());
        boolean valida = false;
        for (Asignacionesprofes a : usuario.getProfesor().getAsignacionesprofesList()) {
            if (a.getAsignacionesprofesPK().getIdasignatura() == dto.getAsignacion().getIdasignatura()
                    && a.getAsignacionesprofesPK().getEscuela().equals(dto.getAsignacion().getEscuela())
                    && a.getAsignacionesprofesPK().getNivel().equals(dto.getAsignacion().getNivel())
                    && a.getAsignacionesprofesPK().getGrado().equals(dto.getAsignacion().getGrado())
                    && a.getAsignacionesprofesPK().getGrupo().equals(dto.getAsignacion().getGrupo())
                    && a.getAsignacionesprofesPK().getCicloesc().equals(EscuelaAppUtil.obtenerCicloEscolar())) {
                valida = true;
                break;
            }
        }
        if (!valida) {
            throw new InvalidPermException("Permiso denegado");
        }
        cdao = new CalificacionesDAOImp();
        Calificaciones c = assemblerCalificacionesList(dto).get(0);
        cdao.actualizarCalificacion(c);
        return "success";
    }

    private List<AsignacionesProfesDTO> assemblerAsignacionesProfesListDTO(List<Asignacionesprofes> materias) {
        List<AsignacionesProfesDTO> materiasDTO = new ArrayList<>();
        for (Asignacionesprofes ap : materias) {
            if (ap.getAsignacionesprofesPK().getCicloesc().endsWith(EscuelaAppUtil.obtenerCicloEscolar())) {
                AsignacionesProfesDTO dto = new AsignacionesProfesDTO();
                dto.setIdasignatura(ap.getAsignacionesprofesPK().getIdasignatura());
                dto.setEscuela(ap.getAsignacionesprofesPK().getEscuela());
                dto.setNivel(ap.getAsignacionesprofesPK().getNivel());
                dto.setGrado(ap.getAsignacionesprofesPK().getGrado());
                dto.setGrupo(ap.getAsignacionesprofesPK().getGrupo());
                dto.setIdprofesor(ap.getIdprofesor().getIdprofesor());
                materiasDTO.add(dto);
            }
        }
        return materiasDTO;
    }

    private List<AlumnoDTO> assemblesAlumnoListDTO(List<Alumno> alumnos) {
        List<AlumnoDTO> alumnosDTO = new ArrayList<>();
        for (Alumno a : alumnos) {
            AlumnoDTO adto = new AlumnoDTO();
            adto.setCurp(a.getCurp());
            adto.setApellido1(a.getApellido1());
            adto.setApellido2(a.getApellido2());
            adto.setNombre(a.getNombre());
            adto.setEscuela(a.getGrupo().getGrupoPK().getEscuela());
            adto.setNivel(a.getGrupo().getGrupoPK().getNivel());
            adto.setGrado(a.getGrupo().getGrupoPK().getGrado());
            adto.setGrupo(a.getGrupo().getGrupoPK().getGrupo());
            adto.setEstatusalum(a.getEstatusalum());
            adto.setMatricula(a.getMatricula());
            adto.setFechanac(a.getFechanac());
            adto.setIdpadretutor(a.getIdpadretutor().getIdusuario());
            adto.setParentutor(a.getParentutor());
            adto.setNumhnos(a.getNumhnos());
            adto.setNumalumno(a.getNumalumno());
            adto.setPoshnos(a.getPoshnos());
            alumnosDTO.add(adto);
        }
        return alumnosDTO;
    }

    private List<Calificaciones> assemblerCalificacionesList(ActaPeriodoDTO acta) {
        List<Calificaciones> calificaciones = new ArrayList<>();
        for (CalificacionesActaDTO c : acta.getAlumno()) {
            CalificacionesPK pk = new CalificacionesPK();
            pk.setIdasignatura(acta.getAsignacion().getIdasignatura());
            pk.setNumalumno(c.getNumalumno());
            pk.setCiclo(EscuelaAppUtil.obtenerCicloEscolar());
            pk.setPeriodo(acta.getPeriodo());
            Calificaciones calificacion = new Calificaciones();
            calificacion.setCalificacionesPK(pk);
            calificacion.setCalificacion(c.getCalificacion());
            adao = new AlumnoDAOImp();
            calificacion.setAlumno(adao.consultarAlumnoById(c.getNumalumno()));
            asdao = new AsignaturaDAOImp();
            calificacion.setAsignatura(asdao.consultarAsignatura(acta.getAsignacion().getIdasignatura()));
            calificaciones.add(calificacion);
        }
        return calificaciones;
    }
}
