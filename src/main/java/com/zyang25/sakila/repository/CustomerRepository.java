package com.zyang25.repository;
import com.zyang25.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{
    List<Customer> findByLastName(String lastName);
}