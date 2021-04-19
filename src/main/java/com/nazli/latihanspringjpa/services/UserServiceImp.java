package com.nazli.latihanspringjpa.services;

import com.nazli.latihanspringjpa.model.dto.PersonDto;
import com.nazli.latihanspringjpa.model.dto.StatusMessageDto;
import com.nazli.latihanspringjpa.model.entity.DetailUserEntity;
import com.nazli.latihanspringjpa.model.entity.UserEntity;
import com.nazli.latihanspringjpa.repository.DetailUserRepository;
import com.nazli.latihanspringjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DetailUserRepository detailUserRepository;

    @Override
    public ResponseEntity<?> registUserData(PersonDto personDto) {
        StatusMessageDto<UserEntity> result = new StatusMessageDto<>();
        if(personDto.getNik().length() != 16){
            result.setStatus(HttpStatus.BAD_REQUEST.value());
            result.setMessage("NIK harus berjumlah 16 angka");
            return ResponseEntity.badRequest().body(result);
        }

        UserEntity user = new UserEntity();
        DetailUserEntity detailUser = new DetailUserEntity();

        user.setUsername(personDto.getUsername());
        user.setPassword(personDto.getPassword());
        user.setStatus(1);
        userRepository.save(user);

        detailUser.setFirstName(personDto.getFirstName());
        detailUser.setLastName(personDto.getLastName());
        detailUser.setNik(personDto.getNik());
        detailUser.setTanggalLahir(personDto.getTanggalLahir());
        detailUser.setGolDarah(personDto.getGolDarah());
        detailUser.setNoHp(personDto.getNoHp());

        detailUser.setUser(user);
        detailUserRepository.save(detailUser);

        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data berhasil tersimpan");
        result.setData(user);

        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<?> updateUserEntity(Integer id, PersonDto personDto) {
        StatusMessageDto<UserEntity> result = new StatusMessageDto<>();

        UserEntity user = userRepository.findById(id).get();
        DetailUserEntity detailUser = detailUserRepository.findByUserEntityId(id);

        if(personDto.getUsername() != null){
            user.setUsername(personDto.getUsername());
        }
        if(personDto.getPassword() != null){
            user.setPassword(personDto.getPassword());
        }
        if(personDto.getStatus() != null){
            user.setStatus(personDto.getStatus());
        }
        userRepository.save(user);

        if(personDto.getFirstName() != null){
            detailUser.setFirstName(personDto.getFirstName());
        }
        if(personDto.getLastName() != null){
            detailUser.setLastName(personDto.getLastName());
        }
        if(personDto.getNik() != null){
            detailUser.setNik(personDto.getNik());
        }
        if(personDto.getTanggalLahir() != null){
            detailUser.setTanggalLahir(personDto.getTanggalLahir());
        }
        if(personDto.getGolDarah() != null){
            detailUser.setGolDarah(personDto.getGolDarah());
        }
        if(personDto.getNoHp() != null){
            detailUser.setNoHp(personDto.getNoHp());
        }
        detailUser.setUser(user);
        detailUserRepository.save(detailUser);

        result.setStatus(HttpStatus.OK.value());
        result.setMessage("Data berhasil diupdate");
        result.setData(user);

        return ResponseEntity.ok(result);
    }
}
