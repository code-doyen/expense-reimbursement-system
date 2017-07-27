package com.revature.ajax;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.CheckUsernameController;
import com.revature.util.FinalUtil;

public class RequestHelper {
	public static Object process(HttpServletRequest request){
		switch(request.getRequestURI()){
		case"/FrontController/checkUsername.ajax":
			return CheckUsernameController.checkUsername(request);
			default:
				return new AjaxMessage(FinalUtil.NOT_IMPLEMENTED_CODE, FinalUtil.NOT_IMPLEMENTED);
		}
	}
}
