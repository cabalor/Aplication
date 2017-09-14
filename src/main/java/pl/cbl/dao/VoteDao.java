package pl.cbl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


import pl.cbl.entity.Vote;

@Repository
@Transactional
public class VoteDao {

	@PersistenceContext
	private EntityManager em;
	
	
	public void addVote(Vote vote) {
		em.persist(vote);
		
		
	}
	public void delAll(List<Vote>list) {
		for(int i=0;i<list.size();i++) {
			em.remove(list.get(i));
		}
		
	}
	
	
}
