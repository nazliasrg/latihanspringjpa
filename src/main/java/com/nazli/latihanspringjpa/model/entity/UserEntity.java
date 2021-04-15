package com.nazli.latihanspringjpa.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_user")
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String password;

    @Column(length = 11)
    private Integer status;

    public UserEntity(String username, String password, Integer status) {
        this.username = username;
        this.password = password;
        this.status = status;
    }
}
