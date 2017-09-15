package pl.cbl.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.cbl.dao.UserDao;
import pl.cbl.entity.User;
import pl.cbl.repo.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserRepository userRepo;

	@RequestMapping("/userEdit")
	public String home(Model m, HttpSession ses) {
		User logedUser = (User) ses.getAttribute("loged");
		User u = userRepo.findOne(logedUser.getId());

		m.addAttribute("logedUser", u);
		return "userEdit";
	}

	@PostMapping("/userEdit")
	public String home(User u, HttpSession ses) {
		User lUser = (User) ses.getAttribute("loged");
		long x = lUser.getId();
		userDao.editUser(x, u);

		return "redirect:/loged";
	}

}
