package com.example.demo.posts.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.posts.domain.Posts;
import com.example.demo.posts.domain.PostsRepository;
import com.example.demo.posts.dto.PostsSaveRequestDTO;
import com.example.demo.posts.dto.PostsUpdateRequestDTO;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
	
	private final PostsRepository repo;
	
	// 등록
	@Transactional
    public Long save(PostsSaveRequestDTO requestDto) {
        return repo.save(requestDto.toEntity()).getId();
    }
	
	// 수정
	@Transactional
    public Long update(Long id, PostsUpdateRequestDTO requestDto) {
        Posts posts = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }
	
	// 삭제
	public void delete(Long id) {
		repo.delete(repo.findById(id).get());
	}
	
	// 조회
	public List<Posts> findAll() {
		List<Posts> result = repo.findAll();
		return result;
	}
	
	public Page<Posts> findAllPaging(Pageable page){
		Page<Posts> result = repo.findAll(page);
		return result;
	}
}
