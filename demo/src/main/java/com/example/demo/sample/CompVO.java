package com.example.demo.sample;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class CompVO {
	private List<Ticket> list;
	private SampleVO sample;
	private int cnt;
	private Date regdate;
}
