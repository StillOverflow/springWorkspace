package com.example.demo.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder // setTitle();... 말고 체이닝 형식으로 사용 가능. builder().title().build();
@NoArgsConstructor // out of bind 오류 해결
@AllArgsConstructor
public class BoardDTO {
	private Integer rn; // cnt
	private Integer bno; // int : 원시적 자료형으로 null 오류 발생 (Integer 래퍼 클래스로 null 가능)
	
	// validation dependency 추가 이후 사용 가능 (Controller @Validated 함께 사용)
	@NotBlank(message="제목을 입력하세요.")
	private String title;
	@NotBlank(message="내용을 입력하세요.")
	private String content;
	@NotBlank
	private String writer;
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date regdate;
	private Date updatedate;
	
	private int replyCnt;
}
