package com.nazli.latihanspringjpa.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_person")
public class PersonEntity {
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

    @Column(length = 11)
    private Integer status;
}
