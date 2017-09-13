package pl.cbl.dao;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


import org.springframework.stereotype.Repository;

import pl.cbl.entity.User;

@Repository
@Transactional
public class UserDao {

	@PersistenceContext
	EntityManager em;
	
	
	public void addUser(User user) {
		em.merge(user);
		
		
	}
	
	
	
}
