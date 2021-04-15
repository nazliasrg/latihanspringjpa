package com.nazli.latihanspringjpa.services;

import com.nazli.latihanspringjpa.model.dto.DomisiliDto;
import com.nazli.latihanspringjpa.model.entity.DomisiliEntity;

public interface DomisiliService {
    DomisiliEntity insertDomisiliEntity(DomisiliDto domisiliDto);
    DomisiliEntity updateDomisiliEntity(Integer id, DomisiliDto dto);
}
