package com.example.demo.insa.control;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.common.Paging;
import com.example.demo.insa.service.DeptDTO;
import com.example.demo.insa.service.EmpDTO;
import com.example.demo.insa.service.EmpSearchDTO;
import com.example.demo.insa.service.JobDTO;
import com.example.demo.insa.service.impl.DeptServiceImpl;
import com.example.demo.insa.service.impl.EmpServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/emp/*")
public class EmpController {
	
	private final DeptServiceImpl dService;
	private final EmpServiceImpl eService;
	
	@GetMapping("/")
	public String main() {
		return "redirect:/emp/list";
	}
	
	// 사원 전체 조회 & 검색
	@GetMapping("list")
	public void list(EmpSearchDTO search, Model model, Paging paging) {
		// 페이징 적용
		paging.setTotalRecord(eService.getCount(search));
		model.addAttribute("search", search);
		model.addAttribute("paging", paging);
		
		search.setStart(paging.getFirst());
		search.setEnd(paging.getLast());
		log.debug("paging: " + paging);
		log.debug("search: " + search);
		model.addAttribute("list", eService.getList(search));
		
		// 목록 출력
		List<EmpDTO> empList = eService.getList(search);
		log.debug("사원사원: " + empList);
		//List<DeptDTO> deptList = dService.getList();
		//List<JobDTO> jobList = eService.getJobList();
		model.addAttribute("empList", empList);
		//model.addAttribute("deptList", deptList);
		//model.addAttribute("jobList", jobList);
	}
	
	// 사원 등록 폼 or 상세 조회
	@GetMapping("register")
	public void form(EmpDTO emp, Model model) { // /register?employeeId=100 형식
		List<DeptDTO> deptList = dService.getList();
		List<JobDTO> jobList = eService.getJobList();
		EmpDTO employee = new EmpDTO();
		
		if(emp.getEmployeeId() != null) employee = eService.getEmp(emp.getEmployeeId());
		log.info(employee.toString());
		
		model.addAttribute("deptList", deptList);
		model.addAttribute("jobList", jobList);
		model.addAttribute("emp", employee);
		model.addAttribute("now", new Date());
	}
		
	// 사원 등록
	@PostMapping("register") // Validation 유효성검사 적용. 매개변수 순서 중요!!
	public String insert(@Validated EmpDTO emp, BindingResult bresult, RedirectAttributes rttr) {
		if(bresult.hasErrors()) return "emp/register"; // html에서 th:errors="${board.title}"... 로 메세지 반환 가능
		
		log.info("emp: " + emp);
		boolean result = eService.register(emp);
		log.debug("결과: " + result);
		
		// RedirectAttributes : redirect 시 데이터를 함께 전달 가능
		rttr.addFlashAttribute("regResult", result);
		return "redirect:/emp/list";
	}
	
}
