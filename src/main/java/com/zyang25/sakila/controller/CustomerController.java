package com.zyang25.sakila.controller;

import com.zyang25.sakila.entity.Customer;
import com.zyang25.sakila.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers(){
        return (List<Customer>) customerRepository.findAll();
    }


    @GetMapping("/customer/{id}")
    public ResponseEntity getCustomer(@PathVariable(value = "id") int id){
        Customer customer = customerRepository.findOne(id);
        if(customer != null){
            return ResponseEntity.ok().body(customer);
        }

        return ResponseEntity.notFound().build();
    }
}
