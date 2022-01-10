package com.test.sba5.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.sba5.entity.Customer;
import com.test.sba5.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	
	@PostMapping("/saveCustomer")
	public Customer saveCustomer(@RequestBody Customer customer)
	{
		return service.saveUser(customer);
	}
	
	@GetMapping("/getCustomers")
	public List<Customer> getAllCustomers()
	{
		return service.getAllCustomers();
	}
	
	@GetMapping("/getCustomerById/{id}")
	public Optional<Customer> getCustomerById(@RequestParam int id)
	{
		return service.getCustomerById(id);
	}
	

}
