package com.example.ahlamchakrane_aactivitepratique2.service;

import java.util.Date;

//metier

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.ahlamchakrane_aactivitepratique2.dto.InvoiceRequestDTO;
import com.example.ahlamchakrane_aactivitepratique2.dto.InvoiceResponseDTO;
import com.example.ahlamchakrane_aactivitepratique2.entities.Customer;
import com.example.ahlamchakrane_aactivitepratique2.entities.Invoice;
import com.example.ahlamchakrane_aactivitepratique2.exceptions.CustomerNotFoundException;
import com.example.ahlamchakrane_aactivitepratique2.mappers.InvoiceMapper;
import com.example.ahlamchakrane_aactivitepratique2.openfeign.CustomerRestClient;
import com.example.ahlamchakrane_aactivitepratique2.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {
	private InvoiceRepository invoiceRepository;
	private InvoiceMapper invoiceMapper;
	private CustomerRestClient customerRestClient;
	
	public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper, CustomerRestClient customerRestClient) {
		this.invoiceRepository = invoiceRepository;
		this.invoiceMapper = invoiceMapper;
		this.customerRestClient = customerRestClient;
	}
	@Override
	public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {
		Customer customer = null;
		try{
			customer = customerRestClient.getCustomer(invoiceRequestDTO.getCustomerId());
		} catch(Exception e) {
			throw new CustomerNotFoundException("CustomerNotFound");
		}
		Invoice invoice = invoiceMapper.invoiceRequestDTOInvoice(invoiceRequestDTO);
		invoiceRequestDTO.setCustomerId(UUID.randomUUID().toString());
		invoice.setDate(new Date());
		Invoice saveInvoice = invoiceRepository.save(invoice);
		InvoiceResponseDTO invoiceResponseDTO= invoiceMapper.invoiceToInvoiceResponseDTO(saveInvoice);
		saveInvoice.setCustomer(customer);
		return invoiceResponseDTO;
	}

	@Override
	public InvoiceResponseDTO getInvoice(String id) {
		Invoice invoice = invoiceRepository.findById(id).get();
		Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
		invoice.setCustomer(customer);
		return invoiceMapper.invoiceToInvoiceResponseDTO(invoice);
	}
	@Override
	public List<InvoiceResponseDTO> listInvoicesByCustomer(String customerId) {
		List<Invoice> invoices = invoiceRepository.findByCustomerId(customerId);
		for (Invoice invoice : invoices) {
			Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
			invoice.setCustomer(customer);
		}
		return invoices
					.stream()
					.map(inv -> invoiceMapper.invoiceToInvoiceResponseDTO(inv))
					.collect(Collectors.toList());
	}
	@Override
	public List<InvoiceResponseDTO> allInvoices() {
		List<Invoice> invoices = invoiceRepository.findAll();
		for (Invoice invoice : invoices) {
			Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
			invoice.setCustomer(customer);
		}
		return invoices.stream().map(inv -> invoiceMapper.invoiceToInvoiceResponseDTO(inv)).collect(Collectors.toList());
	}

}
