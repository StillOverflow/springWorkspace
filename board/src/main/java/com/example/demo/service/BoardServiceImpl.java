package com.example.demo.service;

import java.util.List;

import com.example.demo.mapper.BoardMapper;
import com.example.demo.vo.BoardDTO;

import lombok.Data;

@Data // DI 생성자 의존성 주입
public class BoardServiceImpl implements BoardService {

	final BoardMapper mapper; // DI 생성자 의존성 주입 (필드 1개일 땐 final 생략 가능)

	@Override
	public boolean register(BoardDTO board) {
		return mapper.insert(board) > 0;
	}

	@Override
	public boolean modify(BoardDTO board) {
		return mapper.update(board) > 0;
	}

	@Override
	public boolean remove(int bno) {
		return mapper.delete(bno) > 0;
	}

	@Override
	public BoardDTO get(int bno) {
		return mapper.read(bno);
	}

	@Override
	public List<BoardDTO> getList() {
		return mapper.getList();
	}
	
	
}
