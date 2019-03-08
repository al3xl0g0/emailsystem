package com.example.emailsys.emailsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String SayHello(Model model) {
		model.addAttribute("wellcom","welcom to john bryce email System");
		return "index";
	}
	
}
