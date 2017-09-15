package pl.cbl.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.cbl.dao.UserDao;
import pl.cbl.entity.User;



@Controller
public class RegisterController {
	
	@Autowired
	private UserDao dao;
		
	@RequestMapping("/register")
	public String register(Model m) {
		User user=new User();
		m.addAttribute("user",user );
		return "register";
	}

	@PostMapping("/register")
	public String registerPost(@Valid User user, BindingResult result) {
		
		if(result.hasErrors()) {
			return "register";
		}
		
		dao.addUser(user);
		return "redirect:/main";
	}
	
	
	
	
	
}
