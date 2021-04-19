package com.nazli.latihanspringjpa.controller;

import com.nazli.latihanspringjpa.config.MD5Generator;
import com.nazli.latihanspringjpa.model.dto.DomisiliDto;
import com.nazli.latihanspringjpa.model.dto.PersonDto;
import com.nazli.latihanspringjpa.model.dto.StatusMessageDto;
import com.nazli.latihanspringjpa.model.dto.UserDto;
import com.nazli.latihanspringjpa.model.entity.DomisiliEntity;
import com.nazli.latihanspringjpa.model.entity.UserEntity;
import com.nazli.latihanspringjpa.repository.DetailUserRepository;
import com.nazli.latihanspringjpa.repository.DomisiliRepository;
import com.nazli.latihanspringjpa.repository.UserRepository;
import com.nazli.latihanspringjpa.services.DomisiliService;
import com.nazli.latihanspringjpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
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

    @PostMapping("user/login")
    public ResponseEntity<?> login(@RequestBody UserDto dto){
        StatusMessageDto response = new StatusMessageDto<>();
        try{
            UserEntity user = userService.login(dto.getUsername(), MD5Generator.generate(dto.getPassword()));
            if(user == null){
                response.setStatus(HttpStatus.EXPECTATION_FAILED.value());
                response.setMessage("Login Failed!");
                return ResponseEntity.badRequest().body(response);
            }
//          kalau berhasil login
            String baseString = user.getUsername() + ":" + user.getPassword();
            String token = Base64.getEncoder().encodeToString(baseString.getBytes(StandardCharsets.UTF_8));

//          response
            response.setStatus(HttpStatus.OK.value());
            response.setMessage("Login Success!");
            response.setData(token);

            return ResponseEntity.ok(response);

        }catch (Exception e){
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("Error : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @PostMapping("user/register")
    public ResponseEntity<?> register(@RequestBody UserEntity dto){
        StatusMessageDto response = new StatusMessageDto<>();
        try{
           dto.setPassword(MD5Generator.generate(dto.getPassword()));
           UserEntity userCreated = userService.registUserData(dto);

           response.setStatus(HttpStatus.CREATED.value());
           response.setMessage("User Created!");
           response.setData(userCreated);

           return ResponseEntity.ok().body(response);
        }catch (Exception e){
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("Error : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }



//
//
//    @GetMapping("/users")
//    public List<UserEntity> getUserList(){
//        List<UserEntity> userList = userRepository.findAll();
//        return userList;
//    }
//
//    // get by id
//    @GetMapping("/user/{id}")
//    public ResponseEntity<?> getUser(@PathVariable Integer id){
//        UserEntity user = userRepository.findById(id).get();
//        return ResponseEntity.ok(user);
//    }
//
//
//    //    get all domisili
//    @GetMapping("/domisili-all")
//    public ResponseEntity<?> getAll(){
//        List<DomisiliEntity> domisilis = domisiliRepository.findAll();
//        return ResponseEntity.ok(domisilis);
//    }
//
//    // get by id
//    @GetMapping("/domisili/{id}")
//    public ResponseEntity<?> getPendidikan(@PathVariable Integer id){
//        DomisiliEntity domisili = domisiliRepository.findById(id).get();
//        return ResponseEntity.ok(domisili);
//    }
//
//    //    insert domisili
//    @PostMapping("/insert/domisili")
//    public ResponseEntity<?> insertDomisiliEntity(@RequestBody DomisiliDto domisiliDto){
//        DomisiliEntity domisili = domisiliService.insertDomisiliEntity(domisiliDto);
//        return ResponseEntity.ok(domisili);
//    }
//
//    //    update domisili
//    @PutMapping("/update/domisili/{id}")
//    public ResponseEntity<?> updateDomisiliEntity(@PathVariable Integer id, @RequestBody DomisiliDto dto){
//        DomisiliEntity domisili = domisiliService.updateDomisiliEntity(id, dto);
//        return ResponseEntity.ok(domisili);
//    }
//
//    //    delete domisili
//    @DeleteMapping("/delete/domisili/{id}")
//    public ResponseEntity<?> deleteDomisiliEntity(@PathVariable Integer id){
//        DomisiliEntity domisili = domisiliRepository.findById(id).get();
//        domisili.setStatus(0);
//        domisiliRepository.save(domisili);
//        return ResponseEntity.ok(domisili);
//    }
//

}
