package fr.epf.dao;

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
		return entityManager.createQuery("SELECT reviewName FROM Review").getResultList();
	}
}
