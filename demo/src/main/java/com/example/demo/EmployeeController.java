package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.mapper.EmployeesMapper;

//@RestController // << html 적용 전
 @Controller // << html 적용 후
public class EmployeeController {
	@Autowired
	EmployeesMapper employeesMapper;
	
//	@GetMapping("/employees")
//	public List<Map<String, Object>> list(){
//		employeesMapper.findAll();
//		return "empList";
//	}
	
	
	// url => http://localhost:81/emp
	@GetMapping("/emp")
	public String list(Model model) {
		model.addAttribute("empList", employeesMapper.findAll());
		return "empList"; // resources/templates/empList.html 연결
	}
	
	@ResponseBody // resources/templates 안에 있는 .html 파일의 body 부분 출력하는 어노테이션
	@GetMapping("/")
	public String hello() {
		return "Hello";
	}
}