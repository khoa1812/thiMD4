package com.example.springbootcustomer.service;

import com.example.springbootcustomer.model.Customer;

import java.util.List;

public interface ICustomerService extends IGenericService<Customer> {
    List<Customer> findCustomerByName(String name);
}
