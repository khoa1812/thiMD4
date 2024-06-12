package com.example.springbootcustomer.repository;

import com.example.springbootcustomer.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("select t from Transaction  t where t.type like %?1%")
    List<Transaction> findByType(String type);
}
