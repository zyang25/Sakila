package com.zyang25.sakila.repository;

import com.sun.deploy.association.utility.AppUtility;
import com.zyang25.sakila.entity.Address;
import com.zyang25.sakila.entity.Customer;
import com.zyang25.sakila.entity.Store;

import org.hibernate.annotations.Synchronize;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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

    private int initSize;
    private Customer customer;
    private Store store;
    private Address address;

    @Before
    public void setUp() {
        initSize = (int) customerRepository.count();


        address = new Address();
        Address resAddress = entityManager.persist(address);
        Store resStore = entityManager.persist(store);


        customer = new Customer(resStore, "Zihao","Yang", "zyang25@stevens.edu",resAddress,1);
    }

    @Test
    public void whenFindByLastName_thenReturnCustomer() {

        //entityManager.persist(address);
        //entityManager.persist(store);
        //entityManager.flush();

        entityManager.persist(customer);
        entityManager.flush();
        assertThat(customerRepository.count()).isEqualTo(initSize+1);
    }


    @Test
    public void when_findAll_then_returnEmployees(){

    }

    @Test
    public void when_findCustomerNotExist_then_returnNull(){

        Customer customer = customerRepository.findOne(initSize+1);
        assertThat(customer).isNull();
    }

    @Test
    public void when_findCustomerWhoPayTheMost_then_returnCustomer(){
        Query q = entityManager.getEntityManager().createQuery("select customer_id from payment");
        //Query q = entityManager.getEntityManager().createQuery("select customer_id from payment p group by customer_id");
        //Object o = q.getResultList().get(0);
        //System.out.println(o.toString());
    }

}