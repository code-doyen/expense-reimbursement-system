package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.service.JediService;

public class Main {

	public static void main(String[] args) {
		System.out.println("Spring Xml");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicaitonContext.xml");
		JediService jediService = appContext.getBean("jediService", JediService.class);
		System.out.println(jediService.getAllJedis());
	
	}

}