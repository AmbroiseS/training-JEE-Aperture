package fr.epf.dao;

import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.epf.models.Member;

@Singleton
public class MemberDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public void save(Member member) {
		entityManager.persist(member);
	}
	

	public void update(Member member) {
		entityManager.merge(member);
	}
	
	
	public Member findOne(Long id) {
		return entityManager.find(Member.class, id);
	}

	public List<Member> findAll() {
		return (List<Member>) entityManager.createQuery("FROM Member").getResultList();
	}
	
	public Member getMemberById(Long id) {
		return (Member) entityManager.createQuery("FROM Member WHERE Id="+id).getSingleResult();		
	}
	
	@SuppressWarnings("unchecked")
	public List<Member> findManyByPromotion(String promotion) {
		return (List<Member>) entityManager.createQuery("FROM Member WHERE promotion='"+promotion+ "'").getResultList(); 
	}
	

	public void deleteOne(Long id) {
		entityManager.createQuery("DELETE FROM Member WHERE id="+id).executeUpdate();		
	}
	
	public List<Member> findAllOfPromotion(String promotion) {
		return (List<Member>) entityManager.createQuery("FROM Member WHERE promotion= \'"+promotion.toString()+"\'").getResultList();			
	}

		
}
