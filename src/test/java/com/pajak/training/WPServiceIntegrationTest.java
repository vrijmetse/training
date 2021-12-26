package com.pajak.training;

import com.pajak.training.entity.Laporan;
import com.pajak.training.entity.WajibPajakPerorangan;
import com.pajak.training.service.WPService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class WPServiceIntegrationTest {

    @Autowired
    WPService wpService;

    @Test
//    @Transactional
    void buatLaporan() {
        wpService.buatLaporan("ktp17", "name17", 1017L);
    }

    @Test
//    @Transactional
    void cariLaporan() {
        WajibPajakPerorangan wajibPajakPerorangan = new WajibPajakPerorangan();
        wajibPajakPerorangan.setId(1L);
        List<Laporan> result = wpService.findLaporan(wajibPajakPerorangan);
        System.out.println(result.size());
    }

}
