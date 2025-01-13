package com.example.demo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.di.SampleDTOList;
import com.example.demo.di.TodoDTO;

import lombok.extern.slf4j.Slf4j;

// logback 적용. 
// 로그레벨 : TRACE   >   DEBUG   >   INFO   >   WARN   >   ERROR   >   FATAL   >   OFF
// 운영중일 때는 warn이나 error 레벨로 사용하면 됨.
@Slf4j // LoggerFactorry 선언하지 않아도 어노테이션으로 사용 가능. Simple Logging Facade for Java (Log4j 신버전)

//@RestController // @Controller에 @ResponseBody가 추가된 것
@Controller // 빈등록 + 서블릿 커맨드. 사용 시 /templates/***.html 파일 중에서 return(뷰페이지) 자동 연결함.

public class SampleController {
	// org.slf4j.Logger (LOGBACK 최상위 인터페이스)
//	Logger log = LoggerFactory.getLogger(getClass()); // @Slf4j 어노테이션으로 대체 가능
	
	@GetMapping("/")
	public String main() {
		// application.properties에 로그 레벨 추가 이후 System.out.println() 대신 사용 가능. (줄번호 함께 출력 등 다양한 옵션)
		log.info("logger 적용");
		return "sample"; // @Controller 사용 시 html파일로 자동 매핑
	}
	
//	@GetMapping("/sample")
	@RequestMapping(value="sample", method={RequestMethod.GET, RequestMethod.POST})
	public String sample() {
		return "sample2";
	}
	
	
	
	// 쿼리스트링 형식 파라미터 받기
	@GetMapping("/ex01")
	public String ex01(@RequestParam("username") String name, // 어노테이션 이름 명시해주지 않으면 오류남. 변수 이름과 파라미터 이름 다를 때 유용
					   @RequestParam(name="age", required=false, defaultValue="5") int age) { // 수동 타입변환 (req.getParameter() 동일)
//	public String ex01(SampleDto dto) {
		// localhost:81/ex01?name=kim&age=20 식으로 쿼리스트링 값 받을 수 있음. 자동 타입변환!
//		log.debug(dto.toString());
		
		log.debug("name: " + name);
		log.debug("age: " + age);
		return "sample";
	}
	
	// 같은 이름의 파라미터 여러 개 받기
	// * 동일 파라미터가 여러 개 전달되는 경우 String[] aaa 또는 List<String> aaa 식으로 작성 가능
	@GetMapping("/ex02") 
	public String ex02(@RequestParam("hobby") List<String> hobby) {
		log.debug("hobby: " + hobby);
		return "sample";
	}
	
	// 객체 타입의 파라미터 여러 개 받기 (DtoList 클래스 생성)
	@PostMapping("/ex03")
	public String ex03(@RequestBody SampleDTOList list) {
		log.debug("list: " + list);
		return "sample";
	}
	
	
	
	@GetMapping("/ex04")
	public String ex04(@ModelAttribute(name="todo") TodoDTO todo, Model model) {
		// html 파일에서 전달받은 데이터를 꺼내 쓸 수 있음.
		model.addAttribute("serverTime", new Date());
		log.debug("todo: " + todo);
		return "sample";
	}
	
	@ModelAttribute("dept") // 바깥에 따로 지정해놓으면 모든 링크에서 쓸 수 있음.
	public List<String> deptList(){
		return Arrays.asList("기획", "개발", "인사");
	}
	
	// ModelAndView : Model 매개변수 따로 지정하지 않고 모델과 뷰를 합친 것. 사용방식 동일
	@GetMapping("/ex05")
	public ModelAndView ex05(@ModelAttribute("todo") TodoDTO dto) {
		ModelAndView mv = new ModelAndView("sample"); // html명 (연결할 뷰페이지)
		mv.addObject("serverTime", new Date());
		log.debug("todoDto: " + dto);
		return mv;
	}
	
	
	@GetMapping("/ex06")
	public String ddd() {
		return "sample2";
	}
	
//	@GetMapping("aaa")
//	public String department() {
//		return "sample";
//	}
}
