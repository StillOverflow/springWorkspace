package com.example.demo.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

// JPA 테스트
// CRUD 및 페이징, 검색 등 SQL 자동 생성. 비즈니스 로직 개발에 집중할 수 있게 함.

@Getter // JPA 사용 시 lombok 무분별한 사용 주의! 도메인에 Setter 쓰면 안 됨.
@NoArgsConstructor
@Entity
//@Table(name = "CUSTOMER")
public class Customer {
	
	// Jakarta
	@Id // PK (기본키)
	// GeneratedValue : 자동생성값으로 시퀀스 적용 (기본값 increment 50), MySQL에서는 AUTO 쓰면 됨.
	@GeneratedValue(strategy = GenerationType.SEQUENCE) 
	private Long id;
	
//	@Column(name = "username", length = 50, nullable = false) // ddl update 가능하나, 컬럼명 바꿀 시 지우고 새로 생성해야 함.
	private String name;
	
//	@Transient // create 시 제외할 컬럼
	private String phone;
	
//	@OneToOne(mappedBy = "customer") // 양방향 매핑 시 (이대로는 순환참조 stackOverflow 에러 발생)
//	Address address;
	
	
	public Customer(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
	
	// 수정하려면 Setter 일부 필요
	public void setPhone(String phone) {
		this.phone = phone;
	}

	// toString 없으면 해쉬코드로 나와서 해석할 수 없음
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
		
}

