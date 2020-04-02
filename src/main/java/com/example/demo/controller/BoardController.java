package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
	
	//누구나 실행가능
	@GetMapping("/all/list")
	public String list() {
		return "list";
	}
	
	//로그인하고 어드민 권한이 있는 사람만 실행가능
	@GetMapping("/admin/cmd1")
	public String cmd1() {
		return "서비스1";
	}
	
	//로그인한 사람만 실행가능
	@GetMapping("/insert")
	public String insert() {
		return "insert";
	}
}
