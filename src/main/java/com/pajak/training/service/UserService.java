package com.pajak.training.service;

import com.pajak.training.dto.UserRegistrationForm;
import com.pajak.training.entity.Address;
import com.pajak.training.entity.User;
import com.pajak.training.repository.AddressRepository;
import com.pajak.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class UserService {


    private UserRepository userRepository;


    private AddressRepository addressRepository;

    public UserService(){

    }

    @Autowired
    public UserService(UserRepository userRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    public User getUserById(Long id) {
        return new User(id, "Alex", 23, "alex@gmail.com");
    }

    public List<User> getAllUsers() {
        User alex = new User(1L, "Alex", 23, "alex@gmail.com");
        User john = new User(2L, "John", 20, "john@gmail.com");


        return List.of(alex, john);
    }

    public User save(User user) {
        user = userRepository.save(user);
        Address address = new Address("streetName", 12345, 1, 2);
        address.setUser(user);
        addressRepository.save(address);
        user.setAddressList(Set.of(address));
        return user;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Transactional(rollbackOn = Exception.class, value = Transactional.TxType.REQUIRED)
    public User registerV2(UserRegistrationForm userRegistrationForm) {
        User user = new User(userRegistrationForm.getName(),
                userRegistrationForm.getAge(),
                userRegistrationForm.getEmail());
        Address address = new Address(userRegistrationForm.getStreetName(),
                userRegistrationForm.getPostCode(),
                userRegistrationForm.getRt(), userRegistrationForm.getRw());
        address.setUser(user);
        user.setAddressList(Set.of(address));
        userRepository.save(user); // di roll back kalau gagal save
        addressRepository.save(address); // di roll back kalau gagal save
        return user;
    }

}
