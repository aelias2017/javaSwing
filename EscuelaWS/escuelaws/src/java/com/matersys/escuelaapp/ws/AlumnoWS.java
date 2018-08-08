/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.ws;

import com.matersys.escuelaapp.dao.AlumnoDAO;
import com.matersys.escuelaapp.dao.GrupoDAO;
import com.matersys.escuelaapp.dao.PadretutorDAO;
import com.matersys.escuelaapp.dao.imp.AlumnoDAOImp;
import com.matersys.escuelaapp.dao.imp.GrupoDAOImp;
import com.matersys.escuelaapp.dao.imp.PadretutorDAOImp;
import com.matersys.escuelaapp.dto.AlumnoDTO;
import com.matersys.escuelaapp.dto.CredencialesDTO;
import com.matersys.escuelaapp.dto.GrupoDTO;
import com.matersys.escuelaapp.dto.alumno.ActualizarCurpAlumnoDTO;
import com.matersys.escuelaapp.dto.alumno.ActualizarDatosAlumnoDTO;
import com.matersys.escuelaapp.dto.alumno.ActualizarMatriculaAlumnoDTO;
import com.matersys.escuelaapp.dto.alumno.CambiarGrupoAlumnoDTO;
import com.matersys.escuelaapp.dto.alumno.CambiarPadreAlumnoDTO;
import com.matersys.escuelaapp.entity.Alumno;
import com.matersys.escuelaapp.entity.Grupo;
import com.matersys.escuelaapp.entity.Padretutor;
import com.matersys.escuelaapp.util.EscuelaAppUtil;
import com.matersys.escuelaapp.util.EstatusAlumno;
import com.matersys.escuelaapp.util.EstatusUsuario;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author eiste
 */
@WebService(serviceName = "admin/AlumnoWS")
public class AlumnoWS {

    private AlumnoDAO adao;
    private PadretutorDAO pdao;
    private GrupoDAO gdao;

    @WebMethod(operationName = "inscribir")
    public String inscribir(@WebParam(name = "alumno") AlumnoDTO dto) throws Exception {
        EscuelaAppUtil.validarAcceso(dto.getCdto(), this.getClass());
        adao = new AlumnoDAOImp();
        if(adao.consultarAlumno(dto.getCurp())!=null){
            return "curpexistente";
        }
        Alumno alumno = assemblerAlumno(dto);
        pdao = new PadretutorDAOImp();
        Padretutor padre = pdao.consultarPadretutor(dto.getIdpadretutor());
        alumno.setIdpadretutor(padre);
        gdao = new GrupoDAOImp();
        Grupo grupo = gdao.consultarGrupo(dto.getEscuela(),
                dto.getNivel(), dto.getGrado(), dto.getGrupo());
        alumno.setGrupo(grupo);
        adao.insertarAlumno(alumno);
        return "success";
    }

    @WebMethod(operationName = "reinscribir")
    public String reinscribir(@WebParam(name = "curp") String curp, @WebParam(name = "grupo") GrupoDTO dto) throws Exception {
        EscuelaAppUtil.validarAcceso(dto.getCdto(), this.getClass());
        adao = new AlumnoDAOImp();
        Alumno alumno = adao.consultarAlumno(curp);
        switch (alumno.getEstatusalum()) {
            case EstatusAlumno.ACREDITADO:
                int nivel1 = Integer.parseInt(alumno.getGrupo().getGrupoPK().getNivel());
                int nivel2 = Integer.parseInt(dto.getNivel());
                int grado1 = Integer.parseInt(alumno.getGrupo().getGrupoPK().getGrado());
                int grado2 = Integer.parseInt(dto.getGrado());
                if (nivel1 == 1 && grado1 == 3) {
                    if (nivel2 == 2 && grado2 == 1) {
                        break;
                    } else {
                        return "errorgrado";
                    }
                } else if (nivel1 != nivel2 || grado2 != grado1 + 1) {
                    return "errorgrado";
                }
                break;
            case EstatusAlumno.NOACREDITADO:
                if (!alumno.getGrupo().getGrupoPK().getGrado().equals(dto.getGrado())) {
                    return "noacreditado";
                }
                break;
            case EstatusAlumno.EGRESADO:
                return "egresado";
            case EstatusAlumno.INSCRITO:
                return "inscrito";
            default:
                break;

        }
        gdao = new GrupoDAOImp();
        Grupo grupo = gdao.consultarGrupo(alumno.getGrupo().getGrupoPK().getEscuela(),
                dto.getNivel(), dto.getGrado(), dto.getGrupo());
        grupo.getGrupoPK().setNivel(dto.getNivel());
        grupo.getGrupoPK().setGrado(dto.getGrado());
        grupo.getGrupoPK().setGrupo(dto.getGrupo());
        alumno.setGrupo(grupo);
        alumno.setEstatusalum(EstatusAlumno.INSCRITO);
        adao.actualizarAlumno(alumno);
        return "success";
    }

     @WebMethod(operationName = "bajaTemporal")
    public String bajaTemporal(@WebParam(name = "cdto") CredencialesDTO cdto,
            @WebParam(name = "curp") String curp) throws Exception {
        EscuelaAppUtil.validarAcceso(cdto, this.getClass());
        adao = new AlumnoDAOImp();
        Alumno alumno = adao.consultarAlumno(curp);
        if (!alumno.getEstatusalum().equals(EstatusAlumno.INSCRITO)) {
            return "errorbajatemporal";
        }
        alumno.setEstatusalum(EstatusAlumno.BAJA_TEMPORAL);
        adao.actualizarAlumno(alumno);
        return "success";
    }

    @WebMethod(operationName = "bajaDefinitiva")
    public String bajaDefinitiva(@WebParam(name = "cdto") CredencialesDTO cdto, 
            @WebParam(name = "curp") String curp) throws Exception {
        EscuelaAppUtil.validarAcceso(cdto, this.getClass());
        adao = new AlumnoDAOImp();
        Alumno alumno = adao.consultarAlumno(curp);
        switch (alumno.getEstatusalum()) {
            case EstatusAlumno.BAJA:
            case EstatusAlumno.EGRESADO:
                return "errorbajadefinitiva";
        }

        alumno.setEstatusalum(EstatusAlumno.BAJA);
        adao.actualizarAlumno(alumno);
        EscuelaAppUtil.actualizarPadreTutor(alumno.getIdpadretutor().getIdusuario());
        return "success";
    }

    @WebMethod(operationName = "cambiarGrupo")
    public String cambiarGrupo(@WebParam(name = "alumno") CambiarGrupoAlumnoDTO dto) throws Exception {
        EscuelaAppUtil.validarAcceso(dto.getCdto(), this.getClass());
        adao = new AlumnoDAOImp();
        Alumno alumno = adao.consultarAlumno(dto.getCurpAlumno());
        if (alumno==null || !alumno.getEstatusalum().equals(EstatusAlumno.INSCRITO)) {
            return "noinscrito";
        }
        gdao = new GrupoDAOImp();
        Grupo grupo = gdao.consultarGrupo(alumno.getGrupo().getGrupoPK().getEscuela(),
                alumno.getGrupo().getGrupoPK().getNivel(),
                alumno.getGrupo().getGrupoPK().getGrado(),
                alumno.getGrupo().getGrupoPK().getGrupo());
        grupo.getGrupoPK().setGrupo(dto.getGrupo());
        alumno.setGrupo(grupo);
        adao.actualizarAlumno(alumno);
        return "success";
    }

    @WebMethod(operationName = "actualizarDatos")
    public String actualizarDatos(@WebParam(name = "alumno") ActualizarDatosAlumnoDTO dto) throws Exception {
        EscuelaAppUtil.validarAcceso(dto.getCdto(), this.getClass());
        adao = new AlumnoDAOImp();
        Alumno alumno = adao.consultarAlumno(dto.getCurpAlumno());
        alumno.setNombre(dto.getNombre());
        alumno.setApellido1(dto.getApellido1());
        alumno.setApellido2(dto.getApellido2());
        alumno.setNumhnos(dto.getNumhnos());
        adao.actualizarAlumno(alumno);
        return "success";
    }

    @WebMethod(operationName = "actualizarMatricula")
    public String actualizarMatricula(@WebParam(name = "alumno") ActualizarMatriculaAlumnoDTO dto) throws Exception {
        EscuelaAppUtil.validarAcceso(dto.getCdto(), this.getClass());
        adao = new AlumnoDAOImp();
        Alumno alumno = adao.consultarAlumno(dto.getCurpAlumno());
        alumno.setMatricula(dto.getMatricula());
        adao.actualizarAlumno(alumno);
        return "success";
    }

    @WebMethod(operationName = "actualizarCurp")
    public String actualizarCurp(@WebParam(name = "alumno") ActualizarCurpAlumnoDTO dto) throws Exception {
        EscuelaAppUtil.validarAcceso(dto.getCdto(), this.getClass());
        adao = new AlumnoDAOImp();
        Alumno alumno = adao.consultarAlumno(dto.getCurpAlumno());
        alumno.setCurp(dto.getNuevoCurpAlumno());
        adao.actualizarAlumno(alumno);
        return "success";
    }

    @WebMethod(operationName = "cambiarPadreTutor")
    public String cambiarPadreTutor(@WebParam(name = "alumno") CambiarPadreAlumnoDTO dto) throws Exception {
        EscuelaAppUtil.validarAcceso(dto.getCdto(), this.getClass());
        adao = new AlumnoDAOImp();
        Alumno alumno = adao.consultarAlumno(dto.getCurpAlumno());
        pdao = new PadretutorDAOImp();
        Padretutor padre = pdao.consultarPadretutor(dto.getIdpadretutor());
        alumno.setParentutor(dto.getParentutor());
        String padreanterior = alumno.getIdpadretutor().getIdusuario();
        alumno.setIdpadretutor(padre);
        adao.actualizarAlumno(alumno);
        padre = pdao.consultarPadretutor(padreanterior);
        boolean inscritos = false;
        for (Alumno a : padre.getAlumnoList()) {
            if (a.getEstatusalum().equals(EstatusAlumno.INSCRITO)) {
                inscritos = true;
                break;
            }
        }
        if (inscritos == false) {
            padre.getUsuario().setEstatus(EstatusUsuario.INACTIVO);
            pdao.actualizarPadretutor(padre);
        }
        return "success";
    }
    
    private Alumno assemblerAlumno(AlumnoDTO dto){
        Alumno alumno = new Alumno();
        alumno.setMatricula(dto.getMatricula());
        alumno.setCurp(dto.getCurp());
        alumno.setNombre(dto.getNombre());
        alumno.setApellido1(dto.getApellido1());
        alumno.setApellido2(dto.getApellido2());
        alumno.setFechanac(dto.getFechanac());
        alumno.setNumhnos(dto.getNumhnos());
        alumno.setPoshnos(dto.getPoshnos());
        alumno.setParentutor(dto.getParentutor());
        alumno.setEstatusalum(EstatusAlumno.INSCRITO);
        return alumno;
    }
}
