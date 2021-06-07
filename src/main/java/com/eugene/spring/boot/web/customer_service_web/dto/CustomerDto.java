package com.eugene.spring.boot.web.customer_service_web.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CustomerDto {

    private int id;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, message = "name must be min 2 symbols")
    private String name;
    @NotEmpty(message = "Surname should not be empty")
    private String surName;
    @Min(value = 1, message = "Age should be greater than 1")
    private int age;

    private AddressDto addressDto;


    public CustomerDto() {
    }

    public CustomerDto(String name, String surName, int age) {
        this.name = name;
        this.surName = surName;
        this.age = age;
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

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }
}
