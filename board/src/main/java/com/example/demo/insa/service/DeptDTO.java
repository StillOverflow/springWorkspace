package com.example.demo.insa.service;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeptDTO {
	private String departmentId;
	private String departmentName;
	private String managerId;
	private String locationId;
}
