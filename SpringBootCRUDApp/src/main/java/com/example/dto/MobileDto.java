package com.example.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class MobileDto {
	
	
	private Long id;
	private String name;
	private String brand;
	private BigDecimal price;

}
