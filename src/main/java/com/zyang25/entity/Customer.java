package com.zyang25.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customer_id;

    @OneToMany
    @JoinColumn(name = "store_id")
    private Store store;

    private String first_name;

    private String last_name;

    private String email;

    private int address_id;

    private int active;

    private Date create_date;

    private Date last_update;

}
