package com.example.demo.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class AroundAdvice {
	@Around("LogAdvice.allpointcut()")
	public Object log(ProceedingJoinPoint pjp) throws Throwable {
		Object obj = null;
		long start = System.currentTimeMillis();
		
		obj = pjp.proceed();
		
		// 서비스 메소드 호출 이후
		long end = System.currentTimeMillis();
		log.info("TIME: " + (end-start));
		return obj;
	}
}
