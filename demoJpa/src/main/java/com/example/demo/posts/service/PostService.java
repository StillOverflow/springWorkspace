package com.example.demo.posts.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.posts.domain.Posts;
import com.example.demo.posts.domain.PostsRepository;
import com.example.demo.posts.dto.PostsListResponseDTO;
import com.example.demo.posts.dto.PostsResponseDTO;
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
	public Long delete(Long id) {
		repo.delete(repo.findById(id).get());
		return id;
	}
	
	// 조회
	public List<PostsListResponseDTO> findAll() {
		List<Posts> result = repo.findAll();
		// .stream : 컬렉션 객체를 다룰 때 데이터소스에 상관없이 추상화하여 모두 같은 방식으로 처리 가능함.
		//           (.reduce 등 다양한 배열 메소드 사용 가능) => .collect(Collectors.데이터 수집하여 최종 반환)
		return result.stream().map(post -> new PostsListResponseDTO(post)).collect(Collectors.toList());
	}
	
	public List<PostsListResponseDTO> findAllPaging(Pageable page){
		Page<Posts> result = repo.findAll(page);
		return result.stream().map(post -> new PostsListResponseDTO(post)).collect(Collectors.toList());
	}
	
	// 단건조회
	public PostsResponseDTO findById(Long id) {
		Optional<Posts> result = repo.findById(id);
		PostsResponseDTO post = new PostsResponseDTO(result.get());
		return post;
	}
}
