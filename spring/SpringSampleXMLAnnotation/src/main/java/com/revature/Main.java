package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.Jedi;
import com.revature.service.JediService;

public class Main {
	public static void main(String[] args) {
		//Pulling out Application Context.
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Getting JediService Bean with dependencies injected.
		JediService jediService = appContext.getBean("jediService", JediService.class);
		
		//Printing all jedis.
		System.out.println(jediService.getAllJedis());
	}
}
