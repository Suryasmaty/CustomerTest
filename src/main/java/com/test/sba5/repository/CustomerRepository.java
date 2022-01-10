package com.test.sba5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.sba5.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
