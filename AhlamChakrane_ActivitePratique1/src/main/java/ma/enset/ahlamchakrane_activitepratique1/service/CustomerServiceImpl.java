package ma.enset.ahlamchakrane_activitepratique1.service;

//metier

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.enset.ahlamchakrane_activitepratique1.dto.CustomerRequestDTO;
import ma.enset.ahlamchakrane_activitepratique1.dto.CustomerResponseDTO;
import ma.enset.ahlamchakrane_activitepratique1.entities.Customer;
import ma.enset.ahlamchakrane_activitepratique1.mappers.CustomerMapper;
import ma.enset.ahlamchakrane_activitepratique1.repositories.CustomerRepository;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	private CustomerRepository customerRepository;
	private CustomerMapper customerMapper;
	public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
	}
	@Override
	public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
		/* code lourd
		//maping objet objet
		Customer customer = new Customer();
		customer.setId(customerRequestDTO.getId());
		customer.setName(customerRequestDTO.getName());
		customer.setEmail(customerRequestDTO.getEmail());
		*/
		Customer customer = customerMapper.customerRequestDTOCustomer(customerRequestDTO);
		Customer saveCustomer = customerRepository.save(customer);
		//maping objet objet
		/*CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
		customerResponseDTO.setId(saveCustomer.getId());
		customerResponseDTO.setName(saveCustomer.getName());
		customerResponseDTO.setEmail(saveCustomer.getEmail());
		*/
		CustomerResponseDTO customerResponseDTO= customerMapper.customerToCustomerResponseDTO(saveCustomer);
		return customerResponseDTO;
	}

	@Override
	public CustomerResponseDTO getCustomer(String id) {
		Customer customer = customerRepository.findById(id).get();
		return customerMapper.customerToCustomerResponseDTO(customer);
	}

	@Override
	public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
		Customer customer = customerMapper.customerRequestDTOCustomer(customerRequestDTO);
		Customer updateCustomer = customerRepository.save(customer);
		return customerMapper.customerToCustomerResponseDTO(updateCustomer);
	}

	@Override
	public List<CustomerResponseDTO> listCustomers() {
		List<Customer> customers = customerRepository.findAll();
		List<CustomerResponseDTO> customerResponseDTOs = 
				customers.stream()
					.map(cust -> customerMapper.customerToCustomerResponseDTO(cust))
					.collect(Collectors.toList());
		return customerResponseDTOs;
	}


}
