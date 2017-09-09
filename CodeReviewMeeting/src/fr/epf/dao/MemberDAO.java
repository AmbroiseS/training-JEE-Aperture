package fr.epf.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	
	public void editOne(Long id) {
		
	}
	
	public void deleteOne(Long id) {
		
	}
	
	public ArrayList<Member> findAll() {
		List<Object[]> list = entityManager.createQuery("SELECT id, name,email, promotion, birthdate FROM Member")
				.getResultList();
		return listToArray(list);
	}
	public Member getMemberById(Long id) {
		Member member = new Member();
		Query query = entityManager
				.createQuery("SELECT  name,email, promotion, birthdate FROM Member WHERE id="+id.toString());
		List<Object[]> elementList = query.getResultList();
		
		if (elementList!=null && !elementList.isEmpty()) {
			Object[] object = elementList.get(0);
			member.setName((String) object[0]);
			member.setEmail((String) object[1]);
			member.setPromotion((String) object[2]);
			member.setBirthdate((String) object[3]);
			return member;
		}
		else {
			return null;
		}
		
		
		
	}
	

		
	private ArrayList<Member> listToArray(List<Object[]> list){
		ArrayList<Member> members= new ArrayList<>();
		
		for(Object[] member : list){
			Member mb = new Member();
			
			mb.setId(Long.valueOf(""+ member[0]));
			
			mb.setName(member[1].toString());
			mb.setEmail(member[2].toString());
			mb.setPromotion(member[3].toString());
			if (member[4] !=null) {
				mb.setBirthdate(member[4].toString());	
			}
	
			members.add(mb);

		}
		return members;
	}
		
}
