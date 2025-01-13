package com.example.demo.dept;

import lombok.Builder;
import lombok.Data;

@Data
@Builder // 오버로딩과 다르게 빌더 클래스(체이닝 형식의 별도 생성자 클래스)를 쉽게 만들어줌.
public class DepartmentsDTO {
	private String departmentId;
	private String departmentName;
	private String managerId;
	private String locationId;
}
