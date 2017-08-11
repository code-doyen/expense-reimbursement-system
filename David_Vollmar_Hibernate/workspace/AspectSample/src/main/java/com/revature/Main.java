package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.service.SimpleService;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("r");
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("s");
		SimpleService simpleService = (SimpleService) appContext.getBean("simpleService");
		System.out.println("t");
		simpleService.printNumber(1232);
		
		simpleService.printMessage("90");
		
		simpleService.ejectDouble(2.3);
	}

}
