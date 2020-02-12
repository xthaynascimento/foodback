package br.com.foodback.rs;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.foodback.model.Hello;
import br.com.foodback.model.Restaurant;
import br.com.foodback.service.HelloService;

@Path("/")
public class HelloWorld {
	
    @Inject
    private HelloService helloService;
    
    @Inject 
    private EntityManager em;

    @GET
    @Path("/json/{name}")
    @Produces("application/json")
    public String getHelloWorldJSON(@PathParam("name") String name) {
        System.out.println("name: " + name);
        
        //Hello h = new Hello();
        //h.setMessage("Hello " + name);
        
        //em.persist(h);
        return "{\"result\":\"" + helloService.createHelloMessage(name) + "\"}";
    }
    
    @GET
    @Path("/restaurant/{id}")
    @Produces("application/json")
    public Restaurant getRestaurant(@PathParam("id") Integer id) {
        System.out.println("id: " + id);
        
       Restaurant r = new Restaurant();
       r.setAddress("endereço blablablaba");
       r.setName("Nome blablabla");
        
        return r;
    }

}
