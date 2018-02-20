package com.zyang25.sakila.repository;

import com.zyang25.sakila.entity.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer>{

}
