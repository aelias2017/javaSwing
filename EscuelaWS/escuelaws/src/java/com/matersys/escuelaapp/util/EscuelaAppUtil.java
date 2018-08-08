/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.util;

import com.matersys.escuelaapp.dao.PadretutorDAO;
import com.matersys.escuelaapp.dao.UsuarioDAO;
import com.matersys.escuelaapp.dao.imp.PadretutorDAOImp;
import com.matersys.escuelaapp.dao.imp.UsuarioDAOImp;
import com.matersys.escuelaapp.dto.CredencialesDTO;
import com.matersys.escuelaapp.entity.Administrativo;
import com.matersys.escuelaapp.entity.Alumno;
import com.matersys.escuelaapp.entity.Padretutor;
import com.matersys.escuelaapp.entity.Profesor;
import com.matersys.escuelaapp.entity.Usuario;
import com.matersys.escuelaapp.exeption.InvalidPermException;
import com.matersys.escuelaapp.exeption.InvalidUserException;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author eiste
 */
public class EscuelaAppUtil {

    public static String encripta(String clave, String texto) {
        String respuesta = "";
        try {
            while (clave.length() < 16) {
                clave = clave + clave;
            }
            Key key = new SecretKeySpec(clave.toLowerCase().getBytes(), 0, 16, "AES");
            Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
            aes.init(Cipher.ENCRYPT_MODE, key);
            byte[] encriptado = aes.doFinal(texto.getBytes());

            for (byte b : encriptado) {
                respuesta = respuesta + Integer.toHexString(0xFF & b);
            }
        } catch (Exception e) {
            System.out.println("Exception [" + e.getMessage() + "]");
        }

        return respuesta;
    }

    public static String generaPassword(String base) {
        if (base != null && base.length() > 4) {
            base = base.substring(0, 4);
        }
        int random = (int) (Math.random() * 10000);
        String password = base + random;
        return password;
    }

    public static void actualizarPadreTutor(String idpdretutor) {
        PadretutorDAO pdao = new PadretutorDAOImp();
        Padretutor padre = pdao.consultarPadretutor(idpdretutor);
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
    }

    public static boolean validarPadreTutor(Usuario usuario) throws InvalidUserException {
        Padretutor padre = usuario.getPadretutor();
        if (padre == null) {
            throw new InvalidUserException("Padre no registrado");
        }
        for (Alumno a : padre.getAlumnoList()) {
            if (a.getEstatusalum().equals(EstatusAlumno.INSCRITO)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validarProfesor(Usuario usuario) throws InvalidUserException {
        Profesor profe = usuario.getProfesor();
        if (profe == null) {
            throw new InvalidUserException("Profesor no registrado");
        }
        return profe.getAsignacionesprofesList() != null
                && profe.getAsignacionesprofesList().size() > 0;
    }

    public static boolean validarAdministrativo(Usuario usuario) throws InvalidUserException {
        Administrativo admin = usuario.getAdministrativo();
        if (admin == null) {
            throw new InvalidUserException("Profesor no registrado");
        }
        return admin.getEscuela1() != null
                && admin.getEscuela1().getEstatus().equals(EstatusEscuela.ACTIVA);
    }

    public static Usuario validarAcceso(CredencialesDTO dto, Class<?> clase)
            throws InvalidUserException, InvalidPermException {
        UsuarioDAO udao = new UsuarioDAOImp();
        Usuario usuario = udao.consultarUsuario(dto.getIdusuario());
        if (usuario == null || !usuario.getEstatus().equals(EstatusUsuario.ACTIVO)) {
            throw new InvalidUserException("Acceso denegado");
        }
        String passencr = EscuelaAppUtil.encripta(dto.getIdusuario(), dto.getPassword());
        if (usuario.getPassword().equals(passencr)) {
            switch (usuario.getTipo()) {
                case TipoUsuario.PADRE:
                    if (EscuelaAppUtil.validarPadreTutor(usuario)) {
                        return validarAutorizacion(usuario, clase);
                    }
                    break;
                case TipoUsuario.PROFESOR:
                    if (EscuelaAppUtil.validarProfesor(usuario)) {
                        return validarAutorizacion(usuario, clase);
                    }
                    break;
                case TipoUsuario.ADMINISTRATIVO:
                    if (EscuelaAppUtil.validarAdministrativo(usuario)) {
                        return validarAutorizacion(usuario, clase);
                    }
                default:
                    break;
            }
        }
        throw new InvalidUserException("Acceso denegado");
    }

    private static Usuario validarAutorizacion(Usuario usuario, Class<?> clase)
            throws InvalidPermException {
        switch (clase.toString()) {
            case EscuelaAppWSClass.ALUMNOWS_CLASS:
            case EscuelaAppWSClass.ASIGNACIONESPROFESWS_CLASS:
            case EscuelaAppWSClass.ASIGNATURAWS_CLASS:
            case EscuelaAppWSClass.CICLOESCOLARWS_CLASS:
            case EscuelaAppWSClass.USUARIOWS_CLASS:
            case EscuelaAppWSClass.GRUPOWS_CLASS:
            case EscuelaAppWSClass.PADRETUTORWS_CLASS:
            case EscuelaAppWSClass.PROFESORWS_CLASS:
                if (usuario.getTipo().equals(TipoUsuario.ADMINISTRATIVO)) {
                    return usuario;
                }
                break;
            case EscuelaAppWSClass.APPPROFESORWS_CLASS:
                if (usuario.getTipo().equals(TipoUsuario.PROFESOR)) {
                    return usuario;
                }
                break;
            case EscuelaAppWSClass.APPPADRETUTORWS_CLASS:
                if (usuario.getTipo().equals(TipoUsuario.PADRE)) {
                    return usuario;
                }
                break;
        }
        throw new InvalidPermException("Permiso denegado");
    }

    public static String obtenerCicloEscolar() {
        Date date = new Date();
        SimpleDateFormat simple = new SimpleDateFormat("dd-MM-yyyy");
        String fecha = simple.format(date);
        String[] split = fecha.split("-");
        int anio = Integer.parseInt(split[2]);
        int mes = Integer.parseInt(split[1]);
        String ciclo;
        if (mes < 8) {
            ciclo = (anio - 1) + "-" + anio;
        } else {
            ciclo = anio + "-" + (anio + 1);
        }
        return ciclo;
    }
}
