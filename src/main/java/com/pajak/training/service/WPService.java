package com.pajak.training.service;

import com.pajak.training.entity.Laporan;
import com.pajak.training.entity.WajibPajakPerorangan;
import com.pajak.training.repository.LaporanRepository;
import com.pajak.training.repository.WajibPajakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class WPService {

    @Autowired
    private WajibPajakRepository wajibPajakRepository;

    @Autowired
    private LaporanRepository laporanRepository;


    @Transactional
    public void buatLaporan(String ktp, String name, Long jumlah) {
        WajibPajakPerorangan wajibPajakPerorangan = new WajibPajakPerorangan();
        wajibPajakPerorangan.setName(name);
        wajibPajakPerorangan.setKtp(ktp);
        Laporan laporan = new Laporan();
        laporan.setJumlah(jumlah);
        laporan.setWajibPajakPerorangan(wajibPajakPerorangan);
        wajibPajakRepository.save(wajibPajakPerorangan);
        laporanRepository.save(laporan);
    }

    public void cekPajakV1(String id) throws InterruptedException {
        Thread.sleep(5000);
    }

    public List<Laporan> findLaporan(WajibPajakPerorangan wajibPajakPerorangan){
        return laporanRepository.findAllByWajibPajakPerorangan(wajibPajakPerorangan);
    }
}
