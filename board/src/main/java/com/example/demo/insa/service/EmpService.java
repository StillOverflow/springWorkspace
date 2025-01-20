package com.example.demo.insa.service;

import java.util.List;

public interface EmpService {
	List<EmpDTO> getList(EmpSearchDTO search);
	int getCount(EmpSearchDTO search);
	List<JobDTO> getJobList();
	EmpDTO getEmp(String employeeId);
	boolean register(EmpDTO emp);
}
