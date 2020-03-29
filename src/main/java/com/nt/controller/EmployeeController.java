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
	public String selectById(@RequestParam("id") int id, Model model) {
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
	public String selectAll(HttpSession session,Model model) {
		int userId = 0;
		try {
			userId = (int) session.getAttribute("userId");
		} catch(Exception e) {
			model.addAttribute("hasError", true);
			model.addAttribute("errorMsg", "session error!");
			return "viewAll";
		}
	
		List<Employee> empList = service.getAllRecordByUser(userId);
		
		boolean hasError = false;
		if(empList == null) hasError = true;
		model.addAttribute("empList", empList);
		model.addAttribute("hasError", hasError);
		model.addAttribute("errorMsg", "Error getting list");
		return "viewAll";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm(Model model) {
		List<String> names = service.getEmployeeNames();
		model.addAttribute("names",names);
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute Employee e, Model model, HttpSession session) {
		int userId = (int) session.getAttribute("userId");
		e.setCreatorId(userId);
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
	
	@RequestMapping(value = "/updateModal", method = RequestMethod.POST)
	public String updateModal(@ModelAttribute Employee e, Model model) {
		if(service.update(e)) {
			model.addAttribute("isUpdated", true);
		}else {
			model.addAttribute("hasError", true);
		}
		return "redirect:selectAll";
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
	
	@RequestMapping(value = "/deleteModal", method = RequestMethod.POST)
	public String deleteModal(@ModelAttribute Employee e, Model model) {
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
		Employee emp = service.getRecordByName(ename);
		
		model.addAttribute("names",names);
		model.addAttribute("empProps", emp.getProperties());
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
	