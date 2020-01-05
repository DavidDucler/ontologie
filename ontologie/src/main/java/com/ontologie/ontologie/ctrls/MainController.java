package com.ontologie.ontologie.ctrls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ontologie.ontologie.domain.UserRegisterForm;
import com.ontologie.ontologie.domain.UserSession;

@Controller
public class MainController {

	@Autowired
	UserSession userSession;
	
	@RequestMapping(value="/admin", method = RequestMethod.GET, produces="text/html; charset=utf-8")
	public String admin(UserRegisterForm userRegisterForm, Model model) {
		System.out.println("session: "+userSession.getUsername());
		model.addAttribute("role", userSession.getRole());
		model.addAttribute("username", userSession.getUsername());
		model.addAttribute("email", userSession.getEmail());
		createInitial(model);
		return "admin";
	}
	@RequestMapping(value="/", method = RequestMethod.GET, produces="text/html; charset=utf-8")
	public String index() {
		return "welcome";
	}
	
	@RequestMapping(value="/view", method = RequestMethod.GET, produces="text/html; charset=utf-8")
	public String selectView(Model model) {
		
		switch (userSession.getRole()) {
		case "ROLE_ADMIN":
			return "redirect:/admin";
			

		default:
			return "redirect:/";
		}
	}
	
	public void createInitial(Model model) {
		String[] words = userSession.getUsername().split("");
		if(words.length == 1) {
			model.addAttribute("initial", String.format("%s%s",
					words[0].substring(0, 1).toUpperCase(), words[0].substring(1, 2).toLowerCase()));
		}
		else {
			model.addAttribute("initial", String.format("%s%s",
					words[0].substring(0, 1).toUpperCase(), words[1].substring(0, 1).toUpperCase()));
		}
		System.out.println(model.getAttribute("initial"));
	}
}
