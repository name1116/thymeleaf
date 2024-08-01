package com.example.thymeleaf.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.thymeleaf.model.User;
import com.example.thymeleaf.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor //final을 찾아서 생성자를 만들어줌
@Slf4j // log찍기
public class UserController {
	private final UserRepository userRepository;
	
	
	@GetMapping("/")
	public String hello(Model model) {
		model.addAttribute("message", "hello world");
		model.addAttribute("users", userRepository.findAll());
		return "hello"; //resource/templates/hello.html
	}
	
	@PostMapping("/add")
	public String addUser(@RequestParam String name) {
		User user = new User();
		user.setName(name);
		userRepository.save(user);
		return "redirect:/";
	}
	
}
