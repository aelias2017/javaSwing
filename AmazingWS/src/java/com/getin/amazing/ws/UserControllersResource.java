/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.getin.amazing.ws;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author aelias
 */
@Path("/is")
public class UserControllersResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserControllersResource
     */
    public UserControllersResource() {
    }

    /**
     * Retrieves representation of an instance of com.getin.amazing.ws.UserControllersResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * Sub-resource locator method for {name}
     */
    @Path("{name}")
    public UserControllerResource getUserControllerResource(@PathParam("name") String name) {
        return UserControllerResource.getInstance(name);
    }
}
