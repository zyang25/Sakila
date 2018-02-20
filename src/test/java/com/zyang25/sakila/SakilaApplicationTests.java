package com.zyang25.sakila;

import com.zyang25.sakila.entity.Address;
import com.zyang25.sakila.entity.Customer;
import com.zyang25.sakila.entity.Store;
import com.zyang25.sakila.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SakilaApplicationTests {

	// mock bean vs auto wired
	@Autowired
	CustomerRepository customerRepository;

	private Customer customer;
	private Store store;

	@Before
	public void setUp() {
	    Address address = new Address();

		store = new Store(1);
        customer = new Customer(store, "Zihao","Yang", "zyang25@stevens.edu",address,1);
	}

    @Test
	public void contextLoads() {


		Customer res = customerRepository.save(customer);
		assertThat(res).hasFieldOrPropertyWithValue("lastName", "Yang");
		assertThat(res).hasFieldOrPropertyWithValue("email", "zyang25@stevens.edu");

	}




}
