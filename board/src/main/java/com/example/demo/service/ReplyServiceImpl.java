package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.mapper.ReplyMapper;
import com.example.demo.vo.ReplyDTO;
import com.example.demo.vo.ReplySearchDTO;

import lombok.Data;

@Service
@Data
public class ReplyServiceImpl implements ReplyService {
	
	final ReplyMapper mapper;
	
	@Override
	public boolean register(ReplyDTO board) {
		return mapper.insert(board) > 0;
	}

	@Override
	public boolean modify(ReplyDTO board) {
		return mapper.update(board) > 0;
	}

	@Override
	public boolean remove(int rno) {
		return mapper.delete(rno) > 0;
	}

	@Override
	public List<ReplyDTO> getList(int bno) {
		return mapper.getList(bno);
	}

	@Override
	public int getReplyCnt(int bno) {
		return mapper.getReplyCnt(bno);
	}

	@Override
	public List<ReplyDTO> getListWithPage(ReplySearchDTO search) {
		return mapper.getListWithPage(search);
	}

	@Override
	public boolean removeByBno(int rno) {
		return mapper.deleteByBno(rno) > 0;
	}

	@Override
	public String getRecentRno() {
		return mapper.getRecentRno();
	}
}
