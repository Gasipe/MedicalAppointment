package com.example.spring_mysql.service;

import com.example.spring_mysql.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service

public class UserService {
    private final  UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
