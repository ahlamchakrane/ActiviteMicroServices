package ma.enset.ahlamchakrane_activitepratique1.web;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.enset.ahlamchakrane_activitepratique1.dto.CustomerRequestDTO;
import ma.enset.ahlamchakrane_activitepratique1.dto.CustomerResponseDTO;
import ma.enset.ahlamchakrane_activitepratique1.service.CustomerService;

@RestController
@RequestMapping(path = "/api")
public class CustomerRestAPI {
	private CustomerService customerService;
	public CustomerRestAPI(CustomerService customerService) {
		this.customerService = customerService;
	}
	@GetMapping(path = "/customers")
	public List<CustomerResponseDTO> allCustomers(){
		return customerService.listCustomers();
	}
	@PostMapping(path = "/customers")
	public CustomerResponseDTO save(@RequestBody CustomerRequestDTO customerRequestDTO) {
		customerRequestDTO.setId(UUID.randomUUID().toString());
		return customerService.save(customerRequestDTO);
	}
	@GetMapping(path = "/customers/{id}")
	public CustomerResponseDTO getCustomer(@PathVariable String id) {
		return customerService.getCustomer(id);
	}
	
}
