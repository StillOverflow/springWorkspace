package com.example.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Spring Security 설정을 위한 웹 뷰 컨트롤러 (WebMvcConfigurer 인터페이스 상속)
@Configuration
public class MvcConfig implements WebMvcConfigurer {
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/admin").setViewName("admin");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/error403").setViewName("error403");
	}
}
