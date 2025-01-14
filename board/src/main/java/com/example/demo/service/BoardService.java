package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.BoardDTO;

public interface BoardService {
	boolean register(BoardDTO board);
	boolean modify(BoardDTO board);
	boolean remove(int bno);
	BoardDTO get(int bno);
	List<BoardDTO> getList();
}