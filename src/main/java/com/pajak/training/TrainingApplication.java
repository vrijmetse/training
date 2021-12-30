package com.pajak.training;

import com.pajak.training.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class TrainingApplication {


    @GetMapping("/")
    public String getHelloWorld(){
       return "Welcome to Spring Boot training";
    }
    public static void main(String[] args) {
        SpringApplication.run(TrainingApplication.class, args);
    }

}
