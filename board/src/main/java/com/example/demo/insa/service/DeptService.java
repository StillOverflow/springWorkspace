package com.example.demo.insa.service;

import java.util.List;

public interface DeptService {
	List<DeptDTO> getList();
	DeptDTO get(DeptSearchDTO search);
}
