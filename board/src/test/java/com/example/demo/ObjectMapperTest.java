package com.example.demo;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.example.demo.vo.MemberVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

// ObjectMapper, Rest 방식 예시
@Slf4j
public class ObjectMapperTest {
	@Test
	public void test() throws JsonMappingException, JsonProcessingException {
		// json 형태
		String str = "{\"name\":\"홍\",\"age\":24}";
		log.info(str);
		
		ObjectMapper om = new ObjectMapper();
		MemberVO vo = om.readValue(str, MemberVO.class);
		assertThat(vo.getName()).isEqualTo("홍"); // assertEquals (@SpringBootTest)
		
		// 아래 내용은 @RequestBody 로 대체 가능.
		vo.setAge(30);
		String data = om.writeValueAsString(vo);
		log.info(data);
	}
}
