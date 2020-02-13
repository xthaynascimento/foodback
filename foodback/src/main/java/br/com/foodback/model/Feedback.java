package br.com.foodback.model;

public class Feedback {

	private Long id;

	private String preference;
	private Boolean satisfied;
	private String comment;
	private Long restaurantId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}
	
	public Boolean getSatisfied() {
		return satisfied;
	}
	
	public void setSatisfied(Boolean satisfied) {
		this.satisfied = satisfied;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Long getRestaurantId() {
		return restaurantId;
	}
	
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
		
}
