package com.zyang25.sakila.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int city_id;

    private String city;

    @OneToOne
    @JoinColumn(name = "country_id")
    private Country country;

    private Date last_update;

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    protected City(){}

    public City(String city, Country country) {
        this.city = city;
        this.country = country;
    }
}
