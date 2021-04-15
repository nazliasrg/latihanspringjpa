package com.nazli.latihanspringjpa.services;

import com.nazli.latihanspringjpa.model.dto.PersonDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> registUserData(PersonDto personDto);
    ResponseEntity<?> updateUserEntity(PersonDto personDto);
}
