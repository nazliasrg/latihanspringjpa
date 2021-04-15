package com.nazli.latihanspringjpa.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class PersonDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Date tanggalLahir;
    private String nik;
    private String noHp;
    private String golDarah;
    private Integer status;

    public PersonDto(String username, String password, String firstName, String lastName, Date tanggalLahir, String nik, String noHp, String golDarah, Integer status) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tanggalLahir = tanggalLahir;
        this.nik = nik;
        this.noHp = noHp;
        this.golDarah = golDarah;
        this.status = status;
    }
}
