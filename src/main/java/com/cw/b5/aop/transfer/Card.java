package com.cw.b5.aop.transfer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Card {
	
	//@Before("execution(* com.cw.b5.aop.transfer.Transfer.*(..))")
	@Around("execution(* com.cw.b5.aop.transfer.Transfer.*(..))")
	public Object cartCheck(ProceedingJoinPoint joinPoint) throws Throwable {
	
		System.out.println(" ----- 타기 전 Card Check ----- ");
		Object obj = joinPoint.proceed();//핵심 로직 실행
		System.out.println(" ----- 내릴 때 Card Check ----- ");
		
		return obj;
	}

}
