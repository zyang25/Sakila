package com.zyang25.sakila.service;

import com.zyang25.sakila.entity.Customer;
import com.zyang25.sakila.entity.Payment;
import com.zyang25.sakila.repository.CustomerRepository;
import com.zyang25.sakila.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Payment> findPaymentsByCustomerId(int id){
        Customer customer = customerRepository.findOne(id);
        return paymentRepository.findByCustomer(customer);
    }
}
