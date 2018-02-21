package com.zyang25.sakila.service;

import com.zyang25.sakila.entity.Customer;
import com.zyang25.sakila.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomerById(int id){
        return customerRepository.findOne(id);
    }
}
