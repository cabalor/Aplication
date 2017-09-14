package pl.cbl.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.cbl.dao.PostDao;
import pl.cbl.dao.VoteDao;
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
	//@ResponseBody
	public String login(@PathVariable String str, @PathVariable long id, Model m, HttpSession ses) {
		User user = (User)ses.getAttribute("loged");
		Post  post = postRep.findOne(id);
		
		Vote vote2 = vRepo.findVoteByUserIdAndPostId(user.getId(), post.getId());
		
		if(vote2==null) {
			Vote vote = new Vote();
			vote.setUser(user);
			vote.setPost(post);
			
			if(str.equals("yes")) {
				post.setSum(post.getSum()+1);
					
				}else if (str.equals("no")){
					post.setSum(post.getSum()-1);;
				}
					
			
			postRep.save(post);
			vRepo.save(vote);
			
			
		} else {
			return "redirect:/main";
		}
		/*List<Vote> votes = vRepo.findAll();
		for(int i =0;i<votes.size();i++) {
			
			if(votes.get(i).getUser().getId()==user.getId() && votes.get(i).getPost().getId()==post.getId()) {
				return "redirect:/main";
			}
		}*/
		
		m.addAttribute("post", post);
		
		return "redirect:/main";
	}
	
	
	
	
	
	
	}


