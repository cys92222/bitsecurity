package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.db.DbManager;
import com.example.demo.vo.MemberVo;

@SpringBootApplication
public class BitsecurityApplication {

	//패스워드 암호화를 위한 객체를 생성해요
	@Bean //객체 생성자
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	public static void main(String[] args) {
		
		//회원 등록, pwd는 암호화해야됨
		//DbManager.insertMember(new MemberVo("tiger",PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("tiger"), "홍길동", "USER"));
		//DbManager.insertMember(new MemberVo("master",PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("1234"), "곽동길", "ADMIN"));
	
		SpringApplication.run(BitsecurityApplication.class, args);
	}

}
