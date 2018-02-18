package com.zyang25.sakila;

import com.zyang25.sakila.entity.Customer;
import com.zyang25.sakila.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SakilaApplication {

	private static final Logger log = LoggerFactory.getLogger(SakilaApplication.class);

	public static void main(String[] args) {
	    SpringApplication.run(SakilaApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner demo(){
//		return(args) ->{
//			log.info("Application info");
//			log.debug("Application debug");
//            Customer customer = customerRepository.findOne(1);
//            log.info(customer.toString());
//		};
//	}
}
