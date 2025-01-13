package com.example.demo.di;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SampleDtoList {
	// 133p 파라미터로 객체 타입을 여러 개 전달받을 때 List클래스 설정
	List<SampleDto> list = new ArrayList<>();
}
