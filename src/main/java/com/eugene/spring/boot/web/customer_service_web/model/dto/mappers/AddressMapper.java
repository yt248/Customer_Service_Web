package com.eugene.spring.boot.web.customer_service_web.model.dto.mappers;

import com.eugene.spring.boot.web.customer_service_web.model.dto.AddressDto;
import com.eugene.spring.boot.web.customer_service_web.model.entity.Address;

public class AddressMapper {

    public AddressDto toDto(Address entity) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(entity.getId());
        addressDto.setCityName(entity.getCityName());
        addressDto.setStreetName(entity.getStreetName());
        addressDto.setHouseNumber(entity.getHouseNumber());
        addressDto.getCustomerDtoList().addAll(entity.getCustomerList());
        return addressDto;
    }

    public Address toEntity(AddressDto dto) {
        Address address = new Address();
        address.setId(dto.getId());
        address.setCityName(dto.getCityName());
        address.setStreetName(dto.getStreetName());
        address.setHouseNumber(dto.getHouseNumber());
        address.getCustomerList().addAll(dto.getCustomerDtoList());
        return address;
    }
}
