package com.codegym.thimd4.service;



import com.codegym.thimd4.model.Customer;

import java.util.List;

public interface ICustomerService extends IGenerateService<Customer> {
    List<Customer> findByFirstNameContaining(String firstName);
}