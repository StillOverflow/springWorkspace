package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.mappers.UserMapper;
import com.example.demo.vo.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class UserMapperTest {
	
	@Autowired
	UserMapper uMapper;
	
//	@Test
	public void test() {
		UserDTO user = uMapper.getUser("user");
//		List<RoleDTO> list = uMapper.getRole(user.getId()); // 매퍼에서 resultMap, collection 적용하면 getUser로 한 번에 조회 가능
		
		log.info(user.toString());
//		log.info(list.toString());
	}
	
	// DB 패스워드 인코딩(암호화) 실행
	@Test
	public void encUpdate() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); 
		
		UserDTO user = uMapper.getUser("admin");
		user.setPassword(encoder.encode(user.getPassword())); // 암호화
		log.info("user: " + user);
		uMapper.updatePw(user);
		
		log.info(uMapper.getUser("user").toString());
		// JUnit 오류나지만 업데이트 실행은 됨.
	}
}
