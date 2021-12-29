package com.pajak.training.service;

import com.pajak.training.entity.Address;
import com.pajak.training.entity.User;
import com.pajak.training.repository.AddressRepository;
import com.pajak.training.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;

class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    AddressRepository addressRepository;

    @InjectMocks
    UserService userService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllUsers() {
        Mockito.when(userRepository.findAll())
                .thenReturn(List.of(new User()));
        Mockito.when(addressRepository.findById(anyLong()))
                .thenReturn(java.util.Optional.of(new Address()));
        List<User> users = userService.getAllUsers();
    }
}