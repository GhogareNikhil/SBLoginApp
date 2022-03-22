package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bindings.LoginRequest;
import com.example.demo.service.LoginService;

@RestController
public class LoginRestController {
    
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public String loginAcc(@RequestBody LoginRequest loginRequest) {
		return loginService.login(loginRequest);
	}
}
