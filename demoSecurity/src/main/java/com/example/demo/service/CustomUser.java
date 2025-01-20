package com.example.demo.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.example.demo.vo.UserDTO;

import lombok.extern.slf4j.Slf4j;


// 669p
// UserDTO를 UsersDetails 타입으로 변환하기
@Slf4j
public class CustomUser extends User {

	private UserDTO user;
	
	// (extends)부모 클래스의 생성자 호출
	private static final long serialVersionUID = 1L;
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public CustomUser(UserDTO user) {
		super(user.getLoginId(), user.getPassword(), 
			  user.getRoles().stream() // .stream() : 원본 보존하면서 배열/컬렉션 읽기. .map 등 다양한 배열 메소드 사용 가능
			  .map(auth -> new SimpleGrantedAuthority(auth.getRoleName())).collect(Collectors.toList())); 
		log.info("CustomUser 결과: " + user.getLoginId(), user.getPassword(), 
				  user.getRoles().stream()
				  .map(auth -> new SimpleGrantedAuthority(auth.getRoleName())).collect(Collectors.toList()));
		
		this.user = user;
	}
	
}
