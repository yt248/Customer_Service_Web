package com.eugene.spring.boot.web.customer_service_web.model.dto;

import com.eugene.spring.boot.web.customer_service_web.model.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class AddressDto {

    private int id;
    private String cityName;
    private String streetName;
    private String houseNumber;
    private List<Customer> customerDtoList = new ArrayList<>();

    public AddressDto() {
    }

    public AddressDto(String cityName, String streetName, String houseNumber) {
        this.cityName = cityName;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public List<Customer> getCustomerDtoList() {
        return customerDtoList;
    }

    public void setCustomerDtoList(List<Customer> customerDtoList) {
        this.customerDtoList = customerDtoList;
    }
}
