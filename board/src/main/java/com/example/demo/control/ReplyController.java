package com.example.demo.control;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ReplyServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/replies/*")
@RequiredArgsConstructor
public class ReplyController {
	
	private final ReplyServiceImpl repService;
	
	// 댓글 삭제
	@DeleteMapping("/{rno}")
	public String delete(@PathVariable Integer rno, Model model) {
		log.info("rno: " + rno);
		boolean result = repService.remove(rno);
		log.debug("결과: " + result);
		
		if(result) return "success";
		else return "fail";
	}
	
}
