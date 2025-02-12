package com.example.demo.control;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.Paging;
import com.example.demo.service.BoardService;
import com.example.demo.vo.BoardDTO;
import com.example.demo.vo.BoardSearchDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin("*") // CORS 어노테이션. * : 모든 메소드를 모든 도메인, 모든 요청방식 허용함.
@RequestMapping("/api/board/*")
@AllArgsConstructor
public class RestBoardController {

	private BoardService service;

	// 해당 url에 json 데이터를 출력하여, grid API에 데이터소스로 사용 가능.
	@GetMapping("/list")
	public Map<String, Object> list(@RequestParam(name = "perPage", defaultValue = "2", required = false) int perPage,
			BoardSearchDTO searchDTO, Paging paging) throws JsonMappingException, JsonProcessingException {

		paging.setPageUnit(perPage);

		// 페이징 조건
		searchDTO.setStart(paging.getFirst());
		searchDTO.setEnd(paging.getLast());

		// 페이징처리
		paging.setTotalRecord(service.getCount(searchDTO));

		String str = """
								{
				  "result": true,
				  "data": {
				    "contents": [],
				    "pagination": {
				      "page": 1,
				      "totalCount": 100
				    }
				  }
				}
								""";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> map = objectMapper.readValue(str, Map.class);
		Map<String, Object> data = (Map) map.get("data");
		Map<String, Object> pagination = (Map) data.get("pagination");

		// 페이징처리
		pagination.put("page", paging.getPage());
		pagination.put("totalCount", service.getCount(searchDTO));

		data.put("contents", service.getList());
		return map;
	}

	// 등록/수정/삭제
	@PutMapping("/modifyData")
	public Map modifyData(@RequestBody GridData<BoardDTO> board) {
		log.info("modify: " + board);
		//service.modify(board);
		return Collections.singletonMap("result", true);
	}
	
	//등록 처리
	@PostMapping("/register")
	public Map register(@RequestBody GridData<BoardDTO> board) {
		log.info("register: " + board);
		//service.register(board);
		return Collections.singletonMap("result", true);
	}

	//수정 처리
	@PutMapping("/update")
	public Map modify(@RequestBody GridData<BoardDTO> board) {
		log.info("modify: " + board);
		//service.modify(board);
		return Collections.singletonMap("result", true);
	}

	//삭제 처리
	@DeleteMapping("/remove")
	public Map remove(@RequestBody GridData<BoardDTO> board) {
//		log.info("remove: " + bno);
		//service.remove(bno);
		return Collections.singletonMap("result", true);
	}
}
