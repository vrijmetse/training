package com.pajak.training.controller;

import com.pajak.training.dto.UserRegistrationForm;
import com.pajak.training.entity.User;
import com.pajak.training.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) throws Exception {
        if (user.getId() == null) {
            log.warn("user did not provide any ID");
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        }
        user = userService.updateUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(path = "{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping(path = "/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(path = "/new")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        user = userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping(path = "/register")
    public ResponseEntity<User> registrationForm(@RequestBody UserRegistrationForm
                                                             userRegistrationForm) {
        User user = userService.registerV2(userRegistrationForm);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{id}")
    public boolean deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return true;
    }

}
