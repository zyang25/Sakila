package com.zyang25.sakila;

import com.zyang25.sakila.entity.Customer;
import com.zyang25.sakila.entity.Store;
import com.zyang25.sakila.repository.CustomerRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
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

	@BeforeEach
	void setUp() {
		store = new Store(1);

	}


	@Test
	public void contextLoads() {

		customer = new Customer(store, "Zihao","Yang", "zyang25@stevens.edu",3,1);
		Customer res = customerRepository.save(customer);
		assertThat(res).hasFieldOrPropertyWithValue("lastName", "Yang");
		assertThat(res).hasFieldOrPropertyWithValue("email", "zyang25@stevens.edu");

	}




}
