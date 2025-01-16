package com.example.demo.mapper;

import java.util.List;

import com.example.demo.vo.ReplyDTO;
import com.example.demo.vo.ReplySearchDTO;

//@Mapper // 단일 인터페이스 매퍼 등록. Application @MapperScan으로 대체 가능
public interface ReplyMapper {
	int insert(ReplyDTO reply);
	int update(ReplyDTO reply);
	int delete(int rno);
	List<ReplyDTO> getList(int bno);
	
	// 페이징 적용
	List<ReplyDTO> getListWithPage(ReplySearchDTO search);
	int getReplyCnt(int bno);
}
