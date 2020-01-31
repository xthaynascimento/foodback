package br.com.foodback;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/")
public class HelloWorld {
    @Inject
    HelloService helloService;

    @GET
    @Path("/json/{name}")
    @Produces("application/json")
    public String getHelloWorldJSON(@PathParam("name") String name) {
        System.out.println("name: " + name);
        return "{\"result\":\"" + helloService.createHelloMessage(name) + "\"}";
    }

}
