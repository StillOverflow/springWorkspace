package com.example.demo.posts.control;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.posts.dto.PostsListResponseDTO;
import com.example.demo.posts.dto.PostsResponseDTO;
import com.example.demo.posts.dto.PostsSaveRequestDTO;
import com.example.demo.posts.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class IndexController {
	
	private final PostService service;

	@GetMapping("/")
	public String index(Model model,
			@PageableDefault(page = 1, size = 3, sort = "id", direction = Direction.ASC ) Pageable pagable) {
//		model.addAttribute("posts", postsService.findAllDesc() );
//		model.addAttribute("posts",	service.findAllPaging(pagable) );
		
		List<PostsListResponseDTO> list = service.findAll();
		log.info(list.toString());
		model.addAttribute("posts", list);
		return "index";
	}
	
	// 등록페이지 이동
	@GetMapping("/posts/save")
	public String saveForm(PostsSaveRequestDTO requestDto, Model model) {
		List<PostsListResponseDTO> list = service.findAll();
		log.info(list.toString());
		model.addAttribute("posts", list);
		return "posts-insert";
	}
	
	// 수정페이지 이동
	@GetMapping("/posts/update/{id}")
	public String update(@PathVariable("id") Long id, Model model) {
		PostsResponseDTO post = service.findById(id);
		log.info(post.toString());
		model.addAttribute("post", post);
		return "posts-update";
	}
	
}
