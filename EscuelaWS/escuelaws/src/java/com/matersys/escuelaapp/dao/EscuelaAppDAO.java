/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author eiste
 */
public abstract class EscuelaAppDAO {
    private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("EscuelaPU");
    protected final EntityManager entityManager;
    protected Query query;
    
    public EscuelaAppDAO() {
        this.entityManager = factory.createEntityManager();
    }
}
