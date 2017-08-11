package com.revature.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TracingAspect {
	public static final Logger logger = Logger.getLogger(TracingAspect.class);
	
	@Before("execution(* print* (..))")
	public void entering(JoinPoint joinPoint) {
		logger.trace("Entering: " +
				joinPoint.getStaticPart().getSignature().toString() +
				" with paremeter: " + joinPoint.getArgs()[0]);
	}
	
	@After("execution(* print* (..))")
	public void exiting(JoinPoint joinPoint) {
		logger.trace("Exiting: " +
				joinPoint.getStaticPart().getSignature().toString() +
				" with paremeter: " + joinPoint.getArgs()[0]);
	}
	
	/* Around is more enhanced than After or Before.
	 * Executes before BEFORE. 
	 * It can alter the course of execution, it can be done with return
	 * or throwing an exception. 
	 * */
	@Around("execution(* print* (String))")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		logger.trace("Around: " +
				pjp.getStaticPart().getSignature().toString() +
				" with paremeter: " + pjp.getArgs()[0]);
		
		try {
			System.out.println("String is a number: " + Integer.parseInt((String) pjp.getArgs()[0]));
		} catch (NumberFormatException e) {
			System.out.println("String '"+pjp.getArgs()[0]+"' is not a number.");
			throw e;
		}
		
		pjp.proceed();
	}
	
	@Around("execution(* return* (..))")
	public int aroundReturn(ProceedingJoinPoint pjp) throws Throwable {
		if((int) pjp.getArgs()[0] > 0) {
			pjp.proceed();
			return (int) pjp.getArgs()[0];
		}
		else {
			return 0;
		}
	}
	
	/* Before or After cannot affect the course of the application */
//	@Before("execution(* return* (..))")
//	public int beforeReturn(JoinPoint jp) {
//		return 0;
//	}
	
//	@Around("execution(* return* (..))")
//	public int beforeReturn(ProceedingJoinPoint pjp) {
//		return 0;
//	}
}
