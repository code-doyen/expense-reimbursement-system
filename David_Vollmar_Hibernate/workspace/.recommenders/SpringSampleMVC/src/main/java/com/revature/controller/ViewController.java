package com.revature.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/* This is how we can return views */
@Controller
public class ViewController {
	
	@RequestMapping(value = "/home.app", method = RequestMethod.GET)	
	public String getAppView() {
		return "app";
		//return "redirect:http://google.com";
		//return "redirect:/app.html";
	}
}
