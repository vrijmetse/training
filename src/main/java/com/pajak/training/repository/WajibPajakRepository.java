package com.pajak.training.repository;

import com.pajak.training.entity.WajibPajakPerorangan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WajibPajakRepository extends JpaRepository<WajibPajakPerorangan, Long> {
}
