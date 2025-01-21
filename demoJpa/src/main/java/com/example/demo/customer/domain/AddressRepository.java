package com.example.demo.customer.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.customer.Address;

//@Repository // 생략 가능
// 아무것도 안 넣고 인터페이스 생성하는 것만으로 SQL 쿼리 기본 메소드 자동 생성됨.
public interface AddressRepository extends JpaRepository<Address, Long> { // <entity 클래스, PK 데이터 타입>
	
}
