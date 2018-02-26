package com.zyang25.sakila.controller;
import com.zyang25.sakila.entity.Customer;
import com.zyang25.sakila.entity.Payment;
import com.zyang25.sakila.service.CustomerService;
import com.zyang25.sakila.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/customer/{id}")
    public ResponseEntity getCustomer(@PathVariable(value = "id") int id){
        Customer customer = customerService.getCustomerById(id);
        if(customer != null){

            for(Payment payment : customer.getPaymentList()){
                System.out.println(payment.toString());
            }

            return ResponseEntity.ok().body(customer);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/customer/{id}/payments")
    public ResponseEntity getCustomerPayment(@PathVariable(value = "id") int id){
        List<Payment> payments = paymentService.findPaymentsByCustomerId(id);
        if(payments.size() > 0){
            return ResponseEntity.ok().body(payments);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
