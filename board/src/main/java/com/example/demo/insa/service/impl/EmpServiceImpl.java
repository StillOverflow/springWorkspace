package com.example.demo.insa.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.insa.mapper.EmpMapper;
import com.example.demo.insa.service.EmpDTO;
import com.example.demo.insa.service.EmpSearchDTO;
import com.example.demo.insa.service.EmpService;
import com.example.demo.insa.service.JobDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService {
	
	private final EmpMapper mapper;

	@Override
	public List<EmpDTO> getList(EmpSearchDTO search) {
		return mapper.getList(search);
	}
	
	@Override
	public int getCount(EmpSearchDTO search) {
		return mapper.getCount(search);
	}

	@Override
	public List<JobDTO> getJobList() {
		return mapper.getJobList();
	}

	@Override
	public boolean register(EmpDTO emp) {
		return mapper.register(emp) > 0;
	}
	
}
