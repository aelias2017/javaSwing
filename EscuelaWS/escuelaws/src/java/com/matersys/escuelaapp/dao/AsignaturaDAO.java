/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.dao;

import com.matersys.escuelaapp.entity.Asignatura;
import java.util.List;

/**
 *
 * @author eiste
 */
public interface AsignaturaDAO {
    Asignatura consultarAsignatura(Integer idasignatura);
    List<Asignatura> consultarAsignaturasGrado(String nivel, String grado);
    void insertarAsignatura(Asignatura asignatura);
    void actualizarAsignatura(Asignatura asignatura);
}
