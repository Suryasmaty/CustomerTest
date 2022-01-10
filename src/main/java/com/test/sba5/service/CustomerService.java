package com.test.sba5.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.sba5.entity.Customer;
import com.test.sba5.repository.CustomerRepository;


@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repo;
	
	public Customer saveUser(Customer customer)
	{
		return repo.save(customer);
	}
	
	public Optional<Customer> getCustomerById(int id)
	{
		return repo.findById(id);
		
	}
	
	public List<Customer> getAllCustomers()
	{
		return repo.findAll();
		
	}
	
	public void deleteCustomer(Customer customer)
	{
		repo.delete(customer);
	}
	
	
	

}
