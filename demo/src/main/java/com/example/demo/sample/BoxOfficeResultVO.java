package com.example.demo.sample;

import lombok.Data;

// 과제 : 영화정보 받아서 DB테이블에 등록하기
@Data
public class BoxOfficeResultVO {
	private String boxofficeType;
	private String showRange;
	private DailyBoxOfficeVO dailyBoxOfficeList;
}
