package br.com.foodback.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.foodback.model.Feedback;
import br.com.foodback.service.FeedbackService;

@Path("/")
public class FeedbackController {

    @Inject
    private FeedbackService feedbackService;
    
    @POST
    @Path("/feedback/{restaurantId}/")
    @Produces("application/json")
    public Feedback createFeedback(@PathParam("restaurantId") Long restaurantId) {
        System.out.println("Creating feedback for option " + "option");
        Feedback response = feedbackService.addFeedback("option", true, restaurantId); //replace mocks
        
        return response;
    }
        
    @POST
    @Path("/feedback/comment/{id}")
    @Produces("application/json")
    public Feedback createFeedbackComment(@PathParam("id") Long id) {
        System.out.println("Adding comment for feedback id: " + id);
        Feedback response = feedbackService.addFeedbackComment(id, "comment here"); //replace mocks
        
        return response;  
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
