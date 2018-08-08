/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.dao.imp;

import com.matersys.escuelaapp.dao.AdministrativoDAO;
import com.matersys.escuelaapp.dao.EscuelaAppDAO;
import com.matersys.escuelaapp.entity.Administrativo;
import javax.persistence.NoResultException;

/**
 *
 * @author eiste
 */
public class AdministrativoDAOImp extends EscuelaAppDAO implements AdministrativoDAO {

    @Override
    public Administrativo consultarAdminstriativo(String idadministrativo, String escuela) {
        try {
            query = entityManager.createNamedQuery("Administrativo.findById");
            query.setParameter("idadministrativo", idadministrativo);
            query.setParameter("escuela", escuela);
            return (Administrativo) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Exception [" + e.getMessage() + "]");
            return null;
        }
    }
    
}
