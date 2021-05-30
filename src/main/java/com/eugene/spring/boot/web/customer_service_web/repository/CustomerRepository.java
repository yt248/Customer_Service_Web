package com.eugene.spring.boot.web.customer_service_web.repository;

import com.eugene.spring.boot.web.customer_service_web.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("select c from Customer c where c.name like %:name% and c.surName like %:surname%")
    List<Customer> getCustomerByNameAndAddress(@Param("name") String name, @Param("surname") String surName);

}
