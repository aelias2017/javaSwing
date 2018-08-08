/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.dao;

import com.matersys.escuelaapp.entity.Padretutor;

/**
 *
 * @author eiste
 */
public interface PadretutorDAO {
    void insertarPadretutor(Padretutor padretutor);
    Padretutor consultarPadretutor(String id);
    void actualizarPadretutor(Padretutor padretutor);
}
