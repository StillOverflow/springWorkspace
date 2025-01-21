package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentVO {
	private Integer bookNo;
	private String bookName;
	private Integer totalPrice;
	private Integer rentCnt;
}
