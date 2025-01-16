package com.example.demo.sample;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SampleVO {
	
	// Jackson(Json 라이브러리)
	@JsonIgnore // mno는 생략하고 출력
	private int mno;
	
	@JsonProperty("fname") // firstName => fanme 표시형식 바꿀 수 있음
	private String firstName;
	private String lastName;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date regdate;
}
