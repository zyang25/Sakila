package com.zyang25.sakila.controller;
import com.zyang25.sakila.entity.Customer;
import com.zyang25.sakila.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer/{id}")
    public ResponseEntity getCustomer(@PathVariable(value = "id") int id){
        Customer customer = customerService.getCustomerById(id);
        if(customer != null){
            return ResponseEntity.ok().body(customer);
        }

        return ResponseEntity.notFound().build();
    }
}
