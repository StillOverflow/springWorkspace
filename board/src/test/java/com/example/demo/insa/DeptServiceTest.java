package com.example.demo.insa;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.insa.service.DeptDTO;
import com.example.demo.insa.service.impl.DeptServiceImpl;

import lombok.extern.slf4j.Slf4j;
import com.example.demo.insa.service.DeptSearchDTO;

@Slf4j
@SpringBootTest
public class DeptServiceTest {
	
	@Autowired
	DeptServiceImpl service;
	
//	@Test
	@DisplayName("전체조회")
	void getList() {
		List<DeptDTO> list = service.getList();
		log.debug(list.toString());
	}
	
	@Test
	@DisplayName("단건조회")
	void get() {
		DeptSearchDTO search = new DeptSearchDTO();
		search.setKeyword("20");
		DeptDTO dept = service.get(search);
		log.debug(dept.toString());
	}
}
