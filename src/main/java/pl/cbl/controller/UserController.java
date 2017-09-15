package pl.cbl.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.cbl.dao.UserDao;
import pl.cbl.entity.User;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@RequestMapping("/userEdit")
	public String home(Model m, HttpSession ses) {
		User logedUser = (User) ses.getAttribute("loged");
		m.addAttribute("logedUser", logedUser);
		return "userEdit";
	}

	@PostMapping("/userEdit")
	public String home(User logedUser, HttpSession ses) {
		User lUser = (User) ses.getAttribute("loged");
		long x = lUser.getId();
		userDao.editUser(x, logedUser);

		return "redirect:/loged";
	}

}
