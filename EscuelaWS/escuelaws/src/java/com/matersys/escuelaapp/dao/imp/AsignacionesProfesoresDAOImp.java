/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.dao.imp;

import com.matersys.escuelaapp.dao.AsignacionesProfesoresDAO;
import com.matersys.escuelaapp.dao.EscuelaAppDAO;
import com.matersys.escuelaapp.dto.AsignacionesProfesDTO;
import com.matersys.escuelaapp.entity.Asignacionesprofes;
import com.matersys.escuelaapp.util.EscuelaAppUtil;
import javax.persistence.NoResultException;

/**
 *
 * @author eiste
 */
public class AsignacionesProfesoresDAOImp extends EscuelaAppDAO implements AsignacionesProfesoresDAO {

    @Override
    public void insertarAsignacionProfesor(Asignacionesprofes asignacion) {
        entityManager.getTransaction().begin();
        entityManager.persist(asignacion);
        entityManager.getTransaction().commit();
    }

    @Override
    public void acualizarAsignacionesProfesor(Asignacionesprofes asignacion) {
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
        } catch (NoResultException e) {
            System.out.println("Exception [" + e.getMessage() + "]");
            return null;
        }

    }

}
