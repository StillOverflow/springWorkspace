package com.example.demo.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter 
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String zipcode;
	private String address;
	private String detailAddress;
	
	@OneToOne // 단방향 1:1 연관관계 생성 (address가 customer를 참조하여 FK 가지는 형태)
	@JoinColumn(name = "customer_id") // address 테이블에 customer_id FK 컬럼 생성됨.
	Customer customer; // JPA에서는 참조하는 객체 자체를 함께 조회함.

	@Override
	public String toString() {
		return "Address [id=" + id + ", zipcode=" + zipcode + ", address=" + address + ", detailAddress="
				+ detailAddress + ", customer=" + customer + "]";
	}
	
}
