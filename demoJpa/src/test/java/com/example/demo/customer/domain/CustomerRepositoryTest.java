package com.example.demo.customer.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.customer.Address;
import com.example.demo.customer.Customer;
import com.example.demo.customer.domain.AddressRepository;
import com.example.demo.customer.domain.CustomerRepository;

import lombok.extern.slf4j.Slf4j;


@SpringBootTest
@Slf4j
public class CustomerRepositoryTest {
	
	@Autowired
	CustomerRepository repo;
	
	@Autowired
	AddressRepository addrepo;
	
//	@Test
	@DisplayName("고객등록")
//	@Transactional // @Rollback
	public void insert() {
		Customer customer = new Customer("박박박", "010-5666-6321");
		repo.save(customer); // insert (대용량 반복 등록 시 saveAll 등 사용 가능)
		
		addrepo.save(Address
				.builder()
				.address("대구")
				.customer(customer)
				.build());
		
		Optional<Address> addResult = addrepo.findById(1L);
		log.info("address 결과 : " + addResult.get().toString());
		
		// 등록한 고객 단건 조회
		Optional<Customer> result = repo.findById(customer.getId()); // Optional : null 오류를 방지하기 위한 Wrapper Class
		
		log.info("결과 : " + result.get()); // entity에 .toString() 안 넣으면 해시코드만 나옴.
		assertThat(result.get().getName()).isEqualTo(customer.getName());
	}
	
//	@Test
	@DisplayName("수정")
	public void update() {
		Optional<Customer> customer = repo.findById(52L);
		customer.get().setPhone("010-5555-5555");
		Customer result = repo.save(customer.get()); // Optional : null 오류를 방지하기 위한 Wrapper Class
		log.info("결과 : " + result); // 결과로 수정된 객체를 바로 반환함.
	}
	
	@Test
	@DisplayName("검색")
	public void searchName() {
		String name = "%홍%"; // like 적용
		List<Customer> result = repo.findByNameLike(name); // Optional : null 오류를 방지하기 위한 Wrapper Class
		log.info("결과 : " + result);
		
		// 폰 & 이름 검색
		List<Customer> result2 = repo.findByPhoneLikeAndNameLike("%010%", name);
		log.info("결과2 : " + result2);
		
		// 아이디 & 폰 검색
		List<Customer> result3 = repo.findByIdOrPhoneLike(52L, "%1%");
		log.info("결과3 : " + result3);
		
		// 아이디 검색 (@Query 사용)
		Optional<Customer> result4 = repo.findById(52L);
		log.info("결과4 : " + result4);
		
		// 아이디 or 이름 검색 (@Query 사용)
		Optional<Customer> result5 = repo.findByNameLikeOrId("%홍%", 52L);
		log.info("결과5 : " + result5);
	}
	
	
}
