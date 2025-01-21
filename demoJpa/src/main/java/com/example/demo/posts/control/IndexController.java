package com.example.demo.posts.control;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.posts.service.PostService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IndexController {
	
	private final PostService service;

	@GetMapping("/")
	public String index(Model model,
			@PageableDefault(page = 1, size = 3, sort = "id", direction = Direction.ASC ) Pageable pagable) {
		// model.addAttribute("posts", postsService.findAllDesc() );
		model.addAttribute("posts",	service.findAllPaging(pagable) );
		return "index";
	}
	
}
