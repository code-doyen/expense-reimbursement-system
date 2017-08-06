
package com.revature.controller;

import javax.servlet.http.HttpServletRequest;


public class LogoutController {
	public static String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "login.html";
	}
}
