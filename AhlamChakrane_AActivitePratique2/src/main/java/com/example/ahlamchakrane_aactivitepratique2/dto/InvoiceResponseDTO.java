package com.example.ahlamchakrane_aactivitepratique2.dto;

import java.math.BigDecimal;
import java.sql.Date;

import com.example.ahlamchakrane_aactivitepratique2.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class InvoiceResponseDTO {
	private String id;
	private Date date;
	private BigDecimal amount;
	private Customer customer;
}
