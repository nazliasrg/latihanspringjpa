package com.nazli.latihanspringjpa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PendidikanDto {
    private String kodePendidikan;
    private String jenjang;
    private String institusi;
    private Integer status;
    // karena menggunakan reference kolom di pendidikan.java dari user.java
    private String username;
}
