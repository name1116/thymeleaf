package com.example.thymeleaf2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.thymeleaf2.model.User;
import com.example.thymeleaf2.repository.UserRepository;

@Controller
public class SyntaxController {
	
	private final UserRepository userRepository;
	
	public SyntaxController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	@GetMapping("/main")
	public String mainPage() {
		return "main";
	}
	
	@GetMapping("/page")
	public String layoutPage(Model model) {
		model.addAttribute("layoutTitle","안녕하세요.");
		model.addAttribute("contentTitle","김성철.");
		return "page";
	}
    
    @GetMapping("/user")
    public String myPage(Model model) {
        User user = new User();
        user.setId(100L);
        user.setName("박자바");
        user.setAge(15);
        user.setRole("visitor");
        model.addAttribute("user", user);
        
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("placeholderText", "감기 조심하세요.");
        
        
        model.addAttribute("tag", "<strong>데이터</strong>");
        return "home";
    }
    
    @PostMapping("/user")
    public String saveUser(@ModelAttribute User user) {
    	userRepository.save(user);
    	return "redirect:/user";
    }
    
}


