package cn.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FrontController {
	
	@RequestMapping("/text1.do")
	public void text1() {
		System.out.println("111111111111111111111111111");
	}

	@RequestMapping("/text2.do")
	@ResponseBody
	public String tsst2() {
		
		return "222222222222222222222222";
	}
	
	@RequestMapping("/home.do")
	public String home() {
		return "/fount/home.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
