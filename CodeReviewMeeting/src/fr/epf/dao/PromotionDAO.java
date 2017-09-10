package fr.epf.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.epf.models.Member;
import fr.epf.models.Promotion;

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
	
	public List<Promotion> findAll() {
		return (List<Promotion>) entityManager.createQuery("FROM Promotion").getResultList();			
	}
	
	public List<Member> findAllOfPromotion(String promotion) {	
		return (List<Member>) entityManager.createQuery("FROM Member WHERE promotion= \'"+promotion+"\'").getResultList();
	}

}
