package com.pajak.training.controller;

import com.pajak.training.service.WPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;


@RestController
@RequestMapping("/wp")
public class WajibPajakPeroranganController {

    @Autowired
    private WPService wpService;

    @PostMapping
    public ResponseEntity<String> laporPajak(String ktp, String nama, long jumlah) {
        String message = MessageFormat.format("telah diterima laporan dari {0} dengan jumlah {1}", nama, jumlah);
        wpService.buatLaporan(ktp, nama, jumlah);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<String> cekPajakV1(String id) throws InterruptedException {
        String message = MessageFormat.format("cek pajak v1 untuk {0}", id);
        wpService.cekPajakV1(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/{nama}")
    public ResponseEntity<String> cekPajakV2(@PathVariable String nama) {
        String message = MessageFormat.format("cek pajak v2 untuk {0}", nama);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
