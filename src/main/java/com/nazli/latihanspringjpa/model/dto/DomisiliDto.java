package com.nazli.latihanspringjpa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomisiliDto {
    private String kodeDomisili;
    private String alamat;
    private String kelurahan;
    private String kecamatan;
    private String kota;
    private Integer kodePos;
    private Integer idDetailUser;
    private Integer status;
}
