package com.nazli.latihanspringjpa.controller;

import com.nazli.latihanspringjpa.model.dto.PersonDto;
import com.nazli.latihanspringjpa.model.dto.StatusMessageDto;
import com.nazli.latihanspringjpa.model.entity.PersonEntity;
import com.nazli.latihanspringjpa.repository.PersonRepository;
import com.nazli.latihanspringjpa.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public List<PersonEntity> getPersonList(){
        List<PersonEntity> personList = personRepository.findAll();
        return personList;
    }

    // get by id
    @GetMapping("/person/{id}")
    public ResponseEntity<?> getPerson(@PathVariable Integer id){
        PersonEntity personEntity = personRepository.findById(id).get();
        return ResponseEntity.ok(personEntity);
    }

    // POST Person
    @PostMapping("/insert/person")
    public ResponseEntity<?> insertPerson(@RequestBody PersonDto personDto){
        StatusMessageDto<PersonEntity> result = new StatusMessageDto<>();
        if(personDto.getNik().length() != 16){
            result.setStatus(HttpStatus.BAD_REQUEST.value());
            result.setMessage("NIK harus berjumlah 16 angka");
            return ResponseEntity.badRequest().body(result);
        }
        // transfer data melalui service
        PersonEntity personEntity = personService.insertData(personDto);
        return ResponseEntity.ok(personEntity);
    }

    // update person
    @PutMapping("/update/person/{id}")
    public  ResponseEntity<?> updatePersonEntity(@PathVariable Integer id, @RequestBody PersonDto personDto){
        PersonEntity personEntity = personService.updateData(id, personDto);
        return ResponseEntity.ok(personEntity);
    }

    // delete person
    @DeleteMapping("/delete/person/{id}")
    public ResponseEntity<?> deletePersonEntity(@PathVariable Integer id){
        PersonEntity personEntity = personRepository.findById(id).get();
        personEntity.setStatus(0);
        personRepository.save(personEntity);
        return ResponseEntity.ok(personEntity);
    }

}
