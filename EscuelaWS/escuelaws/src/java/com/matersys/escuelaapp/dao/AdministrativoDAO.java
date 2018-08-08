/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.dao;

import com.matersys.escuelaapp.entity.Administrativo;

/**
 *
 * @author eiste
 */
public interface AdministrativoDAO {
    Administrativo consultarAdminstriativo(String idadministrativo, String escuela);
}
