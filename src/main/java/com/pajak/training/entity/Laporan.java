package com.pajak.training.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Laporan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false)
    private Long jumlah;

    @Column
    private Integer revision;


    @ManyToOne(optional = false)
    @NotNull
    private WajibPajakPerorangan wajibPajakPerorangan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJumlah() {
        return jumlah;
    }

    public void setJumlah(Long jumlah) {
        this.jumlah = jumlah;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public WajibPajakPerorangan getWajibPajakPerorangan() {
        return wajibPajakPerorangan;
    }

    public void setWajibPajakPerorangan(WajibPajakPerorangan wajibPajak) {
        this.wajibPajakPerorangan = wajibPajak;
    }
}
