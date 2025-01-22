package com.example.demo.posts.dto;

import java.time.LocalDateTime;

import com.example.demo.posts.domain.Posts;

import lombok.Getter;

@Getter
public class PostsListResponseDTO {
	// 전체조회용
	private Long id;
	private String title;
	private String author;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	
	// 생성자를 통해 조회한 entity를 DTO로 변환 과정 거침.
	public PostsListResponseDTO(Posts post) {
		this.id = post.getId();
        this.title = post.getTitle();
        this.author = post.getAuthor();
    }
}
