package com.project.web.webservices;

import org.apache.log4j.Logger;

import javax.ws.rs.*;

/**
 * Created with IntelliJ IDEA.
 * User: selim.bensenouci
 * Date: 02/08/13
 * Time: 16:58
 * To change this template use File | Settings | File Templates.
 */

@Path("/restcontainer")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class RestContainerService {


    @GET
    @Path("/books")
    public String getJson(){
        return "Success";
    }

    @PUT
    @Path("/book/{isbn}")
    public String getJsons(@PathParam("isbn") String id) {
        return "get"  ;
    }
}
