package ma.enset.ahlamchakrane_activitepratique1.service;
//metier

import java.util.List;

import ma.enset.ahlamchakrane_activitepratique1.dto.CustomerRequestDTO;
import ma.enset.ahlamchakrane_activitepratique1.dto.CustomerResponseDTO;

public interface CustomerService {
	CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
	CustomerResponseDTO getCustomer(String id);
	CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
	List<CustomerResponseDTO>  listCustomers();

}
