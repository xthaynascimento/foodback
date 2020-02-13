package br.com.foodback.service;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.foodback.model.Feedback;

public class FeedbackService {
	
	@Inject
	private EntityManager em;
	
	public Feedback addFeedback(String preference, Boolean satisfied, Long restaurantId) {
		Feedback f = new Feedback();
	    f.setPreference(preference);
	    f.setSatisfied(satisfied);
	    f.setRestaurantId(restaurantId);
	        
	    em.persist(f);
	    return f;
	}
	
	public Feedback addFeedbackComment(Long id, String comment) {
		Feedback f = em.find(Feedback.class, id);
		f.setComment(comment);
		
	    return f;
	}
	
	public Feedback findFeedback(Long id) {
		Feedback f = em.find(Feedback.class, id);
	    
	    return f;
	}
	
	public List<Feedback> findFeedbackByRestaurant(Long id) {
		
		Query query = em.createQuery("select e from Feedback e where e.restaurantId = :id",
			    Feedback.class).setParameter("id", id);
		
		return (List<Feedback>) query.getResultList();
	}
	
}