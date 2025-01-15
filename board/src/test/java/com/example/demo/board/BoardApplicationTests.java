package com.example.demo.board;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.example.demo.mapper.BoardMapper;
import com.example.demo.vo.BoardDTO;
import com.example.demo.vo.BoardSearchDTO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@AutoConfigureMockMvc // MockMvc
class BoardApplicationTests {

	// 214p 스프링 기법 (MockMvc 사용 - 스프링부트에서는 MockMvc 없어도 테스트 가능)
	@Autowired MockMvc mvc; // 가짜 MVC서버로 톰캣 없이 컨트롤러 실행 가능.
	
	@Autowired // SpringBootTest에서는 Autowired 명시 필수, final 안 됨!
	BoardMapper mapper; // 생성자 주입
	
	// 테스트 코드 : given - when(조건절) - then(결과 확인) 구조
	// 결과 확인 : log.debug() or assertEquals(,) or assertThat(결과값).isEqualTo(기대값)...
	
//	@Test
	@DisplayName("등록 컨트롤러")
	void insert() throws Exception {
//		BoardDTO board = new BoardDTO();
//		board.setTitle("테스트제목");
//		board.setContent("내용내용");
//		board.setWriter("시험작성자");
		
		// builder 사용 버전 (throws Exception 필수)
//		BoardDTO board = BoardDTO.builder().title("테스트제목").content("내용내용").writer("작성자").build();
//		int cnt = mapper.insert(board);
//		log.debug("result: " + cnt);
		
		// MockMvc
		String param = "title=test&content=testcontent&writer=글쓴이";
		mvc.perform(post("/board/")
		   .content(param) // 실제 브라우저에서 ?title=test&... 식으로 입력하면 GET요청으로 인식함. MockMvc에서 폼데이터처럼 테스트 가능
		   .contentType(MediaType.APPLICATION_FORM_URLENCODED)
		);
	}
	
//	@Test
	@DisplayName("수정 컨트롤러")
	void update() {
//		BoardDTO board = new BoardDTO();
//		board.setBno(2);
//		board.setTitle("수정된제목");
//		board.setContent("내용수정");
		
//		int cnt = mapper.update(board);
		
//		log.debug("result: " + cnt);
	}
	
//	@Test
	@DisplayName("삭제 컨트롤러")
	void delete() {
		int bno = 8;
		int cnt = mapper.delete(bno);
		log.debug("result: " + cnt);
	}
	
//	@Test
	@DisplayName("단건 조회 컨트롤러")
	void read() {
		int bno = 3;
		BoardDTO board = mapper.read(bno);
		log.debug("board: " + board);
	}
	
//	@Test
	@DisplayName("전체 조회 컨트롤러")
	void getList() throws Exception {
//		List<BoardDTO> boards = mapper.getList();
//		log.debug("boards: " + boards);

		// MockMvc 테스트 방법
		mvc.perform(get("/board/list"))
		   .andExpect(status().isOk()) // 뷰페이지 없으면 andDo 프린트까진 안 넣어도 됨.
		   .andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	@DisplayName("전체 조회 페이징 컨트롤러")
	void getListWithPage() throws Exception {
		BoardSearchDTO search = new BoardSearchDTO();
		search.setPage(3);
		List<BoardDTO> boards = mapper.getListWithPage(search);
		log.debug("boards: " + boards);

		// MockMvc 테스트 방법
//		mvc.perform(get("/board/list"))
//		   .andExpect(status().isOk()) // 뷰페이지 없으면 andDo 프린트까진 안 넣어도 됨.
//		   .andDo(MockMvcResultHandlers.print());
	}

}
