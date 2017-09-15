package pl.cbl.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.cbl.entity.Vote;

public interface VoteRepo extends JpaRepository<Vote, Long> {

	Vote findVoteByUserIdAndPostId(long id, long idd);

	List<Vote> findByPostId(long id);

}
