
package ma.enset.ahlamchakrane_activitepratique1.mappers;

import org.mapstruct.Mapper;

import ma.enset.ahlamchakrane_activitepratique1.dto.CustomerRequestDTO;
import ma.enset.ahlamchakrane_activitepratique1.dto.CustomerResponseDTO;
import ma.enset.ahlamchakrane_activitepratique1.entities.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper{
	CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
	Customer customerRequestDTOCustomer(CustomerRequestDTO customerRequestDTO);
}
