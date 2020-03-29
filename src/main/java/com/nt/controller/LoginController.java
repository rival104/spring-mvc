package com.nt.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.entity.User;
import com.nt.service.EmpService;

@Controller
public class LoginController {
	@Autowired
	EmpService service;

	private static final Logger logger = Logger.getLogger(LoginController.class.getName());

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String loginForm(Model model, HttpSession session) {
		// logs
		logger.info("Server started!");

		String role = (String) session.getAttribute("role");
		if (role == null) {
			return "login";
		}

		if(role.equals("hr")) {
			return "home";
		}else {
			return "empHome";
		}	
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model, HttpSession session) {

		User user = service.getUser(username, password);

		if (user != null) {
			logger.info(user.getUsername() + " signed In.");
			session.setAttribute("username", user.getUsername());
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("role", user.getRole());
			if(user.getRole().equals("hr")) {
				return "home";
			}else if(user.getRole().equals("emp")){
				return "empHome";
			}	
		}

		model.addAttribute("msg", "Invalid username and/or password");
		return "login";
	}

	@RequestMapping(value = "/logout")
	public String logOut(Model model, HttpSession session) {
		logger.info(session.getAttribute("username") + " signed out.");
		session.invalidate();
		model.addAttribute("msg", "you have succesfully logged out.");
		return "login";
	}
	
	@RequestMapping(value = "/accessError")
	public String accessErrorPage() {
		return "accessError";
	}
	
}
