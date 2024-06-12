package com.example.springbootcustomer.config.service;

import com.example.springbootcustomer.config.UserPrinciple;
import com.example.springbootcustomer.model.User;
import com.example.springbootcustomer.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    public User findUserByName(String name){
        return userRepository.findUserByUsername(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return UserPrinciple.build(userRepository.findUserByUsername(username));
    }
}
