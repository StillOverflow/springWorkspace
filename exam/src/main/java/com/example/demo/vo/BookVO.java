package com.example.demo.vo;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookVO {
	
	private Integer bookNo;
	
	@NotBlank(message="도서명이 입력되지 않았습니다.")
	private String bookName;
	
	private String bookCoverimg;
	private Date bookDate;
	private String bookDateStr;
	
	@PositiveOrZero(message="숫자로 입력해주세요.") // 숫자만 입력하기 위함 (오류가 그대로 출력되는 현상...)
	private Integer bookPrice;
	
	private String bookPublisher;
	private String bookInfo;

}
