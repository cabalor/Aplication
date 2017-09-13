package pl.cbl.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.cbl.entity.Post;

public interface PostRepo extends JpaRepository<Post, Long>{

	
	List<Post> findByUserId(long id);
	List<Post> findAllByOrderByCreatedDesc();
	
	
}
