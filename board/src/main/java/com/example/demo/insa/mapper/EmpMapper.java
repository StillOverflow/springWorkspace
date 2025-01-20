package com.example.demo.insa.mapper;

import java.util.List;

import com.example.demo.insa.service.EmpDTO;
import com.example.demo.insa.service.EmpSearchDTO;
import com.example.demo.insa.service.JobDTO;

public interface EmpMapper {
	List<EmpDTO> getList(EmpSearchDTO search);
	int getCount(EmpSearchDTO search);
	EmpDTO getEmp(String employeeId);
	List<JobDTO> getJobList();
	int register(EmpDTO emp);
}
