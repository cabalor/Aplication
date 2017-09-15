package pl.cbl.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.cbl.dao.PostDao;
import pl.cbl.entity.Post;
import pl.cbl.entity.User;

@Controller
public class AddController {

	@Autowired
	private PostDao psDao;

	@RequestMapping("/add")
	public String register(Model m) {
		Post post = new Post();
		m.addAttribute("post", post);
		return "add";
	}

	@PostMapping("/add")
	public String registerPost(@Valid Post post, HttpSession ses, BindingResult result) {

		if (result.hasErrors()) {
			return "loged";
		}
		User logggedUser = (User) ses.getAttribute("loged");
		post.setUser(logggedUser);
		psDao.addPost(post);
		return "redirect:/loged";

	}

}
