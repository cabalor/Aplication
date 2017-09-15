package pl.cbl.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.cbl.entity.Post;
import pl.cbl.entity.User;
import pl.cbl.entity.Vote;
import pl.cbl.repo.PostRepo;
import pl.cbl.repo.VoteRepo;

@Controller
public class VoteController {

	@Autowired
	private VoteRepo vRepo;
	@Autowired
	private PostRepo postRep;

	@RequestMapping("/vote/{str}/{id}")
	public String login(@PathVariable String str, @PathVariable long id, Model m, HttpSession ses) {
		User user = (User) ses.getAttribute("loged");
		Post post = postRep.findOne(id);

		Vote vote2 = vRepo.findVoteByUserIdAndPostId(user.getId(), post.getId());

		if (vote2 == null) {
			Vote vote = new Vote();
			vote.setUser(user);
			vote.setPost(post);

			if (str.equals("yes")) {
				post.setSum(post.getSum() + 1);

			} else if (str.equals("no")) {
				post.setSum(post.getSum() - 1);
				;
			}

			postRep.save(post);
			vRepo.save(vote);

		} else {
			return "redirect:/voted";
		}

		m.addAttribute("post", post);

		return "redirect:/main";
	}

}
