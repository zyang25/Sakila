package com.zyang25.sakila;

import com.zyang25.sakila.entity.Customer;
import com.zyang25.sakila.entity.Store;
import com.zyang25.sakila.repository.CustomerRepository;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {


    @Autowired
    private CustomerRepository customerRepository;

    private Customer customer;
    private Store store;

    @BeforeEach
    void setUp() {
        store = new Store(1);

    }

    @Test
    public void whenFindByLastName_thenReturnCustomer() {
        customer = new Customer(store, "Zihao","Yang", "zyang25@stevens.edu",3,1);
        Customer res = customerRepository.save(customer);
        assertThat(res).hasFieldOrPropertyWithValue("lastName", "Yang");
        assertThat(res).hasFieldOrPropertyWithValue("email", "zyang25@stevens.edu");

    }
}