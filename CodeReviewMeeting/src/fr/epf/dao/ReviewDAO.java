package fr.epf.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.epf.models.Review;

@Singleton
public class ReviewDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(Review review) {
		entityManager.persist(review);
	}
	
	public Review findOne(Long id) {
		return entityManager.find(Review.class, id);
	}
	
	public List<Review> findAll() {
		Date now = new Date();
		DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		String today = dateFormat.format(now);		
		return (List<Review>) entityManager.createQuery("FROM Review WHERE reviewDateTime >='"+ today + "' ").getResultList();
		
	}
	
	
}
