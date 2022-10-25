
package com.example.ahlamchakrane_aactivitepratique2.mappers;

import com.example.ahlamchakrane_aactivitepratique2.dto.InvoiceRequestDTO;
import com.example.ahlamchakrane_aactivitepratique2.dto.InvoiceResponseDTO;
import com.example.ahlamchakrane_aactivitepratique2.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper{
	InvoiceResponseDTO invoiceToInvoiceResponseDTO(Invoice invoice);
	Invoice invoiceRequestDTOInvoice(InvoiceRequestDTO invoiceRequestDTO);
}
