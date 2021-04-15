package com.nazli.latihanspringjpa.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_domisili")
public class DomisiliEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String kodeDomisili;

    @Column(length = 50)
    private String alamat;

    @Column(length = 50)
    private String kelurahan;

    @Column(length = 50)
    private String kecamatan;

    @Column(length = 25)
    private String kota;

    @Column(length = 11)
    private Integer kodePos;

    @Column(length = 11)
    private Integer status;

    @OneToOne
    @JoinColumn(name = "idDetailUser")
    private DetailUserEntity detailUser;

    public DomisiliEntity(String kodeDomisili, String alamat, String kelurahan, String kecamatan, String kota, Integer kodePos, Integer status, DetailUserEntity detailUser) {
        this.kodeDomisili = kodeDomisili;
        this.alamat = alamat;
        this.kelurahan = kelurahan;
        this.kecamatan = kecamatan;
        this.kota = kota;
        this.kodePos = kodePos;
        this.status = status;
        this.detailUser = detailUser;
    }
}
