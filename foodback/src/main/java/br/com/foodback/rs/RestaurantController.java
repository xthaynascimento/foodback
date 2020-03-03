package br.com.foodback.rs;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.foodback.model.Restaurant;
import br.com.foodback.service.RestaurantService;

@Path("/")
@Stateless
public class RestaurantController {
	
    @Inject
    private RestaurantService service;

    @GET
    @Path("/research/{name}")
    @Produces("application/json")
    public String research(@PathParam("name") String name) {
        System.out.println("name: " + name);
        return "{\"result\":\"" + name + "\"}";
    }
    
    @GET
    @Path("/restaurant/{id}")
    @Produces("application/json")
    public Restaurant getRestaurant(@PathParam("id") Long id) {
        System.out.println("id: " + id);
        
        return service.getRestaurantInfo(id);
        
    }

}
