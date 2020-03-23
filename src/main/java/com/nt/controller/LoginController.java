package com.nt.controller;

import javax.servlet.http.HttpSession;

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
	
	private static boolean loggedIn = false;
	
	@RequestMapping(value = {"/" ,"/login"}, method = RequestMethod.GET)
	public String loginForm(Model model, HttpSession session) {
		String username = (String) session.getAttribute("username");
		System.out.println(username);
		if(username != null) loggedIn = true;
		
		if(!LoginController.isLoggedIn()) {
			model.addAttribute("msg", "Please login!");
			return "login";
		}
		
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {

		User user = service.getUser(username, password);

		if (user != null) {
			session.setAttribute("username", user.getUsername());
			session.setAttribute("userId", user.getUserId());
			loggedIn = true;
			return "home";
		}
		
		model.addAttribute("msg", "Invalid username and/or password");
		return "login";
	}
	
	@RequestMapping(value = "/logout") 
	public String logOut(Model model, HttpSession session) {
		session.invalidate();
		model.addAttribute("msg", "you have succesfully logged out.");
		loggedIn = false;
		return "login";
	}
	
	public static boolean isLoggedIn() {
		return loggedIn;
	}
}
