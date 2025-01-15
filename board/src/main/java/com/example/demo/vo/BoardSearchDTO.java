package com.example.demo.vo;

import lombok.Data;

@Data
public class BoardSearchDTO {
	// 페이징용
	int start;
	int end;
	
	Integer pageUnit;
	String keyword;
	String type;
	
	public String[] getTypeArr() {
		// T, C, W 검색조건들을 다중조건으로 쪼개어 배열로 동적 쿼리 처리하기 위함. (335p)
		return type == null ? new String[] {} : type.split("");
	}
}
