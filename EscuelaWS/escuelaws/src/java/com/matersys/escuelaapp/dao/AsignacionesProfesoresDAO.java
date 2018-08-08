/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.dao;

import com.matersys.escuelaapp.dto.AsignacionesProfesDTO;
import com.matersys.escuelaapp.entity.Asignacionesprofes;

/**
 *
 * @author eiste
 */
public interface AsignacionesProfesoresDAO {
    void insertarAsignacionProfesor(Asignacionesprofes asignacion);
    void acualizarAsignacionesProfesor(Asignacionesprofes asignacion);
    Asignacionesprofes consultarAsignacion(AsignacionesProfesDTO dto);
}
