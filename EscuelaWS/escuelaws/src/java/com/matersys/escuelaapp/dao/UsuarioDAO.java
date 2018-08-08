/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.dao;

import com.matersys.escuelaapp.entity.Usuario;

/**
 *
 * @author eiste
 */
public interface UsuarioDAO {
    Usuario consultarUsuario(String idusuario);
    void insertarUsuario(Usuario usuario);
    void actualizarUsuario(Usuario usuario);
}
