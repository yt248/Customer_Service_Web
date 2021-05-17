package com.eugene.spring.boot.web.customer_service_web.service;

import com.eugene.spring.boot.web.customer_service_web.model.entity.Customer;

import java.util.List;

public interface CustomerService {
    /**
     * @return Получение всех клиентов
     */
    List<Customer> getAllCustomer();

    /**
     * @param customer Добавление нового клиента
     */
    void createCustomer(Customer customer);

    /**
     * @param id - клиента для получения
     * @return полученный клиента
     */
    Customer getCustomerById(int id);

    /**
     * @param id            клиента для изменения
     * @param updateCustomer измененный клиент
     */
    void updateCustomer(int id, Customer updateCustomer);

    /**
     * @param id клиента для удаления
     */
    void deleteCustomer(int id);
}
