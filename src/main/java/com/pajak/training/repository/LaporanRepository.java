package com.pajak.training.repository;

import com.pajak.training.entity.Laporan;
import com.pajak.training.entity.WajibPajakPerorangan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaporanRepository extends JpaRepository<Laporan, Long> {

    List<Laporan> findAllByWajibPajakPerorangan(WajibPajakPerorangan wajibPajakPerorangan);
}
