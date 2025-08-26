package com.example;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/equation")
public class EquationHttpResource {

    @Inject
    EquationHttpService service;

    @GET
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    public String add(@QueryParam("a") int a, @QueryParam("b") int b) {
        return service.add(a, b);
    }

    @GET
    @Path("/sub")
    @Produces(MediaType.TEXT_PLAIN)
    public String sub(@QueryParam("a") int a, @QueryParam("b") int b) {
        return service.sub(a, b);
    }

    @GET
    @Path("/mul")
    @Produces(MediaType.TEXT_PLAIN)
    public String mul(@QueryParam("a") int a, @QueryParam("b") int b) {
        return service.mul(a, b);
    }

    @GET
    @Path("/div")
    @Produces(MediaType.TEXT_PLAIN)
    public String div(@QueryParam("a") int a, @QueryParam("b") int b) {
        return service.div(a, b);
    }

    @GET
    @Path("/eq1")
    @Produces(MediaType.TEXT_PLAIN)
    public String eq1(@QueryParam("a") int a, @QueryParam("b") int b) {
        return service.eq1(a, b);
    }

    @GET
    @Path("/eq2")
    @Produces(MediaType.TEXT_PLAIN)
    public String eq2(@QueryParam("a") int a, @QueryParam("b") int b, @QueryParam("c") int c) {
        return service.eq2(a, b, c);
    }
}
