package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.BookVO;
import com.example.demo.vo.RentVO;

public interface BookService {
	
	boolean bookRegiester(BookVO book);
	Integer getBookSeq();
	List<BookVO> getBookList();
	List<RentVO> getRentCurrent();
	
}
