package com.zyang25.sakila.repository;

import com.zyang25.sakila.entity.Customer;
import com.zyang25.sakila.entity.Payment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaymentRepository extends CrudRepository<Payment, Integer>{

    List<Payment> findByCustomer(Customer customer);
}
