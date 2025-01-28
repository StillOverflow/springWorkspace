package com.example.demo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieController {
	@GetMapping("/")
	public String movie01() {
		return "movie01";
	}
}
