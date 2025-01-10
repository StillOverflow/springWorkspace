package com.example.demo;

import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@RestController
@SpringBootApplication
@MapperScan(basePackages = "com.example.demo.**.mapper")
public class DemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class); 
	public static void main(String[] args) { SpringApplication.run(DemoApplication.class, args); }
	
//	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
//	}
//	
//	@RequestMapping("/")
//	String home() {
//		return "Hello World!";
//	}
	
}
