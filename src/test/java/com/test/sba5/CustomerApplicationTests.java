package com.test.sba5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.tomcat.jni.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import com.test.sba5.entity.Customer;
import com.test.sba5.repository.CustomerRepository;
import com.test.sba5.service.CustomerService;


@RunWith(SpringRunner.class)
@SpringBootTest
class CustomerApplicationTests {
	@BeforeAll
	//To use before all the function should be static 
	public static void hai()
	{
		System.out.println("haiii");
	}
	
	public static Logger logger = LoggerFactory.getLogger(CustomerApplicationTests.class);
	
	@Autowired
	private CustomerService service=mock(CustomerService.class);
	
	@MockBean
	private CustomerRepository repository;
	
	
	@Test
	public void saveCustomerTest() {
		logger.info("save Customer test executing");
		Customer customer = new Customer(1, "surya", "male",25,"veg");
		
		when(repository.save(customer)).thenReturn(customer);
		assertThat(customer.getId()).isGreaterThan(0);
		assertEquals(customer, service.saveUser(customer));
	}
	
	@Test
	public void getCustomerByIdTest()
	{
		logger.info("Get Customer by Id test executing");
		int id=1;
		Optional<Customer> customer = Optional.ofNullable(new Customer(1, "surya", "male",25,"veg"));
		when(repository.findById(id)).thenReturn(customer);
		assertEquals(customer,service.getCustomerById(id));
	}
	
	@Test
	public void getAllCustomersTest() {
		logger.info("Get All Customers test executing");
		when(repository.findAll()).thenReturn(Stream
				.of(new Customer(2, "teja", "male",26,"veg"), 
						new Customer(2, "kiran", "male",23,"non-veg"))
				.collect(Collectors.toList()));
		Assertions.assertFalse(service.getAllCustomers().isEmpty());
		assertEquals(2, service.getAllCustomers().size());
	}
	
	@Test
	public void deleteUserTest() {
		logger.info("Delete Customers test executing");
		Customer customer = new Customer(1, "surya", "male",25,"veg");
		service.deleteCustomer(customer);;
		verify(repository, times(1)).delete(customer);
	}
	
	@AfterEach
    public void tearDown() {
        System.out.println("Should Execute After Each Test");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("Should be executed at the end of the Test");
    }
	

}
