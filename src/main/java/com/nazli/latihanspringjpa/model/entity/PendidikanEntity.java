package com.nazli.latihanspringjpa.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_pendidikan")
public class PendidikanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String kodePendidikan;

    @Column
    private String jenjang;

    @Column
    private String institusi;

    @Column(length = 11)
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private UserEntity user;

    public PendidikanEntity(String kodePendidikan, String jenjang, String institusi, Integer status, UserEntity user) {
        this.kodePendidikan = kodePendidikan;
        this.jenjang = jenjang;
        this.institusi = institusi;
        this.status = status;
        this.user = user;
    }
}
