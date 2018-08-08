/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.dao;

import com.matersys.escuelaapp.entity.Grupo;
import java.util.List;

/**
 *
 * @author eiste
 */
public interface GrupoDAO {
    Grupo consultarGrupo(String escuela, String nivel, String grado, String grupo);
    List<Grupo> consultarGrupos(String escuela);
}
