package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Staff;
import com.revature.service.StaffService;
import com.revature.util.FinalUtil;

public class LoginController {
	
	public static String login(HttpServletRequest request) {
		
		//If it's a GET we just return the view.
		if(request.getMethod().equals(FinalUtil.HTTP_GET)) {
			return "login.html";
		}
		
		//POST logic
		Staff loggedStaff = StaffService.getStaffService().login(
				new Staff(
						//request.getParameter("staff_rank"),
						request.getParameter("username"),
						request.getParameter("password")
						));
		
		// Wrong Credentials
		System.out.println(loggedStaff);
		
		System.out.println(loggedStaff);
		if(loggedStaff.getUsername().equals("")) {
			return "login.html";
		}
		else {
			/* Storing loggedStaff to current session
			SESSION SCOPE IS AVAILABLE ONLY IN THIS REQUEST (CLIENT) */
			request.getSession().setAttribute("loggedStaff", loggedStaff);
			
			if(FinalUtil.MANAGER.equalsIgnoreCase(loggedStaff.getPosition())){
				return "manager.do";
			}
			else{
			//Forward user to hit another controller
			return "staff.do";
			}
		}
	}
}
