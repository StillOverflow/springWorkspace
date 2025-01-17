package com.example.demo.common;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

// AspectJ : AOP 설정 라이브러리
// AOP : 원하는 Concern(주요기능)과 주변로직(Advice-예외처리 등..) 분리, 비즈니스 로직과 재결합
@Aspect
@Component
@Slf4j
public class Aop {
	@Pointcut("execution(* com.example..*Impl.*(..))") // 모든 서비스에 적용
	public void allpointcut() {	}
	
	@Pointcut("execution(* com.example..*Impl.get*(..))") // 서비스에서 get 메소드에 적용
	public void getpointcut() {	}
	
	@Before("allpointcut()")
	public void log(JoinPoint jp) {
		// 메소드 이름 출력
		String methodname = jp.getSignature().getName(); // getSignature : 해당 객체 자체를 반환, getName : 메소드명 반환
		log.info(methodname);
		
		Object[] obj = jp.getArgs();
		if(obj != null) {
			log.info("beforeParameter: " + obj);
			Arrays.asList(obj).forEach(p -> log.info(p.toString())); // TypeScript가 아니므로 -> Java 문법 지원
		}
	}
	
	@AfterReturning(value = "getpointcut()", returning = "result")
	public void after(JoinPoint jp) {
		// 메소드 이름 출력
		String methodname = jp.getSignature().getName(); // getSignature : 해당 객체 자체를 반환, getName : 메소드명 반환
		log.info(methodname);
		
		Object[] obj = jp.getArgs();
		if(obj != null) {
			log.info("afterParameter: " + obj);
			Arrays.asList(obj).forEach(p -> log.info(p.toString())); // TypeScript가 아니므로 -> Java 문법 지원
		}
	}
	
}
