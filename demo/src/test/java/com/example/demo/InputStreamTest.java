package com.example.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import jakarta.servlet.http.HttpServletResponse;

public class InputStreamTest {
//	@Test
	@DisplayName("파일입력")
	public void test1() throws IOException {
//		FileWriter fw = new FileWriter("C:/Temp/data.txt");
//		fw.write("happy"); // "happy" 내용의 파일이 생성됨.
//		fw.close();
		
		// 키보드 입력을 파일로 저장
		FileOutputStream fo = new FileOutputStream("C:/Temp/data.txt");
		int readByte;
		while((readByte = System.in.read()) != -1) {
			fo.write(readByte);
		}
		fo.close();
	}
	
	@Test
	@DisplayName("파일읽기")
	public void test2() throws IOException { // 실제 Controller 통해 파일 다운로드 시 HttpServletResponse 및 getOutputStream().write 추가
		FileInputStream fi = new FileInputStream("C:/Temp/data.txt");
		FileOutputStream fo = new FileOutputStream("C:/Temp/dataout.txt"); // input 읽어서 output으로 복사
		int readByte;
		// response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE); // 실제 Controller 사용 시 
		while((readByte = fi.read()) != -1) { // System.in.read() == fi.read() 기본 입력장치인 키보드 읽어오는 것 똑같음.
			System.out.print((char)readByte); // 타입 캐스팅 안 해주면 int 값 그대로 (115...) 숫자 나옴.
			fo.write(readByte);
		}
		fi.close();
		fo.close();
	}
}
