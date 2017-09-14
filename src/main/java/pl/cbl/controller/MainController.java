package pl.cbl.controller;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.cbl.dao.PostDao;
import pl.cbl.dao.VoteDao;
import pl.cbl.entity.Post;
import pl.cbl.entity.User;
import pl.cbl.repo.PostRepo;
import pl.cbl.repo.UserRepository;
import pl.cbl.repo.VoteRepo;


@Controller
public class MainController {

	@Autowired
	private PostRepo pstRep;
	@Autowired
	private PostDao psDao;
	@Autowired
	private VoteRepo vRepo;
	@Autowired
	private VoteDao voteDao;
	@Autowired
	private UserRepository uRep;
	
	@RequestMapping("/main")
	public String home(Model m) {
			List<Post> list = pstRep.findAllByOrderByCreatedDesc();                                       //pstRep.findAll();
			m.addAttribute("postList", list);
			
		return "main";
	}
	
	@RequestMapping("/add")
	public String register(Model m) {
		Post post= new Post();
		m.addAttribute("post",post );
		return "add";
	}

	@PostMapping("/add")
	public String registerPost(Post post, HttpSession ses) {
		User logggedUser = (User)ses.getAttribute("loged");
		post.setUser(logggedUser);
		psDao.addPost(post);
		return "redirect:/loged";
	}
	
	
	@RequestMapping("/edit/{id}")
	public String edited(@PathVariable long id, Model m) {
		Post post = psDao.getPost(id);
		m.addAttribute("post",post );
		return "add";
	}
	
	
	@PostMapping("/edit/{id}")
	public String editeded(@ModelAttribute Post post) {
		long x = post.getId();
		psDao.update(x, post);
		
		
		return "redirect:/loged";
	}
	
	@RequestMapping("/del/{id}")
	public String del(@PathVariable long id) {
		
		Post p = pstRep.findOne(id);
		//List<Vote> votes = vRepo.findByPostId(p.getId());
		//voteDao.delAll(votes);
		pstRep.delete(p);
		return "redirect:/loged";
	}
	
}
