package com.example.demo.insa;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.insa.service.EmpDTO;
import com.example.demo.insa.service.EmpSearchDTO;
import com.example.demo.insa.service.impl.EmpServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EmpServiceTest {
	
	@Autowired
	EmpServiceImpl service;
	
	@Test
	@DisplayName("전체조회")
	void getList() {
		EmpSearchDTO search = new EmpSearchDTO();
		search.setStart(1);
		search.setEnd(10);
		List<EmpDTO> list = service.getList(search);
		log.debug(list.toString());
	}
}
