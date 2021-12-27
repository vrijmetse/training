package com.pajak.training.repository;

import com.pajak.training.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository
        extends JpaRepository<Address, Long> {
}
