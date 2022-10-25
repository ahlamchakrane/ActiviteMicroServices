package com.example.ahlamchakrane_aactivitepratique2.dto;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class InvoiceRequestDTO {
	private BigDecimal amount;
	private String customerId;
}
