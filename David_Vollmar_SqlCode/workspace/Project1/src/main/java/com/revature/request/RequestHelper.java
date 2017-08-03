package com.revature.request;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.HomeController;
import com.revature.controller.LoginController;
import com.revature.controller.ManagerController;

/* Class that helps the MasterServlet with mappings to specific controllers */
public class RequestHelper {
	
	public static String process(HttpServletRequest request) {
		System.out.println(request.getRequestURI());
		switch(request.getRequestURI()) {
		case "/Project1/login.do":
			return LoginController.login(request);
		case "/Project1/home.do":
			return HomeController.home(request);
		case "/Project1/manager.do":
			System.out.println("in here");
			return ManagerController.manager(request);
		default:
			return "404.jsp";
		}
	}
}
