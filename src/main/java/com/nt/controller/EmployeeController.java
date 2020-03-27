package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;

import com.nt.entity.Employee;
import com.nt.entity.UserDetails;
import com.nt.service.EmpService;

@Controller
public class EmployeeController {
	@Autowired
	EmpService service;
	
	
	@RequestMapping(value = {"/home"})
	public String home(Model model) {
		if(!LoginController.isLoggedIn()) {
			model.addAttribute("msg", "You need to login first!");
			return "login";
		}
		return "home";
	}
	
	@RequestMapping(value = "/selectForm", method = RequestMethod.GET)
	public String selectForm(Model model) {
		if(!LoginController.isLoggedIn()) {
			model.addAttribute("msg", "You need to login first!");
			return "login";
		}
		model.addAttribute("action", "select");
		model.addAttribute("inputName", "id");
		return "select";
	}
	
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public String selectById(@RequestParam("id") int id, Model model) {
		if(!LoginController.isLoggedIn()) {
			model.addAttribute("msg", "You need to login first!");
			return "login";
		}
		boolean isFound = false;
		Employee emp = service.getRecordById(id);
		
		if(emp != null) isFound = true;
		model.addAttribute("emp", emp);
		model.addAttribute("isFound", isFound);
		return "view";
	}
	
	@RequestMapping(value = "/selectByNameForm", method = RequestMethod.GET)
	public String selectByNameForm(Model model) {
		if(!LoginController.isLoggedIn()) {
			model.addAttribute("msg", "You need to login first!");
			return "login";
		}
		model.addAttribute("action", "selectByName");
		model.addAttribute("inputName", "name");
		return "select";
		
	}
	
	@RequestMapping(value = "/selectByName", method = RequestMethod.GET)
	public String selectByName(@RequestParam("name") String name, Model model) {
		if(!LoginController.isLoggedIn()) {
			model.addAttribute("msg", "You need to login first!");
			return "login";
		}
		boolean isFound = false;
		
		Employee emp = service.getRecordByName(name);
		if(emp != null) isFound = true;
		model.addAttribute("emp", emp);
		model.addAttribute("isFound", isFound);
		return "view";
		
	}
	
	@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
	public String selectAll(Model model) {
		if(!LoginController.isLoggedIn()) {
			model.addAttribute("msg", "You need to login first!");
			return "login";
		}
		List<Employee> empList = service.getAllRecord();
		
		boolean isFound = false;
		
		if(empList != null) isFound = true;
		model.addAttribute("empList", empList);
		model.addAttribute("isFound", isFound);
		return "viewAll";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm(Model model) {
		if(!LoginController.isLoggedIn()) {
			model.addAttribute("msg", "You need to login first!");
			return "login";
		}
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute Employee e, Model model) {
		if(!LoginController.isLoggedIn()) {
			model.addAttribute("msg", "You need to login first!");
			return "login";
		}
		if(service.add(e)) {
			model.addAttribute("isRegistered", true);
		}else {
			model.addAttribute("hasError", true);
		}
		return "register";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateForm(Model model) {
		if(!LoginController.isLoggedIn()) {
			model.addAttribute("msg", "You need to login first!");
			return "login";
		}
		return "update";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute Employee e, Model model) {
		if(!LoginController.isLoggedIn()) {
			model.addAttribute("msg", "You need to login first!");
			return "login";
		}
		if(service.update(e)) {
			model.addAttribute("isUpdated", true);
		}else {
			model.addAttribute("hasError", true);
		}
		return "update";
	}
	
	@RequestMapping(value = "/updateModal", method = RequestMethod.POST)
	public String updateModal(@ModelAttribute Employee e, Model model) {
		if(!LoginController.isLoggedIn()) {
			model.addAttribute("msg", "You need to login first!");
			return "login";
		}
		if(service.update(e)) {
			model.addAttribute("isUpdated", true);
		}else {
			model.addAttribute("hasError", true);
		}
		return "redirect:selectAll";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteForm(Model model) {
		if(!LoginController.isLoggedIn()) {
			model.addAttribute("msg", "You need to login first!");
			return "login";
		}
		return "delete";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute Employee e, Model model) {
		if(!LoginController.isLoggedIn()) {
			model.addAttribute("msg", "You need to login first!");
			return "login";
		}
		if(service.delete(e)) {
			model.addAttribute("isDeleted", true);
		}else {
			model.addAttribute("hasError", true);
		}
		return "delete";
	}
	
	@RequestMapping(value = "/deleteModal", method = RequestMethod.POST)
	public String deleteModal(@ModelAttribute Employee e, Model model) {
		if(!LoginController.isLoggedIn()) {
			model.addAttribute("msg", "You need to login first!");
			return "login";
		}
		if(service.delete(e)) {
			model.addAttribute("isDeleted", true);
		}else {
			model.addAttribute("hasError", true);
		}
		return "redirect:selectAll";
	}
	
	@RequestMapping("/profileByName")
	public String profilesPage(Model model) {
		List<String> names = service.getEmployeeNames();
		model.addAttribute("names",names);
		return "profiles";
	}
	
	@RequestMapping("/getProfileByName")
	public String getProfilesPage(@RequestParam("ename") String ename,Model model) {
		List<String> names = service.getEmployeeNames();
		model.addAttribute("names",names);
		Employee emp = service.getRecordByName(ename);
		model.addAttribute("emp", emp);
		return "profiles";
	}
	
	@RequestMapping("/empHome")
	public String empHomePage() {
		return "empHome";
	}
	
	@RequestMapping(value = "/viewEmployee", method = RequestMethod.GET)
	public String selectById(Model model, HttpSession session) {
		
		Object id = session.getAttribute("userId");
		if(id == null) {
			return "login";
		}
		
		try {
			UserDetails ud = service.getUserDetailsById((int) id);
			model.addAttribute("userdetails", ud);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "viewEmployee";
	}
	
}
	