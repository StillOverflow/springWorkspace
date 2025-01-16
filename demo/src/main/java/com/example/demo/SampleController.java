package com.example.demo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.sample.CompVO;
import com.example.demo.sample.SampleVO;
import com.example.demo.sample.Ticket;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.extern.slf4j.Slf4j;

// Rest, Jackson(Json 라이브러리) 테스트
@RestController
@Slf4j
public class SampleController {
	
	// Json 아닌 단순 문자열 보내기
	@GetMapping(value="/getText", produces="text/plain;charset=UTF8")
	// produces : 해당 메소드가 생성하는 결과타입 (개발자도구 Response Headers(view source)에서 확인 가능)
	public ResponseEntity<String> sample() { // ResponseEntity : 요청에 대한 응답 데이터를 포함하는 클래스. (HttpStatus, Headers, Body 포함)
		return new ResponseEntity<> ("안녕하세요", HttpStatus.BAD_GATEWAY); // 데이터와 함께 오류코드(502) 지정 가능
	}
	
	// 객체 보내기 
	@GetMapping(value="/getSample")
	public ResponseEntity<SampleVO> getSample() { 
		SampleVO sample = new SampleVO(111, "성", "이름", new Date());
		return new ResponseEntity<>(sample, HttpStatus.BAD_REQUEST); // 오류코드(400)
	}
	
	// 컬렉션 타입의 객체로 객체 여러 개 보내기
	@GetMapping("/getMap")
	public Map<String, Object> getMap(){
		Map<String, Object> map = new HashMap<>();
		map.put("sample", new SampleVO(222, "박", "길동", new Date()));
		map.put("count", 20);
		map.put("success", true);
		return map;
	}
	
	
	// PathVariable 받기
	@GetMapping("/product/{cate}/{pid}")
	public String[] getPath(@PathVariable("cate") String cate, @PathVariable("pid") int pid) {
		return new String[] {cate, ""+pid}; // Integet.toString()
	}
	
	// RequestBody 받기 (Get방식 및 일반 브라우저에서 테스트 불가)
	@PostMapping("/ticket")
	public List<Ticket> ticket(@RequestBody List<Ticket> ticket) { // Json형식으로 객체, Map, 배열 등 가능
		log.info("ticket: " + ticket);
		return ticket; // form 데이터가 Json 형식으로 변환됨.
	}
	
	// 복합적인 객체 받기 (Body가 한 개라 RequestBody를 여러 개 받을 수 없으므로 별도 클래스 생성 필요)
	@PostMapping("/comp")
	public CompVO comp(@RequestBody CompVO comp) {
		log.info("comp: " + comp);
		log.info("첫번째 티켓 오너: " + comp.getList().get(0).getOwner());
		return comp; // form 데이터가 Json 형식으로 변환됨.
	}

	
	// 영화진흥위원회 영화정보API 데이터 받아오기
	// 인증키 : 12664b24453335d2c3eca0fdc4b3b013
	// URI(데이터 포함한 주소) : http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=12664b24453335d2c3eca0fdc4b3b013&targetDt=20250115
	
	@GetMapping("/movie")
	public String movie(@RequestParam(name="date", defaultValue="20250115", required=false) String date) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=12664b24453335d2c3eca0fdc4b3b013&targetDt=" + date;
		JsonNode node = restTemplate.getForObject(uri, JsonNode.class); // .class : Class<JsonNode> 타입의 객체 반환
		log.info(node.toString());
		
		// JsonNode 객체 안에서 특정 값을 만족하는 값 찾기
		JsonNode dailyList = node.get("boxOfficeResult").get("dailyBoxOfficeList");
		log.info("영화목록: " + dailyList);
		String openDate = "2024-12-24";
		String movieNm = null;
		for(JsonNode data : dailyList) {
			if(data.get("openDt").asText().equals(openDate)) {
				movieNm = data.get("movieNm").asText();
			}
		}
		
		log.info(movieNm);
		return movieNm;
	}
	
}
