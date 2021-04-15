package com.nazli.latihanspringjpa.services;

import com.nazli.latihanspringjpa.model.dto.PersonDto;
import com.nazli.latihanspringjpa.model.entity.PersonEntity;
import com.nazli.latihanspringjpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonServiceImp implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public PersonEntity insertData(PersonDto personDto) {
        if(!personDto.getFirstName().isEmpty()){
            PersonEntity personEntity = convertDtoToEntity(personDto);
            personRepository.save(personEntity);
            return personEntity;
        }
        else{
            return null;
        }
    }

    @Override
    public PersonEntity updateData(Integer id, PersonDto dto) {
        PersonEntity personEntity = personRepository.findById(id).get();

        if(dto.getFirstName() != null){
            personEntity.setFirstName(dto.getFirstName());
        }
        if(dto.getLastName() != null){
            personEntity.setLastName(dto.getLastName());
        }
        if(dto.getTanggalLahir() != null){
            personEntity.setTanggalLahir(dto.getTanggalLahir());
        }
        if(dto.getNik() != null){
            personEntity.setNik(dto.getNik());
        }
        if(dto.getNoHp() != null){
            personEntity.setNoHp(dto.getNoHp());
        }
        if(dto.getGolDarah() != null){
            personEntity.setGolDarah(dto.getGolDarah());
        }
        if(dto.getStatus() != null){
            personEntity.setStatus(dto.getStatus());
        }

        personRepository.save(personEntity);
        return personEntity;
    }

    private PersonEntity convertDtoToEntity(PersonDto personDto){
        PersonEntity personEntity = new PersonEntity();
        personEntity.setFirstName(personDto.getFirstName());
        personEntity.setLastName(personDto.getLastName());
        personEntity.setTanggalLahir(personDto.getTanggalLahir());
        personEntity.setNik(personDto.getNik());
        personEntity.setNoHp(personDto.getNoHp());
        personEntity.setGolDarah(personDto.getGolDarah());
        personEntity.setStatus(1);
        return personEntity;
    }
}
