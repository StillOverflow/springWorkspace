package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.mapper.BoardMapper;
import com.example.demo.vo.BoardDTO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class BoardApplicationTests {

	@Autowired // SpringBootTest에서는 Autowired 명시 필수, final 안 됨!
	BoardMapper mapper; // 생성자 주입
	
	// 테스트 코드 : given - when(조건절) - then(결과 확인) 구조
	// 결과 확인 : log.debug() or assertEquals(,) or assertThat(결과값).isEqualTo(기대값)...
	
//	@Test
	void insert() {
//		BoardDTO board = new BoardDTO();
//		board.setTitle("테스트제목");
//		board.setContent("내용내용");
//		board.setWriter("시험작성자");
		
		// builder 사용 버전
		BoardDTO board = BoardDTO.builder().title("테스트제목").content("내용내용").writer("작성자").build();
		
		int cnt = mapper.insert(board);
		
		log.debug("result: " + cnt);
	}
	
//	@Test
	void update() {
//		BoardDTO board = new BoardDTO();
//		board.setBno(2);
//		board.setTitle("수정된제목");
//		board.setContent("내용수정");
		
//		int cnt = mapper.update(board);
		
//		log.debug("result: " + cnt);
	}
	
	@Test
	void delete() {
		int bno = 8;
		int cnt = mapper.delete(bno);
		log.debug("result: " + cnt);
	}
	
//	@Test
	void read() {
		int bno = 3;
		BoardDTO board = mapper.read(bno);
		log.debug("board: " + board);
	}
	
//	@Test
	void getList() {
		List<BoardDTO> boards = mapper.getList();
		log.debug("boards: " + boards);
	}

}
