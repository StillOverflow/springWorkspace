package com.example.demo;

import java.io.File;

import org.junit.jupiter.api.Test;

// Reporting Tool (.Jasper 파일) 사용 전 File 객체 테스트
public class FileTest {
	@Test
	public void fileTest() {
//		File file = new File("C:/Temp/a.txt"); // Temp에 있는 파일을 읽을 수 있음.
//		System.out.println(file.length());
//		// file.delete(); // 삭제
//		
//		File folder = new File("C:/Temp/txt");
//		folder.mkdir(); // 폴더 생성
		
		// 폴더 목록
		File usersFile = new File("C:/Users");
		String[] list = usersFile.list(); // 배열로 반환
		for(String str : list) {
			System.out.println(str);
		}
	}
}
