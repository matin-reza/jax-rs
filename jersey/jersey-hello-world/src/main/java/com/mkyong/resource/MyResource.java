package com.mkyong.resource;

import com.mkyong.service.MessageService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class MyResource {

    // DI via HK2
    @Inject
    private MessageService messageService;

    // output text
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Reza hello(Reza reza) {
        System.out.println(reza.getName() + "%%%%%%%%%%%%%%%%");
        System.out.println(reza.getBirthDate() + "%%%%%%%%%%%%%%%%");
        return new Reza();
    }

    @GET
    @Produces("application/json")
    @Consumes("application/json")
    public Reza hello() {
        return new Reza();
    }

    // output text with argument
    @Path("/{name}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam("name") String name) {
        return "Jersey: hello " + name;
    }

    // for dependency injection
    @Path("/hk2")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloHK2() {
        return messageService.getHello();
    }

}
