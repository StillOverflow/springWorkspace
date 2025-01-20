package com.example.demo.vo;

import java.util.List;

import lombok.Data;

@Data
public class UserDTO {
	private Long id;
	private String loginId;
	private String password;
	private String fullName;
	private String deptName;
	
	// mapper에서 resultMap 적용
	private List<RoleDTO> roles;
}
