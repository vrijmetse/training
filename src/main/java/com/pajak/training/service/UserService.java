package com.pajak.training.service;

import com.pajak.training.dto.UserRegistrationForm;
import com.pajak.training.entity.Address;
import com.pajak.training.entity.User;
import com.pajak.training.entity.UserAuthority;
import com.pajak.training.repository.AddressRepository;
import com.pajak.training.repository.UserAuthorityRepository;
import com.pajak.training.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {


    private UserRepository userRepository;

    private AddressRepository addressRepository;

    private UserAuthorityRepository userAuthorityRepository;

    private PasswordEncoder passwordEncoder;

    public UserService() {

    }

    @Autowired
    public UserService(UserRepository userRepository,
                       AddressRepository addressRepository,
                       PasswordEncoder passwordEncoder,
                       UserAuthorityRepository userAuthorityRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.passwordEncoder = passwordEncoder;
        this.userAuthorityRepository = userAuthorityRepository;
    }

    public User getUserById(Long id) {
        Object[][] result = userRepository.findByIdCustom(id);
        BigInteger resultId = (BigInteger) result[0][0];
        Integer resultAge = (Integer) result[0][1];
        String resultEmail = (String) result[0][2];
        User user = new User();
        user.setId(resultId.longValue());
        user.setAge(resultAge);
        user.setEmail(resultEmail);
        return user;
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
        // no need to delete
        // addressRepository.delete(id);
        //  userAuthorityRepository.delete(id);
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

        UserAuthority userAuthority = new UserAuthority(userRegistrationForm.getRoleName(), user);
        user.setAuthorities(Set.of(userAuthority));

        userRepository.save(user);
        addressRepository.save(address);
        userAuthorityRepository.save(userAuthority);
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
