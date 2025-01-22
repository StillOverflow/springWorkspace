package com.example.demo.control;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.service.BookServiceImpl;
import com.example.demo.vo.BookVO;
import com.example.demo.vo.RentVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BookController {
	
	final BookServiceImpl service;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	// 등록폼으로 이동
	@GetMapping("/register")
	public String register(BookVO book, Model model) {
		int no = service.getBookSeq();
		book.setBookNo(no);
		model.addAttribute("book", book);
		return "register";
	}
	
	// 등록 실행
	@PostMapping("/register")
	public String registerIn(@Validated BookVO book, BindingResult bresult, RedirectAttributes rttr, Model model) {
		if(bresult.hasErrors()) {
			int no = service.getBookSeq();
			model.addAttribute("seqno", no);
			model.addAttribute("book", book);
			log.info("(실패)책정보: " + book.toString());
			return "/register"; // validated 실패 시 오류 반환
		}
		
		log.info("책정보: " + book.toString());
		boolean result = service.bookRegiester(book);
		rttr.addFlashAttribute("result", result);
		return "redirect:/list";
	}
	
	// 도서 조회
	@GetMapping("/list")
	public void list(Model model) {
		List<BookVO> bookList = service.getBookList();
		model.addAttribute("bookList", bookList);
	}
	
	// 도서대여현황 조회
	@GetMapping("/current")
	public void current(Model model) {
		List<RentVO> rentList = service.getRentCurrent();
		model.addAttribute("rentList", rentList);
	}
	
}
