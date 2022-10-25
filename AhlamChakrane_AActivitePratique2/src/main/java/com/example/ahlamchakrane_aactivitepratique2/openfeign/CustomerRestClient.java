package com.example.ahlamchakrane_aactivitepratique2.openfeign;

import java.util.List;

import com.example.ahlamchakrane_aactivitepratique2.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "CUSTOMER-SERVICE") 
public interface CustomerRestClient {
	
	@GetMapping(path = "/api/customers/{id}")
	Customer getCustomer(@PathVariable(name = "id") String id);
	
	@GetMapping(path = "/api/customers")
	List<Customer> allCustomers();
}
