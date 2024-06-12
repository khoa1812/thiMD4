package com.example.springbootcustomer.service;

import com.example.springbootcustomer.model.Customer;
import com.example.springbootcustomer.model.Transaction;

import java.util.List;

public interface ITransactionService extends IGenericService<Transaction> {

    List<Transaction> findTransactionByCustomerName(Customer customer);

    List<Transaction> findTransactionByType(String type);
}
