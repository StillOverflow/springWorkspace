package com.example.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LambdaTest {
	@Test
	public void sort() { // .sort 메소드 : 정렬 (원본 변경)
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Collections.sort(list);
		log.info(list.toString());
		
		
		List<SampleVO> list2 = Arrays.asList(
				new SampleVO("홍길동", 29),
				new SampleVO("박거거", 30),
				new SampleVO("라라", 15)
				);
		// Comparator(비교조건) 두 번째 인자를 클래스로 넘겨야 함.
		// 익명 클래스 사용
		Collections.sort(list2, new SampleCompare());
		
		log.info(list2.toString());
	}
	
	@Data
	@AllArgsConstructor
	public class SampleVO {
		private String name;
		private int age;
	}
	
	class SampleCompare implements Comparator<SampleVO> {
		@Override
		public int compare(SampleVO s1, SampleVO s2) {
			return s1.getName().compareTo(s2.getName());
		}
	}
	
}
