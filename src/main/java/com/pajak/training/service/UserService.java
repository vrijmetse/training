package com.pajak.training.service;

import com.pajak.training.dto.UserRegistrationForm;
import com.pajak.training.entity.Address;
import com.pajak.training.entity.User;
import com.pajak.training.repository.AddressRepository;
import com.pajak.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class UserService {


    private UserRepository userRepository;

    private AddressRepository addressRepository;

    private PasswordEncoder passwordEncoder;

    public UserService() {

    }

    @Autowired
    public UserService(UserRepository userRepository,
                       AddressRepository addressRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User getUserById(Long id) {
        return new User(id, "Alex", 23, "alex@gmail.com");
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
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

        Address address = new Address(userRegistrationForm.getStreetName(),
                userRegistrationForm.getPostCode(),
                userRegistrationForm.getRt(), userRegistrationForm.getRw());

        User user = new User(userRegistrationForm.getName(),
                userRegistrationForm.getAge(),
                userRegistrationForm.getEmail(),
                passwordEncoder.encode(userRegistrationForm.getPassword()),
                Set.of(address));

        address.setUser(user);
        userRepository.save(user); // di roll back kalau gagal save
        addressRepository.save(address); // di roll back kalau gagal save
        return user;
    }

    public List<User> findUserByAgeGreaterThan(Integer age) {
        return userRepository.findByAgeGreaterThan(age);
    }

    public Integer sumAge() {
        return userRepository.sumAgeForAllUser();
    }

    public Integer sumAgeV2() {
        return userRepository.sumAgeForAllUserV2();
    }
}
