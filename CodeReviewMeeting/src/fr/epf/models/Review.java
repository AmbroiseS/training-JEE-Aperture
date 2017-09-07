package fr.epf.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String reviewName;
	private String reviewDateTime; 
	private String reviewPromotion;
	private String description;
	
	public Review() {
		super();
	}
	
	public Review(String reviewName, String reviewDateTime, String reviewPromotion) {
		super();
		this.reviewName = reviewName;
		this.reviewDateTime = reviewDateTime;
		this.reviewPromotion = reviewPromotion;
		this.description = description;
	}
	
	public void setReviewName(String reviewName) {
		this.reviewName = reviewName;
	}
	
	public void setReviewDateTime (String reviewDateTime) {
		this.reviewDateTime = reviewDateTime;
	}
	
	public void setReviewClass(String reviewPromotion) {
		this.reviewPromotion = reviewPromotion;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getReviewName() {
		return reviewName;
	}
	
	public String getReviewDateTime () {
		return reviewDateTime;
	}
	
	public String getReviewPromotion() {
		return reviewPromotion;
	}
	
	public String getDescription() {
		return description;
	}
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
		
}
