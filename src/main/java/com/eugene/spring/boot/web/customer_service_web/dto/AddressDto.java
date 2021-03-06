package com.eugene.spring.boot.web.customer_service_web.dto;

import javax.validation.constraints.NotEmpty;

public class AddressDto {

    private int id;
    @NotEmpty(message = "CityName should not be empty")
    private String cityName;
    @NotEmpty(message = "StreetName should not be empty")
    private String streetName;
    @NotEmpty(message = "HouseNumber should not be empty")
    private String houseNumber;

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

}
