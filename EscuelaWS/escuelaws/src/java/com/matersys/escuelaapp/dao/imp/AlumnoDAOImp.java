/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.dao.imp;

import com.matersys.escuelaapp.dao.AlumnoDAO;
import com.matersys.escuelaapp.dao.EscuelaAppDAO;
import com.matersys.escuelaapp.entity.Alumno;
import javax.persistence.NoResultException;

/**
 *
 * @author eiste
 */
public class AlumnoDAOImp extends EscuelaAppDAO implements AlumnoDAO {

    @Override
    public void insertarAlumno(Alumno alumno) {
        entityManager.getTransaction().begin();
        entityManager.persist(alumno);
        entityManager.getTransaction().commit();
    }

    @Override
    public void actualizarAlumno(Alumno alumno) {
        entityManager.getTransaction().begin();
        entityManager.persist(alumno);
        entityManager.getTransaction().commit();
    }

    @Override
    public Alumno consultarAlumno(String curp) {
        query = entityManager.createNamedQuery("Alumno.findByCurp");
        query.setParameter("curp", curp);
        try {
            return (Alumno) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Alumno consultarAlumnoById(int numalumno) {
        query = entityManager.createNamedQuery("Alumno.findByNumalumno");
        query.setParameter("numalumno", numalumno);
        try {
            return (Alumno) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
