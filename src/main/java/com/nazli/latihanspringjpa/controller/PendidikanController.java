package com.nazli.latihanspringjpa.controller;

import com.nazli.latihanspringjpa.model.dto.PendidikanDto;
import com.nazli.latihanspringjpa.model.entity.PendidikanEntity;
import com.nazli.latihanspringjpa.repository.PendidikanRepository;
import com.nazli.latihanspringjpa.repository.UserRepository;
import com.nazli.latihanspringjpa.services.PendidikanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PendidikanController {
    @Autowired
    private PendidikanRepository pendidikanRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PendidikanService pendidikanService;

    //    get all pendidikan
    @GetMapping("/pendidikan-all")
    public ResponseEntity<?> getAll(){
        List<PendidikanEntity> pendidikans = pendidikanRepository.findAll();
        return ResponseEntity.ok(pendidikans);
    }

    //    get by id pendidikan
    @GetMapping("/pendidikan/{id}")
    public ResponseEntity<?> getPendidikan(@PathVariable Integer id){
        PendidikanEntity pendidikan = pendidikanRepository.findById(id).get();
        return ResponseEntity.ok(pendidikan);
    }

    //    insert pendidikan
    @PostMapping("/insert/pendidikan/{username}")
    public ResponseEntity<?> insertPendidikanEntity(@PathVariable String username, @RequestBody PendidikanDto pendidikanDto){
        PendidikanEntity pendidikan = pendidikanService.insertPendidikanEntity(username, pendidikanDto);
        return ResponseEntity.ok(pendidikan);
    }

    //    update pendidikan
    @PutMapping("/update/pendidikan/{id}")
    public ResponseEntity<?> updatePendidikanEntity(@PathVariable Integer id, @RequestBody PendidikanDto dto){
        PendidikanEntity pendidikan = pendidikanService.updatePendidikanEntity(id, dto);
        return ResponseEntity.ok(pendidikan);
    }

    //    delete pendidikan
    @DeleteMapping("/delete/pendidikan/{id}")
    public ResponseEntity<?> deletePendidikanEntity(@PathVariable Integer id){
        PendidikanEntity pendidikan = pendidikanRepository.findById(id).get();
        pendidikan.setStatus(0);
        pendidikanRepository.save(pendidikan);

        return ResponseEntity.ok(pendidikan);
    }
}
