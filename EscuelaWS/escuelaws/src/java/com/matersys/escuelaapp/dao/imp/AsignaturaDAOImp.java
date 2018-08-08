/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.dao.imp;

import com.matersys.escuelaapp.dao.AsignaturaDAO;
import com.matersys.escuelaapp.dao.EscuelaAppDAO;
import com.matersys.escuelaapp.entity.Asignatura;
import java.util.List;

/**
 *
 * @author eiste
 */
public class AsignaturaDAOImp extends EscuelaAppDAO implements AsignaturaDAO{

    @Override
    public Asignatura consultarAsignatura(Integer idasignatura) {
        query = entityManager.createNamedQuery("Asignatura.findByIdasignatura");
        query.setParameter("idasignatura", idasignatura);
        return (Asignatura) query.getSingleResult();
    }

    @Override
    public List<Asignatura> consultarAsignaturasGrado(String nivel, String grado) {
        query = entityManager.createNamedQuery("Asignatura.findByNivelGrado");
        query.setParameter("nivel", nivel);
        query.setParameter("grado", grado);
        List<Asignatura> asignaturas = query.getResultList();
        return asignaturas;
    }

    @Override
    public void insertarAsignatura(Asignatura asignatura) {
        entityManager.getTransaction().begin();
        entityManager.persist(asignatura);
        entityManager.getTransaction().commit();
    }

    @Override
    public void actualizarAsignatura(Asignatura asignatura) {
        entityManager.getTransaction().begin();
        entityManager.merge(asignatura);
        entityManager.getTransaction().commit();
    }
    
}
