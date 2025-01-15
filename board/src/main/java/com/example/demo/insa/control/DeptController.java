package com.example.demo.insa.control;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.insa.service.DeptDTO;
import com.example.demo.insa.service.DeptSearchDTO;
import com.example.demo.insa.service.impl.DeptServiceImpl;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

//@Controller
@RestController // 뷰페이지 없이 응답 확인만 할 때는 @RestController (Controller + RequestBody)
@Data
@Slf4j
@RequestMapping("/department/*")
public class DeptController {
	
	private final DeptServiceImpl service;
	
	@GetMapping("/")
	public String main() {
		return "redirect:/department/list";
	}
	
	@GetMapping("list")
	public void list(Model model) {
		List<DeptDTO> list = service.getList();
		model.addAttribute("list", list);
	}
	
//	@GetMapping("info")
//	public void get(DeptSearchDTO search, Model model) {
//		DeptDTO dept = service.get(search);
//		model.addAttribute("dept", dept);
//	}
	
	@GetMapping("info")
	public DeptDTO get(@RequestParam("deptid") String deptid, Model model) {
		DeptSearchDTO search = new DeptSearchDTO();
		search.setKeyword(deptid);
		DeptDTO dept = service.get(search);
		return dept;
	}
	
}
