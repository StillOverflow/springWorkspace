package com.example.demo.control;

import java.util.List;

import lombok.Data;

@Data
public class GridData<T> {
	List<T> createdRows;
    List<T> deletedRows;
    List<T> updatedRows;
    //<T> 타입 설정하면 어떠한 것도 받을 수 있음. 
}
