package com.example.springbootcustomer.service;

import com.example.springbootcustomer.model.Customer;
import com.example.springbootcustomer.model.Transaction;
import com.example.springbootcustomer.repository.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    ITransactionRepository transactionRepository;

    @Override
    public Iterable<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return transactionRepository.findById(id);
    }

    @Override
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public void remove(Long id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public List<Transaction> findTransactionByCustomerName(Customer customer) {
        List<Transaction> lists = new ArrayList<>();
        List<Transaction> list = transactionRepository.findAll();
        for (Transaction t : list) {
            if (t.getCustomer().getId() == customer.getId()) {
                lists.add(t);
            }
        }
        return lists;
    }

    @Override
    public List<Transaction> findTransactionByType(String type) {
        return transactionRepository.findByType(type);
    }
}
