package com.example.springbootcustomer.repository;

import com.example.springbootcustomer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select c from Customer  c where c.name like %?1%")
    List<Customer> findByName(String name);
}
