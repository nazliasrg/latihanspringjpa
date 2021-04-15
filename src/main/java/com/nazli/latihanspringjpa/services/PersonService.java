package com.nazli.latihanspringjpa.services;

import com.nazli.latihanspringjpa.model.dto.PersonDto;
import com.nazli.latihanspringjpa.model.entity.PersonEntity;

public interface PersonService {
    PersonEntity insertData(PersonDto personDto);
    PersonEntity updateData(Integer id, PersonDto dto);
}
