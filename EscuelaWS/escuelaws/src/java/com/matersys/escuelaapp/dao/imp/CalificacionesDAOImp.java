/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.dao.imp;

import com.matersys.escuelaapp.dao.CalificacionesDAO;
import com.matersys.escuelaapp.dao.EscuelaAppDAO;
import com.matersys.escuelaapp.entity.Calificaciones;
import java.util.List;

/**
 *
 * @author eiste
 */
public class CalificacionesDAOImp extends EscuelaAppDAO implements CalificacionesDAO {

    @Override
    public void insertarCalidacion(Calificaciones calificacion) {
        entityManager.getTransaction().begin();
        entityManager.persist(calificacion);
        entityManager.getTransaction().commit();
    }

    @Override
    public void actualizarCalificacion(Calificaciones calificacion) {
        entityManager.getTransaction().begin();
        entityManager.merge(calificacion);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Calificaciones> consultarCalificacionesAlumno(int numalumno) {
        query = entityManager.createNamedQuery("Calificaciones.findByNumalumno");
        query.setParameter("numalumno", numalumno);
        return query.getResultList();
    }

}
