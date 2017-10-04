package pl.cbl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.cbl.entity.User;
import pl.cbl.repo.UserRepository;
import pl.cbl.ses.Login;

@Controller
@SessionAttributes("loged")
public class LoginController {

	@Autowired
	UserRepository repoUser;

	@RequestMapping("/login")
	public String login() {
		

		return "login";
	}

	@PostMapping("/login")
	public String loginin(Login loginUser, Model m) {

		User user = repoUser.findUserByLogin(loginUser.getLogin());

		if (user == null) {
			return "redirect:/login";
		}

		if (user.isPasswordCorrect(loginUser.getPassword())) {
			m.addAttribute("loged", user);
		} else {
			return "redirect:/login";
		}

		return "redirect:/main";
	}

}
