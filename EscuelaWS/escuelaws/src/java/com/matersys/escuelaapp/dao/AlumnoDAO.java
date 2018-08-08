/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.dao;

import com.matersys.escuelaapp.entity.Alumno;

/**
 *
 * @author eiste
 */
public interface AlumnoDAO {
    void insertarAlumno(Alumno alumno);
    void actualizarAlumno(Alumno alumno);
    Alumno consultarAlumno(String curp);
    Alumno consultarAlumnoById(int numalumno);
}
