package com.pajak.training.controller;

import com.pajak.training.service.WPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.text.MessageFormat;


@RestController
@RequestMapping("/wp-reactive")
public class WajibPajakPeroranganReactiveController {

    @Autowired
    private WPService wpService;

    @PostMapping
    public Mono<ResponseEntity<String>> laporPajak(String nama, double jumlah) {
        String message = MessageFormat.format("telah diterima laporan dari {0} dengan jumlah {1}", nama, jumlah);
        return Mono.just(new ResponseEntity<>(message, HttpStatus.CREATED));
    }

    @GetMapping
    public Mono<ResponseEntity<String>> cekPajakV1(String id) throws InterruptedException {
        String message = MessageFormat.format("cek pajak v1 untuk {0}", id);
        wpService.cekPajakV1(id);
        return Mono.just(new ResponseEntity<>(message, HttpStatus.OK));
    }

    @GetMapping("/{nama}")
    public Mono<ResponseEntity<String>> cekPajakV2(@PathVariable String nama) {
        String message = MessageFormat.format("cek pajak v2 untuk {0}", nama);
        return Mono.just(new ResponseEntity<>(message, HttpStatus.OK));
    }
}
