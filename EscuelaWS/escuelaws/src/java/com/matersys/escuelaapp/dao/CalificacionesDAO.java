/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.dao;

import com.matersys.escuelaapp.entity.Calificaciones;
import java.util.List;

/**
 *
 * @author eiste
 */
public interface CalificacionesDAO {
    void insertarCalidacion(Calificaciones calificacion);
    void actualizarCalificacion(Calificaciones calificacion);
    List<Calificaciones> consultarCalificacionesAlumno(int numalumno);
}
