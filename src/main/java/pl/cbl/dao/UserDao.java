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

	public void editUser(long id, User user) {
		User userUpd = em.find(User.class, id);
		userUpd.setFirstName(user.getFirstName());
		userUpd.setLastName(user.getLastName());
		userUpd.setEmail(user.getEmail());
		em.merge(userUpd);

	}

}
