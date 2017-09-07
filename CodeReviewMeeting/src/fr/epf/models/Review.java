package fr.epf.models;

public class Review {
	
	private String reviewName;
	private String reviewDescription; 
	private String reviewDateTime; 
	private String reviewPromotion;
	
	public Review(String reviewName, String reviewDescription, String reviewDateTime, String reviewPromotion) {
		this.reviewName = reviewName;
		this.reviewDescription = reviewDescription;
		this.reviewDateTime = reviewDateTime;
		this.reviewPromotion = reviewPromotion;
	}
	
	public void setReviewName(String reviewName) {
		this.reviewName = reviewName;
	}
	
	public void setReviewDescription(String reviewDescription) {
		this.reviewDescription = reviewDescription;
	}
	
	public void setReviewDateTime (String reviewDateTime) {
		this.reviewDateTime = reviewDateTime;
	}
	
	public void setReviewClass(String reviewPromotion) {
		this.reviewPromotion = reviewPromotion;
	}
	
	public String getReviewName() {
		return reviewName;
	}
	
	public String getReviewDescription() {
		return reviewDescription;
	}
	
	public String getReviewDateTime () {
		return reviewDateTime;
	}
	
	public String getReviewPromotion() {
		return reviewPromotion;
	}
	
	
}
