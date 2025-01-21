package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mappers.BookMapper;
import com.example.demo.vo.BookVO;
import com.example.demo.vo.RentVO;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookMapper mapper;

	@Override
	public boolean bookRegiester(BookVO book) {
		return mapper.insertBook(book) > 0;
	}
	
	@Override
	public Integer getBookSeq() {
		return mapper.getBookSeq();
	}

	@Override
	public List<BookVO> getBookList() {
		return mapper.getBookList();
	}

	@Override
	public List<RentVO> getRentCurrent() {
		return mapper.getRentCurrent();
	}
	
}
