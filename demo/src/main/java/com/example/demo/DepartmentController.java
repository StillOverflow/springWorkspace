package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.mapper.DepartmentsMapper;

//@RestController // << html 적용 전
 @Controller // << html 적용 후
public class DepartmentController {
	@Autowired
	DepartmentsMapper mapper;
	
	// url => http://localhost:81/dpt
	@GetMapping("/dpt")
	public String list(Model model) {
		model.addAttribute("dptList", mapper.findAll());
		return "dptList"; // resources/templates/dptList.html 연결
	}
}