package com.eugene.spring.boot.web.customer_service_web.service;

import com.eugene.spring.boot.web.customer_service_web.dto.AddressDto;
import com.eugene.spring.boot.web.customer_service_web.dto.CustomerDto;
import com.eugene.spring.boot.web.customer_service_web.dto.mappers.CustomerMapper;
import com.eugene.spring.boot.web.customer_service_web.entity.Customer;
import com.eugene.spring.boot.web.customer_service_web.exceptions.CustomerByIdNotFoundException;
import com.eugene.spring.boot.web.customer_service_web.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final AddressService addressService;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, AddressService addressService) {
        this.customerRepository = customerRepository;
        this.addressService = addressService;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public void createCustomer(CustomerDto customerDto) {
        if (customerDto != null) {
            Customer customer = CustomerMapper.toEntity(customerDto);
            customerRepository.save(customer);
        }
    }

    @Override
    public Customer getCustomerById(int id) {
//        Optional<Customer> optional = customerRepository.findById(id);
//        Customer customer = null;
//        if (optional.isPresent())
//            customer = optional.get();
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerByIdNotFoundException("Customer not found with id - " + id));
    }

    @Override
    public void updateCustomer(int id, CustomerDto updateCustomerDto) {
        Customer customer = customerRepository.getOne(id);
        customer.setName(updateCustomerDto.getName());
        customer.setSurName(updateCustomerDto.getSurName());
        customer.setAge(updateCustomerDto.getAge());
//        customer.setAddress(updateCustomer.getAddress());
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        Customer customer = getCustomerById(id);
        customer.setAddress(null);
        customerRepository.delete(customer);
    }


    @Override
    @Transactional
    public List<Customer> getCustomerByNameAndAddress(String name, String surname) {
        return customerRepository.getCustomerByNameAndAddress(name, surname);
    }

    @Override
    public void updateAddressToCustomer(int customerId, AddressDto addressDto) {
        CustomerDto customerDto = CustomerMapper.toDto(getCustomerById(customerId));

        AddressDto updateAddress = new AddressDto();
        updateAddress.setCityName(addressDto.getCityName());
        updateAddress.setStreetName(addressDto.getStreetName());
        updateAddress.setHouseNumber(addressDto.getHouseNumber());

        Integer idAddress = addressService.findByAddress(updateAddress.getCityName(),
                updateAddress.getStreetName(), updateAddress.getHouseNumber());


        if (idAddress != null) {
            updateAddress.setId(idAddress);
        }
        customerDto.setAddressDto(updateAddress);
        createCustomer(customerDto);

    }

}
