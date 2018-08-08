/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.dao.imp;

import com.matersys.escuelaapp.dao.EscuelaAppDAO;
import com.matersys.escuelaapp.dao.GrupoDAO;
import com.matersys.escuelaapp.entity.Grupo;
import java.util.List;

/**
 *
 * @author eiste
 */
public class GrupoDAOImp extends EscuelaAppDAO implements GrupoDAO {

    @Override
    public Grupo consultarGrupo(String escuela, String nivel,
                        String grado, String grupo) {
        query = entityManager.createNamedQuery("Grupo.findById");
        query.setParameter("escuela", escuela);
        query.setParameter("nivel", nivel);
        query.setParameter("grado", grado);
        query.setParameter("grupo", grupo);
        return (Grupo) query.getSingleResult();
    }

    @Override
    public List<Grupo> consultarGrupos(String escuela) {
        query = entityManager.createNamedQuery("Grupo.findByEscuela");
        query.setParameter("escuela", escuela);
        List<Grupo> grupos = query.getResultList();
        return grupos;
    }
    
}
