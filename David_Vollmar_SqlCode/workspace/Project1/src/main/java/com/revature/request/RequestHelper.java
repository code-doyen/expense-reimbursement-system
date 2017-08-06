package com.revature.request;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.LoginController;
import com.revature.controller.LogoutController;
import com.revature.controller.ManagerController;
import com.revature.controller.StaffController;

/* Class that helps the MasterServlet with mappings to specific controllers */
public class RequestHelper {
	public static String process(HttpServletRequest request) {
		switch(request.getRequestURI()) {
		case "/Project1/login.do":
			return LoginController.login(request);
		case "/Project1/staff.do":
			return StaffController.staff(request);
		case "/Project1/manager.do":
			return ManagerController.manager(request);
		case "/Project1/logout.do":
			return LogoutController.logout(request);
		default:
			return "404.jsp";
		}
	}
}
