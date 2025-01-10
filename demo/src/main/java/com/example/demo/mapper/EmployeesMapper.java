package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EmployeesMapper {
	// interface는 모두 public 제한이므로 앞에 명시하지 않아도 됨.
//	List<Map<String, Object>> findAll();
//	Map<String, Object> findById(Long employeeId);
//	List<Map<String, Object>> findByDeptAndName(@Param("departmentId") Long departmentId, @Param("firstName") Long firstName);
	
	// CamelCase 사용한 DTO 적용
	List<EmployeesDTO> findAll();
	EmployeesDTO findById(Long employeeId);
	List<EmployeesDTO> findByDeptAndName(@Param("departmentId") Long departmentId, @Param("firstName") Long firstName);
}