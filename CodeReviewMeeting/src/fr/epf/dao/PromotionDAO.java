package fr.epf.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.epf.models.Promotion;
import fr.epf.models.Review;

@Singleton
public class PromotionDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(Promotion promotion) {
		entityManager.persist(promotion);
	}
	
	public Promotion findOne(Long id) {
		return entityManager.find(Promotion.class, id);
	}
	
	public Promotion[] findAll() {
		//TO DO GET TODAY DATE
				List<Object[]> promotionsList = entityManager.createQuery("SELECT id, name FROM Promotion").getResultList();
				int promotionCount = promotionsList.size();
					Promotion[] promotions= new Promotion[promotionCount];
					int i= 0;
					
					for(Object[] promotion : promotionsList){
						Promotion promo = new Promotion();
						promo.setName(promotion[1].toString());					
						promotions[i] = promo;
						i++;
					}
					return promotions;
	}

}
