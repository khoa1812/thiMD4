package com.codegym.thimd4.repository;


import com.codegym.thimd4.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByFirstNameContaining(String firstName);
}
