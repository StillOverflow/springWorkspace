package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DepartmentsMapper {
	// interface는 모두 public 제한이므로 앞에 명시하지 않아도 됨.
	List<DepartmentsDTO> findAll();
//	EmployeesDTO findById(Long employeeId);
//	List<EmployeesDTO> findByDeptAndName(@Param("departmentId") Long departmentId, @Param("firstName") Long firstName);
}