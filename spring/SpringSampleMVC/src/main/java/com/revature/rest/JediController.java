package com.revature.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.model.Jedi;
import com.revature.service.JediService;

/* This class provides Jedis RESTful endpoints for our application
/* @RequestBody marshals the incoming JSON in the request body into our POJO 
 * @ResponseBody unmarchals the returning object into a JSON.
 * */
@Controller
public class JediController {
	
	@Autowired
	private JediService jediService;
	
	public JediController() {}
	
	@RequestMapping("/getAllJedis.app")
	public @ResponseBody List<Jedi> getAllJedis() {
		return jediService.getAllJedis();
	}

	@RequestMapping("/getJedi.app")
	public @ResponseBody Jedi getJedi(@RequestBody Jedi jedi) {
		return jediService.getJedi(jedi);
	}
}
