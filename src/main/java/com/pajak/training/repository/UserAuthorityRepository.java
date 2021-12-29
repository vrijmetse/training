package com.pajak.training.repository;

import com.pajak.training.entity.UserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthorityRepository
        extends JpaRepository<UserAuthority, Long> {
}
