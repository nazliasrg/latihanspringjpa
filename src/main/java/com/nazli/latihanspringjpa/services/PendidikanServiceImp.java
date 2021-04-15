package com.nazli.latihanspringjpa.services;

import com.nazli.latihanspringjpa.model.dto.PendidikanDto;
import com.nazli.latihanspringjpa.model.entity.PendidikanEntity;
import com.nazli.latihanspringjpa.model.entity.UserEntity;
import com.nazli.latihanspringjpa.repository.PendidikanRepository;
import com.nazli.latihanspringjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PendidikanServiceImp implements PendidikanService{
    @Autowired
    private PendidikanRepository pendidikanRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public PendidikanEntity insertPendidikanEntity(String username, PendidikanDto pendidikanDto) {
        if(pendidikanDto.getJenjang() != null){
            PendidikanEntity pendidikan = convertDtoToEntity(username, pendidikanDto);
            pendidikanRepository.save(pendidikan);
            return pendidikan;
        }
        else{
            return null;
        }
    }

    @Override
    public PendidikanEntity updatePendidikanEntity(Integer id, PendidikanDto dto) {
        PendidikanEntity pendidikan = pendidikanRepository.findById(id).get();

        if(dto.getKodePendidikan() != null){
            pendidikan.setKodePendidikan(dto.getKodePendidikan());
        }
        if(dto.getJenjang() != null){
            pendidikan.setJenjang(dto.getJenjang());
        }
        if(dto.getInstitusi() != null){
            pendidikan.setInstitusi(dto.getInstitusi());
        }
        if(dto.getStatus() != null){
            pendidikan.setStatus((dto.getStatus()));
        }
        UserEntity user = userRepository.findByUsername(dto.getUsername());
        pendidikan.setUser(user);

        pendidikanRepository.save(pendidikan);
        return pendidikan;
    }

    private PendidikanEntity convertDtoToEntity(String username, PendidikanDto pendidikanDto){
        PendidikanEntity pendidikan = new PendidikanEntity();
        UserEntity user = userRepository.findByUsername(username);

        pendidikan.setJenjang(pendidikanDto.getJenjang());
        pendidikan.setInstitusi(pendidikanDto.getInstitusi());
        pendidikan.setStatus(1);
        pendidikanRepository.save(pendidikan);

        pendidikan.setKodePendidikan("P" + pendidikan.getId());

        pendidikan.setUser(user);

        return pendidikan;
    }


}
