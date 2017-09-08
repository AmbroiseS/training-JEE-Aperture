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
	
	public Review[] findAll() {
		//TO DO GET TODAY DATE
		List<Object[]> reviewsList = entityManager.createQuery("SELECT reviewName, reviewDateTime, reviewPromotion FROM Review WHERE reviewDateTime >'2017-09-25' ").getResultList();
		int reviewcount = reviewsList.size();
			Review[] reviews= new Review[reviewcount];
			int i= 0;
			
			for(Object[] review : reviewsList){
				Review rw = new Review();
				rw.setReviewName(review[0].toString());
				rw.setReviewPromotion(review[2].toString());
				rw.setReviewDateTime(review[1].toString());
				reviews[i] = rw;
				i++;
			}
			return reviews;
	}
	
	
}
