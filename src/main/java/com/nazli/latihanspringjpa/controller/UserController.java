package com.nazli.latihanspringjpa.controller;

import com.nazli.latihanspringjpa.model.dto.DomisiliDto;
import com.nazli.latihanspringjpa.model.dto.PersonDto;
import com.nazli.latihanspringjpa.model.dto.StatusMessageDto;
import com.nazli.latihanspringjpa.model.dto.UserDto;
import com.nazli.latihanspringjpa.model.entity.DomisiliEntity;
import com.nazli.latihanspringjpa.model.entity.PersonEntity;
import com.nazli.latihanspringjpa.model.entity.UserEntity;
import com.nazli.latihanspringjpa.repository.DetailUserRepository;
import com.nazli.latihanspringjpa.repository.DomisiliRepository;
import com.nazli.latihanspringjpa.repository.UserRepository;
import com.nazli.latihanspringjpa.services.DomisiliService;
import com.nazli.latihanspringjpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DetailUserRepository detailUserRepository;

    @Autowired
    private DomisiliRepository domisiliRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private DomisiliService domisiliService;

    @GetMapping("/users")
    public List<UserEntity> getUserList(){
        List<UserEntity> userList = userRepository.findAll();
        return userList;
    }

    // get by id
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable Integer id){
        UserEntity user = userRepository.findById(id).get();
        return ResponseEntity.ok(user);
    }

//    registrasi user
    @PostMapping("/registrasi")
    public ResponseEntity<?> registration(@RequestBody PersonDto personDto){
        StatusMessageDto<UserEntity> result = new StatusMessageDto<>();
        try{
            return userService.registUserData(personDto);
        }catch (Exception e){
            result.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

//    update data user
    @PutMapping("/update/user/{id}")
    public ResponseEntity<?> updateUserEntity(@PathVariable Integer id, @RequestBody PersonDto personDto){
        StatusMessageDto<UserEntity> result = new StatusMessageDto<>();
        try{
            return userService.updateUserEntity(personDto);
        }catch (Exception e){
            result.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(result);
        }
    }

//    delete data user
    @DeleteMapping("/delete/user/{id}")
    public ResponseEntity<?> deleteUserEntity(@PathVariable Integer id){
        UserEntity user = userRepository.findById(id).get();
        user.setStatus(0);
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto userDto){
        return  null;
    }

    //    get all domisili
    @GetMapping("/domisili-all")
    public ResponseEntity<?> getAll(){
        List<DomisiliEntity> domisilis = domisiliRepository.findAll();
        return ResponseEntity.ok(domisilis);
    }

    // get by id
    @GetMapping("/domisili/{id}")
    public ResponseEntity<?> getPendidikan(@PathVariable Integer id){
        DomisiliEntity domisili = domisiliRepository.findById(id).get();
        return ResponseEntity.ok(domisili);
    }

    //    insert domisili
    @PostMapping("/insert/domisili")
    public ResponseEntity<?> insertDomisiliEntity(@RequestBody DomisiliDto domisiliDto){
        DomisiliEntity domisili = domisiliService.insertDomisiliEntity(domisiliDto);
        return ResponseEntity.ok(domisili);
    }

    //    update domisili
    @PutMapping("/update/domisili/{id}")
    public ResponseEntity<?> updateDomisiliEntity(@PathVariable Integer id, @RequestBody DomisiliDto dto){
        DomisiliEntity domisili = domisiliService.updateDomisiliEntity(id, dto);
        return ResponseEntity.ok(domisili);
    }

    //    delete domisili
    @DeleteMapping("/delete/domisili/{id}")
    public ResponseEntity<?> deleteDomisiliEntity(@PathVariable Integer id){
        DomisiliEntity domisili = domisiliRepository.findById(id).get();
        domisili.setStatus(0);
        domisiliRepository.save(domisili);
        return ResponseEntity.ok(domisili);
    }

}
