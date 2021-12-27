package com.pajak.training.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
    public String generateHelloByName(String name) {
        return "Hello "+name;
    }
}
