package com.example.demo.posts.dto;

import com.example.demo.posts.domain.Posts;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsResponseDTO {
	// 단건조회용
	private Long id;
	private String title;
	private String content;
	private String author;
	
	// 생성자를 통해 조회한 entity를 DTO로 변환 과정 거침.
	public PostsResponseDTO(Posts post) {
		this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor();
    }
}
