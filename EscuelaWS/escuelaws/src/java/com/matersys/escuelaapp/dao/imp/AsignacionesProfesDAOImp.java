/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.dao.imp;

import com.matersys.escuelaapp.dao.AsignacionesProfesDAO;
import com.matersys.escuelaapp.dao.EscuelaAppDAO;
import com.matersys.escuelaapp.dto.AsignacionesProfesDTO;
import com.matersys.escuelaapp.entity.Asignacionesprofes;
import com.matersys.escuelaapp.util.EscuelaAppUtil;

/**
 *
 * @author Alejandro Elias
 */
public class AsignacionesProfesDAOImp extends EscuelaAppDAO implements AsignacionesProfesDAO {

    @Override
    public void insertarAsignacionesProfes(Asignacionesprofes asignacion) {
        entityManager.getTransaction().begin();
        entityManager.persist(asignacion);
        entityManager.getTransaction().commit();
    }

    @Override
    public void actualizarAsignacionesProfes(Asignacionesprofes asignacion) {
        entityManager.getTransaction().begin();
        entityManager.merge(asignacion);
        entityManager.getTransaction().commit();
    }

    @Override
    public Asignacionesprofes consultarAsignacion(AsignacionesProfesDTO dto) {
        query = entityManager.createNamedQuery("Asignacionesprofes.findById");
        query.setParameter("idasignatura", dto.getIdasignatura());
        query.setParameter("escuela", dto.getEscuela());
        query.setParameter("nivel", dto.getNivel());
        query.setParameter("grado", dto.getGrado());
        query.setParameter("grupo", dto.getGrupo());
        query.setParameter("cicloesc", EscuelaAppUtil.obtenerCicloEscolar());
        try {
            Asignacionesprofes asignacion = (Asignacionesprofes) query.getSingleResult();
            return asignacion;
        } catch (Exception e) {
            System.out.println("Exception [" + e.getMessage() + "] ");
            return null;
        }

    }

}
