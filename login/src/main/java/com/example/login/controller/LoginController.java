package com.example.login.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.login.dto.Member;
import com.example.login.service.MemberService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
	@Autowired MemberService memberService;
	
	
	@GetMapping("/public/login") //url 요청
	public String login() {
		return "/public/login"; // 파일 경로
	}
		
	@PostMapping("/public/login")
	public String login(HttpSession session, Member member) {
		boolean pass = memberService.bringMember(member);
		
		if(pass) { // 로그인 됐으면 1 아니면 2로 이동
			return "redirect:/auth/on";
		} else {
			return "redirect:/public/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/public/login";
	}
	
	@GetMapping("/auth/on") // redirect:/auth/on 받으면 GetMapping으로 화면 전환.
	public String on() {
		return "/auth/on";
	}
}
