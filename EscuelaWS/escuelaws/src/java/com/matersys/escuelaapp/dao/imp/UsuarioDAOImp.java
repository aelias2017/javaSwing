/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.dao.imp;

import com.matersys.escuelaapp.dao.EscuelaAppDAO;
import com.matersys.escuelaapp.dao.UsuarioDAO;
import com.matersys.escuelaapp.entity.Usuario;
import javax.persistence.NoResultException;

/**
 *
 * @author eiste
 */
public class UsuarioDAOImp extends EscuelaAppDAO implements UsuarioDAO{

    @Override
    public Usuario consultarUsuario(String idusuario) {
        query = entityManager.createNamedQuery("Usuario.findByIdusuario");
        query.setParameter("idusuario", idusuario);
        try {
            Usuario usuario = (Usuario) query.getSingleResult();
            return usuario;
        } catch (NoResultException e) {
            System.out.println("Exception [" + e.getMessage() + "]");
            return null;
        }
    }

    @Override
    public void insertarUsuario(Usuario usuario) {
        entityManager.getTransaction().begin();
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
    }
    
    @Override
    public void actualizarUsuario(Usuario usuario) {
        entityManager.getTransaction().begin();
        entityManager.merge(usuario);
        entityManager.getTransaction().commit();
    }
}
