package com.pajak.training.repository;

import com.pajak.training.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {

    List<User> findByAgeGreaterThan(Integer age);

    User findByEmail(String email);

    int countByAge(Integer age);

    boolean existsById(Long id);

    @Query(value = "select sum(age) from training_user", nativeQuery = true)
    Integer sumAgeForAllUser();

    @Query(value = "select sum(u.age) from User u")
    Integer sumAgeForAllUserV2();
}
