package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.di.TV;

@SpringBootTest
public class DiTest {
	@Autowired TV tv;
//	@Autowired ApplicationContext context; // 컨테이너에서 직접 꺼내 씀. = 빈(관리하는 객체들) 담고 있는 스프링 IoC 컨테이너
	
	@Test
	@DisplayName("객체 생성")
	public void test1() {

		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
	}
}
