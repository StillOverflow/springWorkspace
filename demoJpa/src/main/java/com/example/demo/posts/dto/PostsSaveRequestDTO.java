package com.example.demo.posts.dto;

import com.example.demo.posts.domain.Posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDTO {
	// 등록용
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDTO(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
    
    // DTO를 entity로 변환하는 메소드
    public Posts toEntity() {
    	return Posts.builder()
    			.title(title)
    			.content(content)
    			.author(content)
    			.build();
    }
}
