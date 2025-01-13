package com.example.demo.dept;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class DeptController {
	@GetMapping("/dept")
	public String dept() {
		return "Department";
	}
	
	@PostMapping("/dept/insert")
	public String insert(DepartmentsDTO dto) { // RequestBody 로 받으면 form데이터를 json으로 바꿔야 하므로 그냥 받아도 됨...
		log.debug("dept: " + dto);
		return "Department";
	}
}
