package com.nt.controller;

import java.util.List;

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
	
	@RequestMapping(value = {"/", "/home"})
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/selectForm", method = RequestMethod.GET)
	public String selectForm(Model model) {
		model.addAttribute("action", "select");
		model.addAttribute("inputName", "id");
		return "select";
	}
	
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public String select(@RequestParam("id") int id, Model model) {
		boolean isFound = false;
		Employee emp = service.getRecordById(id);
		
		if(emp != null) isFound = true;
		model.addAttribute("emp", emp);
		model.addAttribute("isFound", isFound);
		return "view";
	}
	
	@RequestMapping(value = "/selectByNameForm", method = RequestMethod.GET)
	public String selectByNameForm(Model model) {
		model.addAttribute("action", "selectByName");
		model.addAttribute("inputName", "name");
		return "select";
		
	}
	
	@RequestMapping(value = "/selectByName", method = RequestMethod.GET)
	public String selectByName(@RequestParam("name") String name, Model model) {
		boolean isFound = false;
		
		Employee emp = service.getRecordByName(name);
		if(emp != null) isFound = true;
		model.addAttribute("emp", emp);
		model.addAttribute("isFound", isFound);
		return "view";
		
	}
	
	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	public String selectAll(Model model) {
		List<Employee> empList = service.getAllRecord();
		
		boolean isFound = false;
		
		if(empList != null) isFound = true;
		model.addAttribute("empList", empList);
		model.addAttribute("isFound", isFound);
		return "viewAll";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm() {
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute Employee e, Model model) {
		if(service.add(e)) {
			model.addAttribute("isRegistered", true);
		}else {
			model.addAttribute("hasError", true);
		}
		return "register";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateForm() {
		return "update";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute Employee e, Model model) {
		if(service.update(e)) {
			model.addAttribute("isUpdated", true);
		}else {
			model.addAttribute("hasError", true);
		}
		return "update";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteForm() {
		return "delete";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute Employee e, Model model) {
		if(service.delete(e)) {
			model.addAttribute("isDeleted", true);
		}else {
			model.addAttribute("hasError", true);
		}
		return "delete";
	}
	

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
		System.out.println(username +" : "+ password);
		return "result";
	}
	
}
	