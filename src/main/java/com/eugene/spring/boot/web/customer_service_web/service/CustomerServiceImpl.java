package com.eugene.spring.boot.web.customer_service_web.service;

import com.eugene.spring.boot.web.customer_service_web.model.entity.Customer;
import com.eugene.spring.boot.web.customer_service_web.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public void createCustomer(Customer customer) {
        if (customer != null)
            customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        Optional<Customer> optional = customerRepository.findById(id);
        Customer customer = new Customer();
        if (optional.isPresent())
            customer = optional.get();

        return customer;
    }

    @Override
    public void updateCustomer(int id, Customer updateCustomer) {
//        if (customerRepository.existsById(id)) {
//            updateCustomer.setId(id);
//            customerRepository.save(updateCustomer);
//        }
        Customer customer = customerRepository.getOne(id);
        customer.setName(updateCustomer.getName());
        customer.setSurName(updateCustomer.getSurName());
        customer.setAge(updateCustomer.getAge());
        customer.setGender(updateCustomer.getGender());
        customer.setAddress(updateCustomer.getAddress());

    }

    @Override
    public void deleteCustomer(int id) {
        Customer customer = getCustomerById(id);
        customerRepository.delete(customer);
    }
}
