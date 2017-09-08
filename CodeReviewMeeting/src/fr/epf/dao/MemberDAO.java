package fr.epf.dao;

import java.util.ArrayList;
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
	
	public void editOne(Long id) {
		
	}
	
	public void deleteOne(Long id) {
		
	}
	
	public ArrayList<Member> findAll() {
		List<Object[]> list = entityManager.createQuery("SELECT id, name,email, promotion, birthdate FROM Member")
				.getResultList();
		return listToArray(list);
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
