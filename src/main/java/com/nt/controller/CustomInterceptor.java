package com.nt.controller;

import java.util.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class CustomInterceptor  extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String path = request.getRequestURL().toString();
		if(path.endsWith("/") || path.contains("/login")) {
			return true;
		}
		String role = (String) session.getAttribute("role");
		if (role != null) {
			if(role.equals("hr"))
				return true;
			
			if(role.equals("emp") && isEmpLink(path)) {
				return true;
			}else {
				response.sendRedirect("accessError");
			}
				
		}
		return false;
	}
	
	private boolean isEmpLink(String path) {
		List<String> links = new ArrayList<>();
		
		links.add("/empHome");
		links.add("/viewEmployee");
		links.add("/accessError");
		links.add("/logout");
		
		for(String link: links) {
			if(path.contains(link))
				return true;
		}
		return false;
	}

}
