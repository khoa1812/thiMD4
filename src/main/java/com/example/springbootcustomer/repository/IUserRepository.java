package com.example.springbootcustomer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springbootcustomer.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String name);
}
