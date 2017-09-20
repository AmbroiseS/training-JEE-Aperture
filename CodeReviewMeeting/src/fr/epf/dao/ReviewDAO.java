package fr.epf.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
		DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = dateFormat.format(now);		
		return (List<Review>) entityManager.createQuery("FROM Review WHERE reviewDateTime >='"+ today + "' ORDER BY reviewDateTime").getResultList();
		
	}

	public Review findNextByPromotion(String promotion) {
		Date now = new Date();
		DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = dateFormat.format(now);	
		return (Review) entityManager.createQuery("FROM Review WHERE reviewPromotion ='"+ promotion + "' AND reviewDateTime >='" + today +"' ORDER BY reviewDateTime").setMaxResults(1).getSingleResult();
	}
	
	@SuppressWarnings("deprecation")
	public List<Review> checkSlotAvailability(String promotion, String date, int duration){
		DateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date reviewDate = null;
		try {
			reviewDate = dateFormat.parse(date);
		} catch (ParseException e) {
		}
		//create two date : two hours prior to desired schedule and two hours after
		Calendar cal = Calendar.getInstance();
		cal.setTime(reviewDate);
		cal.add(Calendar.HOUR, -duration);		
		Date lowerSlot = cal.getTime();
		cal.setTime(reviewDate);
		cal.add(Calendar.HOUR, +duration);
		Date upperSlot = cal.getTime();

		//format dates to compare with database
		String before = dateFormat.format(lowerSlot);
		String after = dateFormat.format(upperSlot);
		//get result list

		return (List<Review>) entityManager.createQuery("FROM Review WHERE reviewPromotion ='"+ promotion + "' AND reviewDateTime >'" + before +"' AND reviewDateTime <'" + after + "' ORDER BY reviewDateTime").getResultList();
	
	}
	
	
}
