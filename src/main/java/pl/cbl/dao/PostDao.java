package pl.cbl.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import pl.cbl.entity.Post;


@Repository
@Transactional
public class PostDao {

	@PersistenceContext
	EntityManager em;
	
	public void addPost(Post post) {
		em.persist(post);
		
	}
	
	public Post getPost(long id) {
		
		return em.find(Post.class, id);
	}
	
	public void update(long id, Post post) {
		Post postUp = em.find(Post.class, id);
		postUp.setTitle(post.getTitle());
		em.merge(postUp);
		
	}
	
	public void del(long id) {
		Post post = em.find(Post.class, id);
		em.remove(post);
		
	}
}
