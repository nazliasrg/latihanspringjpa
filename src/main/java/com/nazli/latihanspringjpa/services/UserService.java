package com.nazli.latihanspringjpa.services;

import com.nazli.latihanspringjpa.model.dto.PersonDto;
import com.nazli.latihanspringjpa.model.entity.UserEntity;
import org.springframework.http.ResponseEntity;

public interface UserService {
    UserEntity registUserData(UserEntity dto);
    ResponseEntity<?> updateUserEntity(Integer id, PersonDto personDto);

    UserEntity login(String username, String password);
}
