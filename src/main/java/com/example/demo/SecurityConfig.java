package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration//자동으로 스캔되어야 하니 설정해요
@EnableWebSecurity//어노테이션 기반 시큐리티 설정임을 나타냅니다
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		
		http.authorizeRequests()			//사용자의 요청별 권한 설정하겠습니다
		.mvcMatchers("/","/all/**").permitAll()	//"/","/all/**" 이러한 요청들은 아무나 다 사용 할 수 있어요
		.mvcMatchers("/insertMember","/main.html").permitAll()
		.mvcMatchers("/admin/**").hasRole("ADMIN")	//"/admin/**" 이러한 요청들은 ADMIN권한(role)이 있어야 사용할 수 있어요
		.anyRequest().authenticated();		//그 나머지는 요청들은 인증(로그인)만 거치면 사용할 수 있어요
		
		http.formLogin();	//스프링 시큐리티가 제공하는 로그인폼을 사용하겠습니다
		http.httpBasic();	//http기본 프로토콜을 사용하겠습니다
	}
	
}