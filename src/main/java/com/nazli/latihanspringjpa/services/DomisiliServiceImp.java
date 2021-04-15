package com.nazli.latihanspringjpa.services;

import com.nazli.latihanspringjpa.model.dto.DomisiliDto;
import com.nazli.latihanspringjpa.model.entity.DetailUserEntity;
import com.nazli.latihanspringjpa.model.entity.DomisiliEntity;
import com.nazli.latihanspringjpa.repository.DetailUserRepository;
import com.nazli.latihanspringjpa.repository.DomisiliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DomisiliServiceImp implements DomisiliService{
    @Autowired
    private DomisiliRepository domisiliRepository;

    @Autowired
    private DetailUserRepository detailUserRepository;

    @Override
    public DomisiliEntity insertDomisiliEntity(DomisiliDto domisiliDto) {
        if(domisiliDto.getAlamat() != null){
            DomisiliEntity domisili = convertDtoToEntity(domisiliDto);
            domisiliRepository.save(domisili);
            return domisili;
        }
        else{
            return null;
        }
    }

    @Override
    public DomisiliEntity updateDomisiliEntity(Integer id, DomisiliDto dto) {
        DomisiliEntity domisili = domisiliRepository.findById(id).get();

        if(dto.getKodeDomisili() != null){
            domisili.setKodeDomisili(dto.getKodeDomisili());
        }
        if(dto.getAlamat() != null){
            domisili.setAlamat(dto.getAlamat());
        }
        if(dto.getKelurahan() != null){
            domisili.setKelurahan(dto.getKelurahan());
        }
        if(dto.getKecamatan() != null){
            domisili.setKecamatan(dto.getKecamatan());
        }
        if(dto.getKota() != null){
            domisili.setKota(dto.getKota());
        }
        if(dto.getKodePos() != null){
            domisili.setKodePos(dto.getKodePos());
        }
        if(dto.getStatus() != null){
            domisili.setStatus(dto.getStatus());
        }
        if(dto.getIdDetailUser() != null){
            DetailUserEntity detailUser = detailUserRepository.findById(dto.getIdDetailUser()).get();
            domisili.setDetailUser(detailUser);
        }

        domisiliRepository.save(domisili);
        return domisili;
    }

    private DomisiliEntity convertDtoToEntity(DomisiliDto domisiliDto){
        DomisiliEntity domisili = new DomisiliEntity();
        domisili.setAlamat(domisiliDto.getAlamat());
        domisili.setKelurahan(domisiliDto.getKelurahan());
        domisili.setKecamatan(domisiliDto.getKecamatan());
        domisili.setKota(domisiliDto.getKota());
        domisili.setKodePos(domisiliDto.getKodePos());
        domisili.setStatus(1);
        domisiliRepository.save(domisili);

        domisili.setKodeDomisili("D" + domisili.getId());

        DetailUserEntity detailUser = detailUserRepository.findById(domisiliDto.getIdDetailUser()).get();
        domisili.setDetailUser(detailUser);
        return domisili;
    }
}
