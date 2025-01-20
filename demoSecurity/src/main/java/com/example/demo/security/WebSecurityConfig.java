package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	// 외부 라이브러리 Configuration + Bean 사용
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
        		// 권한 없이 접근 가능한 페이지
                .requestMatchers("/", "/home", "/login")
                .permitAll() // 모든 사용자에게 권한 허용
                .requestMatchers("/admin").hasRole("ADMIN")
                .anyRequest()
                .authenticated() // 다른 모든 경로는 권한 필요
            )
            .formLogin((form) -> form
        		// 다른 모든 경로에서 권한 없는 사용자에게는 /login 페이지 표시
            	.loginPage("/login") // Spring Security 자체에서 로그인페이지를 제공, 커스텀 페이지 login.html도 가능
            	.usernameParameter("userId") // username : 스프링의 사용자 아이디. (파라미터 : input의 name 속성)
                .permitAll() // /login 페이지에 대한 접근 권한 허용
                // 로그인 성공 처리
                .successHandler(new CustomLoginSuccessHandler()) // 처리 및 페이지 지정할 클래스 생성
            )
            .logout((logout) -> logout.permitAll()) // 모든 사용자에게 logout 요청 허용
            // CSRF 공격 : 사이트간 요청 위조. 조회수 늘리기 등... 방지하기 위해 토큰을 난수로 발급하여 세션에 저장함.
            .csrf(csrf -> csrf.disable()) 
            ;

        // 접근권한 오류 처리 - 403 : 액세스 오류.
//        http.exceptionHandling(ex -> ex.accessDeniedPage("/error403")); // error403.html 페이지로 직접 이동
        http.exceptionHandling(ex -> ex.accessDeniedHandler(new CustomAccessDeniedHandler())); // 오류 처리할 클래스 생성 (데이터 반환 가능)
        return http.build();
    }

//    @Bean
    public UserDetailsService userDetailsService() {
        @SuppressWarnings("deprecation") // java 컴파일 경고 제외 어노테이션
		UserDetails user =
             User.withDefaultPasswordEncoder()
                .username("user")
                .password("1111")
                .roles("USER")
                .build();

        @SuppressWarnings("deprecation")
		UserDetails admin =
                 User.withDefaultPasswordEncoder()
                    .username("admin")
                    .password("1111")
                    .roles("ADMIN")
                    .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}