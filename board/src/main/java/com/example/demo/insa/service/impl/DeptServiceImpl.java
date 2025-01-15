package com.example.demo.insa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.insa.mapper.DeptMapper;
import com.example.demo.insa.service.DeptDTO;
import com.example.demo.insa.service.DeptSearchDTO;
import com.example.demo.insa.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	DeptMapper mapper;
	
	@Override
	public List<DeptDTO> getList() {
		return mapper.getList();
	}

	@Override
	public DeptDTO get(DeptSearchDTO search) {
		return mapper.read(search);
	}
	
}
