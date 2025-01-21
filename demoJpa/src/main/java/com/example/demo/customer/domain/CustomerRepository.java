package com.example.demo.customer.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.customer.Customer;

//@Repository // 생략 가능
// 아무것도 안 넣고 인터페이스 생성하는 것만으로 SQL 쿼리 기본 메소드 자동 생성됨.
public interface CustomerRepository extends JpaRepository<Customer, Long> { // <entity 클래스, PK 데이터 타입>
	
	@Query("select c from Customer c where id = ?1 order by name desc") // alias 그냥 적으면 * 조회
	public Optional<Customer> findById(Long id); // Optional : null 오류 방지를 위한 Wrapper 
	
	@Query("select c from Customer c where name like ?1 or id = ?2 ")
	public Optional<Customer> findByNameLikeOrId(@Param("n") String n, @Param("id") Long id); // 파라미터 여러 개면 @Param 사용
	
	// 참고 : https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
	// findBy~ 등 규칙에 맞춰 메소드 이름 작성하면 JPA에서 자동으로 검색 쿼리 생성 (인수도 같은 개수로 있어야 함.)
	public List<Customer> findByNameLike(String name); 
	public List<Customer> findByPhoneLikeAndNameLike(String phone, String name);
	public List<Customer> findByIdOrPhoneLike(Long id, String phone);
	
	
}
