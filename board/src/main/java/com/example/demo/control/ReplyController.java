package com.example.demo.control;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ReplyServiceImpl;
import com.example.demo.vo.ReplyDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController // 페이지 표시 없이 값만 출력(전달)
@Slf4j
@RequestMapping("/replies/*")
@RequiredArgsConstructor
public class ReplyController {
	
	private final ReplyServiceImpl repService;
	
	// 댓글 등록
	@PostMapping("/")
	public String register(@RequestBody ReplyDTO reply) {
		log.info("reply: " + reply);
		boolean result = repService.register(reply);
		log.debug("결과: " + result);
		
		if(result) return repService.getRecentRno();
		else return null;
	}
	
	// 댓글 수정
	@PutMapping(value="/")
	public String modify(@RequestBody ReplyDTO reply) {
		log.info("reply: " + reply);
		boolean result = repService.modify(reply);
		log.debug("결과: " + result);
		
		if(result) return "success";
		else return null;
	}
	
	// 댓글 삭제
//	@RequestMapping(value="/{rno}", method = {RequestMethod.DELETE, RequestMethod.POST})
	@DeleteMapping("/{rno}")
	public String delete(@PathVariable Integer rno) {
		log.info("rno: " + rno);
		boolean result = repService.remove(rno);
		log.debug("결과: " + result);
		
		if(result) return "success";
		else return "fail";
	}
	
}
