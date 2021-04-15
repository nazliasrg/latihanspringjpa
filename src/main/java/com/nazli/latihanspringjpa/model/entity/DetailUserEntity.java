package com.nazli.latihanspringjpa.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_detail_user")
public class DetailUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Column(columnDefinition = "DATE")
    private Date tanggalLahir;

    @Column(length = 16)
    private String nik;

    @Column(length = 12)
    private String noHp;

    @Column(length = 5)
    private String golDarah;

    @OneToOne
    @JoinColumn(name = "userId")
    private UserEntity user;

    public DetailUserEntity(String firstName, String lastName, Date tanggalLahir, String nik, String noHp, String golDarah, UserEntity user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.tanggalLahir = tanggalLahir;
        this.nik = nik;
        this.noHp = noHp;
        this.golDarah = golDarah;
        this.user = user;
    }
}
