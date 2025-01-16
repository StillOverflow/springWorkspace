package com.example.demo.sample;

import java.util.Date;

import lombok.Data;

// 과제 : 영화정보 받아서 DB테이블에 등록하기
@Data
public class DailyBoxOfficeVO {
	private String rnum;
	private int rank;
	private int rankInten;
	private String rankOldAndNew;
	private String movieCd;
	private String movieNm;
	private Date openDt;
	private String salesAmt;
	private double salesShare;
	private double salesInten;
	private double salesChange;
	private String salesAcc;
	private int audiCnt;
	private int audiInten;
	private int audiChange;
	private String audiAcc;
	private int scrnCnt;
	private int showCnt;
}
