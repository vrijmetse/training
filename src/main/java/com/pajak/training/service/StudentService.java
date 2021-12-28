package com.pajak.training.service;

import com.pajak.training.controller.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents() throws InterruptedException {
        Thread.sleep(5000L); // mimic long-running process
        return Arrays.asList(
                new Student(1, "James Bond"),
                new Student(2, "Maria Jones"),
                new Student(3, "Anna Smith")
        );
    }
}
