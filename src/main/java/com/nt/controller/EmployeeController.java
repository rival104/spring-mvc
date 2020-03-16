package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;

import com.nt.entity.Employee;
import com.nt.service.EmpService;

@Controller
public class EmployeeController {
	@Autowired
	EmpService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute Employee e, Model model) {
		boolean isAdded = service.add(e);
		if(isAdded) {
			model.addAttribute("msg" , "Registration succesful!");
		}else {
			model.addAttribute("msg", "Error registering employee.");
		}
		return "display";
	}
	
//	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	public ModelAndView register(@ModelAttribute Employee e) {
//		boolean isAdded = service.add(e);
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("display");
//		
//		if(isAdded) {
//			mav.addObject("msg" , "Registration success!");
//		}else {
//			mav.addObject("msg", "Error registering employee");
//		}
//		return mav;
//	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
		System.out.println(username +" : "+ password);
		return "result";
	}
}
	