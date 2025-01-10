package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.mapper.EmployeesDTO;
import com.example.demo.mapper.EmployeesMapper;

@org.springframework.boot.test.context.SpringBootTest
public class EmployeeMapperTest {
	@Autowired
	EmployeesMapper employeesMapper;
	
//	@Test
	public void list() {
//		List<Map<String, Object>> list = employeesMapper.findAll();
		List<EmployeesDTO> list = employeesMapper.findAll();
		System.out.println(list.get(0));
	}
	
//	@Test
	public void find() {
		// given
		Long id = 100L;
		
		// when
//		Map<String, Object> map = employeesMapper.findById(id);
		EmployeesDTO emp = employeesMapper.findById(id);
		
		// then (VO/DTO 쓰지 않고 Map과 List로 받는 경우 컬럼명이 대문자로 반환됨!!)
//		assertEquals(map.get("LAST_NAME").toString(), "King"); // true/false로 반환하여 JUnit에서 결과상태 파악 가능
//		assertEquals(map.get("LAST_NAME").toString(), "King111"); // false
//		System.out.println(emp);
		assertEquals(emp.getLastName(), "King");
	}
	
//	@Test
	public void findByDeptAndName() {
		// given
		Long departmentId = 10L; // Long타입 명시한 숫자 10 (부서번호 10번인 사원 목록)
//		Long departmentId = null;
		Long firstName = null;
		
		// when
//		List<Map<String, Object>> list = employeesMapper.findByDeptAndName(departmentId, firstName);
		List<EmployeesDTO> list = employeesMapper.findByDeptAndName(departmentId, firstName);
		
		// then
		System.out.println(list);
	}
	
}
