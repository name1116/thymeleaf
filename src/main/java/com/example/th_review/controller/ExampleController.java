package com.example.th_review.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ExampleController {
	@GetMapping("/page")
	public String page1(Model model) {
		model.addAttribute("msg", "page");
		return "page";
	}
	
	@GetMapping("/app/page")
	public String page2(Model model) {
		model.addAttribute("msg", "app/page");
		return "page";
	}
	
	@GetMapping("/r1") //상대경로 리다이렉트
	public String redirect1() {
		return "redirect:page";
	}
	@GetMapping("/app/r2") //상대경로 리다이렉트
	public String redirect2() {
		return "redirect:page";
	}
	
	@GetMapping("/r3") //절대경로 리다이렉트
	public String redirect3() {
		return "redirect:/page";
	}
	@GetMapping("/app/r4")
	public String redirect4() {
		return "redirect:/page";
	}
	
	@GetMapping("/r5") //전체 URL
	public String redirect5() {
		return "redirect:https://google.com";
	}
	
	
	
	
	@GetMapping("/f1") //상대경로 리다이렉트
	public String forward1() {
		return "forward:page";
	}
	@GetMapping("/app/f2") //상대경로 리다이렉트
	public String forward2() {
		return "forward:page";
	}
	
	@GetMapping("/f3") //절대경로 리다이렉트
	public String forward3() {
		return "forward:/page";
	}
	@GetMapping("/app/f4")
	public String forward4() {
		return "forward:/page";
	}
	
	
	
	
	
	
	@GetMapping("/target")
	public String targetPage(Model model, @RequestParam(required = false) String param1, @RequestParam(required = false) String param2) {
		model.addAttribute("message", "목표 페이지");
		model.addAttribute("param1", param1);
		model.addAttribute("param2", param2);
		return "target";
	}
	
	@GetMapping("/redirect-data")
	
	public String redirectData(RedirectAttributes redirectAttributes) {
		redirectAttributes.addAttribute("param1", "value1");
		redirectAttributes.addAttribute("param2", "value2");
		redirectAttributes.addFlashAttribute("msg", "flash"); //세션에 임시로 저장시키게 함
//		- 리다이렉트 후 한 번만 사용할 수 있는 데이터를 전달합니다.
//		- URL에 노출되지 않으므로 큰 객체나 복잡한 데이터 구조를 전달할 때 유용합니다.
//		- 세션에 임시로 저장되었다가 사용 후 즉시 제거됩니다.
		return "redirect:/target";
	}
	
	
	@GetMapping("/forward-example")
	public String forwardExample(Model model) {
		model.addAttribute("message", "포워딩"); //forward 되면서 해당 페이지에서 덮어 씌워줌
		model.addAttribute("message2", "포워딩2");
		
		return "forward:/target";
	}
	
	@GetMapping("/redirect-example")
	public String redirectExample(Model model) {
		model.addAttribute("message","리다이렉트");
		model.addAttribute("message2","리다이렉트2");
		return "redirect:/target";
	}
	
}
