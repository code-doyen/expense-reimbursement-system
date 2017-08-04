package com.revature.ajax;

import javax.servlet.http.HttpServletRequest;
import com.revature.controller.LoginController;
import com.revature.util.FinalUtil;

public class RequestHelper {
	public static Object process(HttpServletRequest request){
		switch(request.getRequestURI()){
		case "login.ajax":  //requests a controller
			return LoginController.login(request);
		default:
			System.out.println(request.getRequestURI());
			return LoginController.login(request);
			
			//return new AjaxMessage(FinalUtil.NOT_IMPLEMENTED_CODE, FinalUtil.NOT_IMPLEMENTED);
		}
	}
}
