package com.example.demo.control;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.common.Paging;
import com.example.demo.service.BoardServiceImpl;
import com.example.demo.vo.BoardDTO;
import com.example.demo.vo.BoardSearchDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board/*")
//@Data
public class BoardController {
	
	@Autowired
	BoardServiceImpl service;
	
	@GetMapping("")
	public String main() {
//		return "index";
		return "redirect:/board/list";
	}
	
	@GetMapping("/list")
	public void list(BoardSearchDTO search, Model model, Paging paging) {
//		model.addAttribute("list", service.getList());
		
		// 페이징 적용
		// paging.setPage(...);
		paging.setTotalRecord(service.getCount(search));
		model.addAttribute("search", search);
		model.addAttribute("paging", paging);
		
		search.setStart(paging.getFirst());
		search.setEnd(paging.getLast());
		log.debug("paging: " + paging);
		log.debug("search: " + search);
		model.addAttribute("list", service.getListWithPage(search));
		
//		return "board/list"; // 생략해도 url과 html 이름이 같다면 자동으로 찾음.
	}
	
	@GetMapping("/list/{bno}")
	public String info(@PathVariable int bno, Model model) {
		model.addAttribute("board", service.get(bno));
		return "board/info";
	}
	
	@GetMapping("/register")
	public String form(BoardDTO board, Model model) {
		model.addAttribute("now", new Date());
		return "board/form";
	}
	
	@PostMapping("/register") // Validation 유효성검사 적용. 매개변수 순서 중요!!(오류 발생)
	public String insert(@Validated BoardDTO board, BindingResult bresult, RedirectAttributes rttr) {
		if(bresult.hasErrors()) return "board/form"; // html에서 th:errors="${board.title}"... 로 메세지 반환 가능
		
		log.info("board: " + board);
		boolean result = service.register(board);
		log.debug("결과: " + result);
		
		// RedirectAttributes : redirect 시 데이터를 함께 전달 가능
		rttr.addFlashAttribute("regResult", result);
		// addAttribute() : 새로고침해도 url에 남은 데이터를 계속 읽어옴.
		// addFlashAttribute() : 휘발성 데이터, 새로고침하면 사라짐.
		return "redirect:/board/list";
	}
	
	@GetMapping("/mod/{bno}")
	public String modifyForm(@PathVariable int bno, Model model) {
		model.addAttribute("board", service.get(bno));
		return "board/modifyForm";
	}
	
	@PostMapping("/modify") // form method post인 경우 PostMapping으로 맞춰야 함.
	public String modify(BoardDTO board, RedirectAttributes rttr) {
		log.info("board: " + board);
		boolean result = service.modify(board);
		log.debug("결과: " + result);
		
		rttr.addFlashAttribute("modResult", result);
		return "redirect:/board/list/" + board.getBno();
	}
	
	@GetMapping("/delete") // form method get으로 쿼리스트링 처리
	public String delete(Integer bno, RedirectAttributes rttr) {
		log.info("bno: " + bno);
		boolean result = service.remove(bno);
		log.debug("결과: " + result);
		
		rttr.addFlashAttribute("delResult", result);
		return "redirect:/board/list";
	}
	
}
