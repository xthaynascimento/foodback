package br.com.foodback.rs;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.foodback.model.Feedback;
import br.com.foodback.service.FeedbackService;

@Path("/")
@Stateless
public class FeedbackController {

    @Inject
    private FeedbackService feedbackService;
    
    @POST
    @Path("/feedback")
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public Feedback createFeedback(@FormParam("preference") String preference, @FormParam("satisfied") String satisfied, @FormParam("restaurantId") Long restaurantId) {
        System.out.println("Creating feedback for option " + preference + " " + satisfied + " " + restaurantId);
        	
        return feedbackService.addFeedback(preference, (satisfied.equals("yes") ? true : false), restaurantId); 
        
    }
        
    @POST
    @Path("/feedback/comment")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public Feedback createFeedbackComment(@FormParam("comment") String comment, @FormParam("commentId") Long commentId) {
        System.out.println("Adding comment for feedback id: " + comment + " " + commentId);
        return feedbackService.addFeedbackComment(commentId, comment); 
        
    }   
    
    @GET
    @Path("/feedback/{id}")
    @Produces("application/json")
    public Feedback getFeedback(@PathParam("id") Long id) {
       System.out.println("Getting feedback: " + id);
        
       Feedback f = feedbackService.findFeedback(id);
        
       return f;
    }
    
    @GET
    @Path("/feedback/restaurant/{id}")
    @Produces("application/json")
    public List<Feedback> getFeedbackByRestaurant(@PathParam("id") Long id) {
       System.out.println("Getting feedbacks for restaurant: " + id);
        
       List<Feedback> feedbacks = feedbackService.findFeedbackByRestaurant(id);
        
       return feedbacks;
    }
   
}
