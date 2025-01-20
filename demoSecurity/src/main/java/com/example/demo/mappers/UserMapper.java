package com.example.demo.mappers;

import java.util.List;

import com.example.demo.vo.RoleDTO;
import com.example.demo.vo.UserDTO;

public interface UserMapper {
	UserDTO getUser(String loginId);
	List<RoleDTO> getRole(long id);
	int updatePw(UserDTO user);
}