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
	
	public Member findOne(Long id) {
		return entityManager.find(Member.class, id);
	}
	
	public List<Member> findAll() {
		return entityManager.createQuery("SELECT * FROM member").getResultList();
	}


}
