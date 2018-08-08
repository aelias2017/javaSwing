/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.getin.amazing.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author aelias
 */
public class UserControllerResource {

    private String name;

    /**
     * Creates a new instance of UserControllerResource
     */
    private UserControllerResource(String name) {
        this.name = name;
    }

    /**
     * Get instance of the UserControllerResource
     */
    public static UserControllerResource getInstance(String name) {
        // The user may use some kind of persistence mechanism
        // to store and restore instances of UserControllerResource class.
        return new UserControllerResource(name);
    }

    /**
     * Retrieves representation of an instance of com.getin.amazing.ws.UserControllerResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of UserControllerResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }

    /**
     * DELETE method for resource UserControllerResource
     */
    @DELETE
    public void delete() {
    }
}
