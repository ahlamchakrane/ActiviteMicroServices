package com.example.ahlamchakrane_aactivitepratique2.service;
//metier

import com.example.ahlamchakrane_aactivitepratique2.dto.InvoiceRequestDTO;
import com.example.ahlamchakrane_aactivitepratique2.dto.InvoiceResponseDTO;

import java.util.List;

public interface InvoiceService {
	InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO);
	InvoiceResponseDTO getInvoice(String invoiceId);
	List<InvoiceResponseDTO>  listInvoicesByCustomer(String customerId);
	List<InvoiceResponseDTO> allInvoices();
}
