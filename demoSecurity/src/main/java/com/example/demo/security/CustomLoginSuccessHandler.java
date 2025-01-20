package com.example.demo.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
		// username 및 role에 따라 로그인 성공 페이지 지정 가능
		List<String> roleNames = new ArrayList<>();
		auth.getAuthorities().forEach(role -> roleNames.add(role.getAuthority())); // 모든 권한을 순회하며 List에 추가함.
	
		log.info("roleName: " + roleNames);
		
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/admin");
			return;
		} else if(roleNames.contains("ROLE_USER")) {
			response.sendRedirect("/hello");
			return;
		}
		
		response.sendRedirect("/"); // admin도 user도 아닐 때
	}
}
