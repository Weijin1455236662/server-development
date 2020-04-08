package com.example.db;

import com.example.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
//    long count();
//
//    Customer save(Customer customer);
//
//    Customer findOne(long id);
//
    Customer findByName(String name);
//
//    List<Customer> findAll();
}
