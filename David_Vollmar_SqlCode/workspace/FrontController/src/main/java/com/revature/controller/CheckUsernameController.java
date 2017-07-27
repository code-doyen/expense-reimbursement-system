package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.ajax.AjaxMessage;
import com.revature.model.Customer;
import com.revature.service.CustomerService;
import com.revature.util.FinalUtil;

public class CheckUsernameController {
	public static Object checkUsername(HttpServletRequest request){
		if(CustomerService.getCustomerService().isUsernameTaken(
				new Customer(request.getParameter("username")))){
			return new AjaxMessage(FinalUtil.USERNAME_TAKEN_CODE, FinalUtil.USERNAME_TAKEN);
		}
		return new AjaxMessage(FinalUtil.NOT_IMPLEMENTED_CODE, FinalUtil.NOT_IMPLEMENTED);
	}
}
