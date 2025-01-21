package com.example.demo.posts.dto;

import com.example.demo.posts.domain.Posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDTO {
	// 수정 - 제목/내용만 수정 가능하게 함.
    private String title;
    private String content;

    @Builder
    public PostsUpdateRequestDTO(String title, String content) {
        this.title = title;
        this.content = content;
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
