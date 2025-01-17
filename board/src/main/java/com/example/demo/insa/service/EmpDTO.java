package com.example.demo.insa.service;

import java.util.Date;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Validated
public class EmpDTO {
	private String employeeId;
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@Email
	@NotNull
	private String email;
	private String phoneNumber;
	
	@NotNull
	private Date hireDate;
	@NotNull
	private String jobId;
	
	private Integer salary;
	private Double commissionPct;
	private String managerId;
	private String departmentId;
}
