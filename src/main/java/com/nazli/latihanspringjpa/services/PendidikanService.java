package com.nazli.latihanspringjpa.services;

import com.nazli.latihanspringjpa.model.dto.PendidikanDto;
import com.nazli.latihanspringjpa.model.entity.PendidikanEntity;

public interface PendidikanService {
    PendidikanEntity insertPendidikanEntity(String username, PendidikanDto pendidikanDto);
    PendidikanEntity updatePendidikanEntity(Integer id, PendidikanDto dto);
}
