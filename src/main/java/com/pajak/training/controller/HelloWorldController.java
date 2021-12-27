package com.pajak.training.controller;

import com.pajak.training.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "hello-world")
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping
    public String getHelloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "{name}")
    public String getHelloByName(@PathVariable String name){
        return helloWorldService.generateHelloByName(name);

    }
}
