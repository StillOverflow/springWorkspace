package com.example.demo.mapper;

import java.util.List;

import com.example.demo.vo.BoardDTO;
import com.example.demo.vo.BoardSearchDTO;

//@Mapper // 단일 인터페이스 매퍼 등록. Application @MapperScan으로 대체 가능
public interface BoardMapper {
	int insert(BoardDTO board);
	int update(BoardDTO board);
	int delete(int bno);
	
	BoardDTO read(int bno);
	List<BoardDTO> getList();
	List<BoardDTO> getListWithPage(BoardSearchDTO search);
	int getCount(BoardSearchDTO search);
}
