package fr.epf.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Promotion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private Integer promotionSize;
	
	public Promotion() {
		super();	
	}
	public Promotion(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getPromotionSize() {
		return promotionSize;
	}
	public void setPromotionSize(Integer promotionSize) {
		this.promotionSize = promotionSize;
	}
	
	

}
