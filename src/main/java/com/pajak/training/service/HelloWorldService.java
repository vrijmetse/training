package com.pajak.training.service;

import com.pajak.training.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    private UserRepository userRepository;

    public HelloWorldService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public String generateHelloByName(String name) {
        return "Hello "+name;
    }
}
