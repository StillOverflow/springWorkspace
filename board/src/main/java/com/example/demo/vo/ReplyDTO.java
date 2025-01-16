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
public class ReplyDTO {
	private Integer rno;
	private Integer bno; 
	
	// validation dependency 추가 이후 사용 가능 (Controller @Validated 함께 사용)
	@NotBlank(message="내용을 입력하세요.")
	private String reply;
	@NotBlank
	private String replyer;
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date replydate;
	private Date updatedate;
}
