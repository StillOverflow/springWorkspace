package com.example.demo.insa.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Validated
public class EmpDTO {
	private String employeeId;
	private String firstName;
	
	@NotNull
//	@NotBlank
	private String lastName;
	
	@Email
	@NotNull
	private String email;
	private String phoneNumber;
	
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd") // 입력 시 변환
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") // 응답 시 변환
	private Date hireDate;
	@NotNull
	private String jobId;
	
	private Integer salary;
	private Double commissionPct;
	private String managerId;
	private String departmentId;
}
