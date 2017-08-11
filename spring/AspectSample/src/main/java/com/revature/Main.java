package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.service.SimpleService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		SimpleService simpleService = (SimpleService) appContext.getBean("simpleService");
		
		//Executing advices.
		try {
			simpleService.printMessage("asd");
		} catch (Exception e) {
		}
		
		//Executing advices as well.
		simpleService.printNumber(1337);
		
		//After throwing executing advice
		try {
			simpleService.ejectDouble(2.3);
		} catch (Exception e) {}
		
		//Around complex
		System.out.println(simpleService.returnNumber(67));
	}

}
