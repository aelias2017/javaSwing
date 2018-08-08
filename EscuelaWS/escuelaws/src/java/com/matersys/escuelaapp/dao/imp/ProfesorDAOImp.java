/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.dao.imp;

import com.matersys.escuelaapp.dao.EscuelaAppDAO;
import com.matersys.escuelaapp.dao.ProfesorDAO;
import com.matersys.escuelaapp.entity.Profesor;
import javax.persistence.NoResultException;

/**
 *
 * @author eiste
 */
public class ProfesorDAOImp extends EscuelaAppDAO implements ProfesorDAO {

    @Override
    public Profesor consultarProfesor(String idprofesor) {
        try {
            query = entityManager.createNamedQuery("Profesor.findByIdprofesor");
            query.setParameter("idprofesor", idprofesor);
            return (Profesor) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Exception [" + e.getMessage() + "]");
            return null;
        }
    }

    @Override
    public void insertarProfesor(Profesor profesor) {
        entityManager.getTransaction().begin();
        entityManager.persist(profesor);
        entityManager.getTransaction().commit();
    }

}
