package com.eugene.spring.boot.web.customer_service_web.model.dto;

import com.eugene.spring.boot.web.customer_service_web.model.entity.Address;

public class CustomerDto {

    private int id;
    private String name;
    private String surName;
    private int age;
    private String gender;
    private Address address;

    public CustomerDto() {
    }

    public CustomerDto(String name, String surName, int age, String gender) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
