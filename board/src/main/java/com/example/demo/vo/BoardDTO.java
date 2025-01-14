package com.example.demo.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder // setTitle();... 말고 체이닝 형식으로 사용 가능. builder().title().build();
public class BoardDTO {
	private Integer bno; // int : 원시적 자료형으로 null 오류 발생 (Integer 래퍼 클래스로 null 가능)
	private String title;
	private String content;
	private String writer;
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date regdate;
	private Date updatedate;
}
