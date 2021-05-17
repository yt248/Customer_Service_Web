package com.eugene.spring.boot.web.customer_service_web.model.dto.mappers;

import com.eugene.spring.boot.web.customer_service_web.model.dto.CustomerDto;
import com.eugene.spring.boot.web.customer_service_web.model.entity.Customer;

public class CustomerMapper {

    public CustomerDto toDto(Customer entity) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(entity.getId());
        customerDto.setName(entity.getName());
        customerDto.setSurName(entity.getSurName());
        customerDto.setAge(entity.getAge());
        customerDto.setGender(entity.getGender());
        customerDto.setAddress(entity.getAddress());
        return customerDto;
    }


    public Customer toEntity(CustomerDto dto) {
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setName(dto.getName());
        customer.setSurName(dto.getSurName());
        customer.setAge(dto.getAge());
        customer.setGender(dto.getGender());
        customer.setAddress(dto.getAddress());
        return customer;
    }
}
