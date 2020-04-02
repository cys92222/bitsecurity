package com.example.demo.controller;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.DbManager;
import com.example.demo.vo.MemberVo;

@RestController
public class InsertController {

	@RequestMapping("/insertMember")
	public int insert(String id, String pwd, String name, String role) {
		String a = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(pwd);
		int re = DbManager.insertMember(new MemberVo(id,a,name,role));
		
		return re;
	}
}
