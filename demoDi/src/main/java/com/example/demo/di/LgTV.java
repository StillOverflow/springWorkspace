package com.example.demo.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

//@Data // lombok 생성자 및 Setter
@RequiredArgsConstructor // final 붙은 인스턴스 변수에 대한 생성자 주입 (@Data 와 택1)
//@NoArgsConstructor
//@AllArgsConstructor
@Component
public class LgTV implements TV {
	// 스프링 프레임워크에서 의존성 주입(DI) 방법 3가지
	
	// 1. 필드 주입하면 (간편 - TV 생성 시 Speaker도 생성자 실행됨.)
//	@Autowired Speaker speaker;
	@Autowired final Speaker speaker;
	
	// 2. Setter (수정자) 주입
//	public void setSpeaker(Speaker speaker) {
//		System.out.println("수정자 주입 Setter Injection");
//		this.speaker = speaker;
//	}
	
	// 3. 생성자 주입 (권장 - A=>B, B=>A 꼬이는 경우 순환 참조 방지됨.)
//	public LgTV(Speaker speaker) {
//		System.out.println("생성자 주입 Construction Injection");
//		this.speaker = speaker;
//	}
	
	
	public void powerOn() {
		System.out.println("LG TV--전원 on");
	}
	public void powerOff() {
		System.out.println("LG TV--전원 off");
	}
	public void volumeUp() {
		System.out.println("LG TV--볼륨 up");
	}
	public void volumeDown() {
		System.out.println("LG TV--볼륨 down");
	}	
}
