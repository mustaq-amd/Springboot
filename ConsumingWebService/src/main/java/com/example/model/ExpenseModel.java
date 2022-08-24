package com.example.model;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.Data;


@Data
public class ExpenseModel {
	
	private Long id;

	private String name;

	private String description;

	private BigDecimal amount;

	private String category;

	private Date date;


}
