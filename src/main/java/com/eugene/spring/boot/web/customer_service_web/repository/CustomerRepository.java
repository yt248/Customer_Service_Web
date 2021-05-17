package com.eugene.spring.boot.web.customer_service_web.repository;

import com.eugene.spring.boot.web.customer_service_web.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
