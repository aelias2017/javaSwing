/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.dao.imp;

import com.matersys.escuelaapp.dao.EscuelaAppDAO;
import com.matersys.escuelaapp.dao.PadretutorDAO;
import com.matersys.escuelaapp.entity.Padretutor;
import javax.persistence.NoResultException;

/**
 *
 * @author eiste
 */
public class PadretutorDAOImp extends EscuelaAppDAO implements PadretutorDAO {

    @Override
    public void insertarPadretutor(Padretutor padretutor) {
        entityManager.getTransaction().begin();
        entityManager.persist(padretutor);
        entityManager.getTransaction().commit();
    }

    @Override
    public Padretutor consultarPadretutor(String id) {
        query = entityManager.createNamedQuery("Padretutor.findByIdusuario");
        query.setParameter("idusuario", id);
        try {
            return (Padretutor) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void actualizarPadretutor(Padretutor padretutor) {
        entityManager.getTransaction().begin();
        entityManager.merge(padretutor);
        entityManager.getTransaction().commit();
    }

}
