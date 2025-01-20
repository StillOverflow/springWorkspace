package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.mappers.UserMapper;
import com.example.demo.vo.UserDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
//@Configuration
// 비밀번호/아이디 DB 연결하여 직접 등록하기 위함
// 비밀번호는 인코딩(암호화) 필요 - BcryptPasswordEncoder 사용(Spring Security API 안에 포함)
public class CustomUserDetailsService implements UserDetailsService {
	
	final UserMapper mapper;
	
//	@Bean
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// loadUserByUsername : 사용자의 정보와 권한 정보 담는 인터페이스. (getAuthorities(), getPassword(), getUsername() 등 추상 메소드 보유)
		
		UserDTO user = mapper.getUser(username);
		if(user == null) {
			throw new UsernameNotFoundException("id check");
		}
		List<GrantedAuthority> role = new ArrayList<>();
		user.getRoles().forEach(r -> role.add(new SimpleGrantedAuthority(r.getRoleName())));
//		return new User(user.getLoginId(), user.getPassword(), role);
		return new CustomUser(user); // UserDTO를 CustomUser 타입으로 변환해줄 클래스 작성
	}
	
}
