package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.ReplyDTO;
import com.example.demo.vo.ReplySearchDTO;

public interface ReplyService {
	boolean register(ReplyDTO board);
	boolean modify(ReplyDTO board);
	boolean remove(int rno);
	List<ReplyDTO> getList(int bno);
	
	// 페이징 적용
	List<ReplyDTO> getListWithPage(ReplySearchDTO search);
	int getReplyCnt(int bno);
}
