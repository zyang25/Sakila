package com.zyang25.sakila.repository;
import com.zyang25.sakila.entity.Customer;
import com.zyang25.sakila.entity.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

    List<Customer> findByLastName(String lastName);

}
