package pl.cbl.controller;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.cbl.dao.PostDao;
import pl.cbl.entity.Post;
import pl.cbl.entity.User;
import pl.cbl.repo.PostRepo;


@Controller
public class MainController {

	@Autowired
	private PostRepo pstRep;
	@Autowired
	private PostDao psDao;
	
	
	
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
		//Post newPost = new Post(post.getTitle(), logggedUser.getId());
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
		psDao.del(id);
		return "redirect:/loged";
	}
	
	
	
	
	
	
	
}
