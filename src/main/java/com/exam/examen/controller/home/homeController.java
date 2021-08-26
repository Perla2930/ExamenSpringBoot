package com.exam.examen.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {

	@GetMapping("/index")
	public String inicio() {
		return "index";
	}
}
