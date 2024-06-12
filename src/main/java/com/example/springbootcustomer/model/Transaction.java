package com.example.springbootcustomer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transId;
    @ManyToOne
    @JoinColumn(name = "customers_id")
    private Customer customer;
    private String dot;
    private String type;
    private Double price;
    private Double area;
}
