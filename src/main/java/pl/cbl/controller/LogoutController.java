package pl.cbl.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.cbl.ses.Login;

@Controller
public class LogoutController {

	
	@RequestMapping("/logout")
	public String login(HttpSession ses) {
		ses.invalidate();

		return "redirect:/main";
	}
	
	
	
	
	
	
	
}
