package com.demo.dto;

import lombok.Data;

@Data
public class UserAccountDto {

	private Long accountId;
	private String bankName;
	private Long userId;
	private Float salary;
}
