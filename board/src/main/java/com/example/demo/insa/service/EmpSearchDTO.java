package com.example.demo.insa.service;

import lombok.Data;

@Data
public class EmpSearchDTO {
	// 페이징용
	private int start;
	private int end;
	
	private String keyword;
	private String type;
	private int pageUnit;
}
