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
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute Employee e, Model model) {
		if(service.update(e)) {
			model.addAttribute("msg" , "Update succesful!");
		}else {
			model.addAttribute("msg", "Error updating employee.");
		}
		return "display";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute Employee e, Model model) {
		if(service.delete(e)) {
			model.addAttribute("msg", "Deletion succesful!");
		}else {
			model.addAttribute("msg", "Error deleting object");
		}
		return "display";
	}
	

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
		System.out.println(username +" : "+ password);
		return "result";
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
	
}
	