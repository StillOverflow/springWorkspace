package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.mappers.BookMapper;
import com.example.demo.service.BookServiceImpl;

@SpringBootTest
class ExamApplicationTests {
	
	@Autowired
	BookMapper mapper;
	
	@Autowired
	BookServiceImpl service;
	
	@Test
	void contextLoads() {
//		int no = mapper.getBookSeq();
		int no = service.getBookSeq();
		System.out.println(no);
	}

}
