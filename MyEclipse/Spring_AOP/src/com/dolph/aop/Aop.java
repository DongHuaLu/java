package com.dolph.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component("aop")
public class Aop {

	@Before("execution(* com.dolph.*.UserDAO.*(..))")
	public void before() {
		System.out.println("before");
	}

	@After("execution(* com.dolph.*.UserDAO.*(..))")
	public void after() {
		System.out.println("after");
	}
	
	
	
	@Around("execution(* com.dolph.*.UserDAO.*(..))")
	public void around(ProceedingJoinPoint proceeding){
		Object o=null;//可以有返回值 
		
		System.out.println("around begin");
		try {
			o=proceeding.proceed(proceeding.getArgs());//可以有返回值
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("around end");
	}

}
