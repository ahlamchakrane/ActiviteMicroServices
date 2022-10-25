package com.example.ahlamchakrane_aactivitepratique2.web;

import java.util.List;

import com.example.ahlamchakrane_aactivitepratique2.dto.InvoiceRequestDTO;
import com.example.ahlamchakrane_aactivitepratique2.dto.InvoiceResponseDTO;
import com.example.ahlamchakrane_aactivitepratique2.service.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class InvoiceRestAPI {
	private InvoiceService invoiceService;
	
	public InvoiceRestAPI(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}
	@GetMapping(path = "/invoices/{id}")
	public InvoiceResponseDTO getInvoice(@PathVariable(name = "id") String id) {
		return invoiceService.getInvoice(id);
	}
	
	@GetMapping(path = "/invoicesByCustomer/{customerId}")
	public List<InvoiceResponseDTO> allInvoicesByCustomer(String customerId){
		return invoiceService.listInvoicesByCustomer(customerId);
	}
	@PostMapping(path = "/invoices")
	public InvoiceResponseDTO save(@RequestBody InvoiceRequestDTO invoiceRequestDTO) {
		return invoiceService.save(invoiceRequestDTO);
	}

	@GetMapping(path = "/invoices")
	public List<InvoiceResponseDTO> allInvoices() {
		return invoiceService.allInvoices();
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> expentionHandler(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
	
	
	
}
