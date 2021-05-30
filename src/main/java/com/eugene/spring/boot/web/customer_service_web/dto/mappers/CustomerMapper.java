package com.eugene.spring.boot.web.customer_service_web.dto.mappers;

import com.eugene.spring.boot.web.customer_service_web.dto.CustomerDto;
import com.eugene.spring.boot.web.customer_service_web.entity.Customer;

public class CustomerMapper {

    public static CustomerDto toDto(Customer entity) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(entity.getId());
        customerDto.setName(entity.getName());
        customerDto.setSurName(entity.getSurName());
        customerDto.setAge(entity.getAge());
        if (entity.getAddress() != null)
            customerDto.setAddressDto(AddressMapper.toDto(entity.getAddress()));

        return customerDto;
    }


    public static Customer toEntity(CustomerDto dto) {
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setName(dto.getName());
        customer.setSurName(dto.getSurName());
        customer.setAge(dto.getAge());
        if (dto.getAddressDto() != null)
            customer.setAddress(AddressMapper.toEntity(dto.getAddressDto()));
        return customer;
    }
}
