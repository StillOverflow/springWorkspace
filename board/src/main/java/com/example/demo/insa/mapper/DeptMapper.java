package com.example.demo.insa.mapper;

import java.util.List;

import com.example.demo.insa.service.DeptDTO;
import com.example.demo.insa.service.DeptSearchDTO;

public interface DeptMapper {
	List<DeptDTO> getList();
	DeptDTO read(DeptSearchDTO search);
}
