package fr.epf.models;

public class Member {
	
	private String name;
	private String email;
	private String promotion;
	private String birthdate;
	
	public Member(String name, String email, String promotion, String birthdate) {
		this.name = name;
		this.email = email;
		this.promotion = promotion;
		this.birthdate = birthdate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPromotion() {
		return promotion;
	}
	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}
	
	public String getBirthdate() {
		return birthdate;
	}
	
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	
	
	
}
