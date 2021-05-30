package com.eugene.spring.boot.web.customer_service_web.dto.mappers;

import com.eugene.spring.boot.web.customer_service_web.dto.AddressDto;
import com.eugene.spring.boot.web.customer_service_web.entity.Address;

public class AddressMapper {

    public static AddressDto toDto(Address entity) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(entity.getId());
        addressDto.setCityName(entity.getCityName());
        addressDto.setStreetName(entity.getStreetName());
        addressDto.setHouseNumber(entity.getHouseNumber());
        return addressDto;
    }

    public static Address toEntity(AddressDto dto) {
        Address address = new Address();
        address.setId(dto.getId());
        address.setCityName(dto.getCityName());
        address.setStreetName(dto.getStreetName());
        address.setHouseNumber(dto.getHouseNumber());
        return address;
    }
}
