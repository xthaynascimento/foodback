package br.com.foodback.service;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.foodback.model.Restaurant;

public class RestaurantService {
	
	@Inject
	private EntityManager em;
		
    public String createHelloMessage(String name) {    	
        return "Hello " + name + "!";
    }
    
    public Restaurant getRestaurantInfo(Long id) {
    	
    	
    	Restaurant r = new Restaurant();
    	
    	r = em.find(Restaurant.class, id);
    	
    	System.out.println("getRestaurant: " + r.toString());

    	return r;
    }

}
