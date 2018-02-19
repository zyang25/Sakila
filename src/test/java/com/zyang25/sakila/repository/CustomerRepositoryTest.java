package com.zyang25.sakila.repository;

import com.zyang25.sakila.entity.Customer;
import com.zyang25.sakila.entity.Store;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test customer repository
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;

    private long initSize;
    private Customer customer;
    private Store store;

    @Before
    public void setUp() {
        initSize = customerRepository.count();
        store = new Store(1);
        customer = new Customer(store, "Zihao","Yang", "zyang25@stevens.edu",3,1);
    }

    @Test
    public void whenFindByLastName_thenReturnCustomer() {

        entityManager.persist(store);
        entityManager.flush();
        entityManager.persist(customer);
        entityManager.flush();
        assertThat(customerRepository.count()).isEqualTo(initSize+1);
        //assertThat(res).hasFieldOrPropertyWithValue("lastName", "Yang");
        //   assertThat(res).hasFieldOrPropertyWithValue("email", "zyang25@stevens.edu");

//        entityManager.persist(store);
//        entityManager.persist(customer);
//        entityManager.flush();
//
//        List<Customer> customer = customerRepository.findByLastName("Yang");
//
//        assertThat(customer.size()).isEqualTo(2);
//
//        assertThat(customer.get(0)).hasFieldOrPropertyWithValue("lastName", "Yang");
    }



}