package com.appstracta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("message", "Hello Spring MVC Framework!");

		return "hello";
	}

	@GetMapping("/hola")
	public String hola(Model model) {
		model.addAttribute("mensaje", "Hola Spring MVC Framework!");

		return "hola";
	}

}
