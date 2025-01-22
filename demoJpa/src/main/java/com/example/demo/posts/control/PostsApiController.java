package com.example.demo.posts.control;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.posts.dto.PostsSaveRequestDTO;
import com.example.demo.posts.dto.PostsUpdateRequestDTO;
import com.example.demo.posts.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController // Constoller + ResponseBody (Json 형식으로 데이터만 전달)
@RequiredArgsConstructor
public class PostsApiController {
	
	private final PostService service;
	
	// 등록
	@PostMapping("/api/v1/posts") // GetMapping
    public Long save(@RequestBody PostsSaveRequestDTO requestDto) {
        return service.save(requestDto);
    }
	
	// 수정
	@PutMapping("/api/v1/posts/{id}") // GetMapping
    public Long update(@PathVariable("id") Long id, @RequestBody PostsUpdateRequestDTO requestDto) {
        return service.update(id, requestDto);
    }
	
	// 삭제
	@DeleteMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable("id") Long id) {
        return service.delete(id);
    }
	
}
