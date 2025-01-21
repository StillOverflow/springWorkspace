package com.example.demo.mappers;

import java.util.List;

import com.example.demo.vo.BookVO;
import com.example.demo.vo.RentVO;

public interface BookMapper {
	
	int insertBook(BookVO book);
	Integer getBookSeq();
	List<BookVO> getBookList();
	List<RentVO> getRentCurrent();
	
}
