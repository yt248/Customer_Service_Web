package com.eugene.spring.boot.web.customer_service_web.service;

import com.eugene.spring.boot.web.customer_service_web.dto.AddressDto;
import com.eugene.spring.boot.web.customer_service_web.dto.CustomerDto;
import com.eugene.spring.boot.web.customer_service_web.entity.Customer;
import com.eugene.spring.boot.web.customer_service_web.exceptions.CustomerByIdNotFoundException;

import java.util.List;

public interface CustomerService {
    /**
     * @return Получение всех клиентов
     */
    List<Customer> getAllCustomer();

    /**
     * @param customerDto Добавление нового клиента
     */
    void createCustomer(CustomerDto customerDto);

    /**
     * @param id - клиента для получения
     * @return полученный клиента
     */
    Customer getCustomerById(int id) throws CustomerByIdNotFoundException;

    /**
     * @param id            клиента для изменения
     * @param updateCustomerDto измененный клиент
     */
    void updateCustomer(int id, CustomerDto updateCustomerDto);

    /**
     * @param id клиента для удаления
     */
    void deleteCustomer(int id);


    /**
     * Поиск клиентов по имени и фамилии
     *
     * @param name - Имя клиента
     * @param surname Фамилия клиента
     * @return список клиентов удовлетворяющих условию
     */
    List<Customer> getCustomerByNameAndAddress(String name, String surname);

    public void updateAddressToCustomer(int customerId, AddressDto addressDto);

    public void addAddressToCustomer(int customerId, AddressDto addressDto);

}
