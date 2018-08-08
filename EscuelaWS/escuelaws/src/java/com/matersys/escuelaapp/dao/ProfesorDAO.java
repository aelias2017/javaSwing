/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.dao;

import com.matersys.escuelaapp.entity.Profesor;

/**
 *
 * @author eiste
 */
public interface ProfesorDAO {
    Profesor consultarProfesor(String idprofesor);
    void insertarProfesor(Profesor profesor);
}
