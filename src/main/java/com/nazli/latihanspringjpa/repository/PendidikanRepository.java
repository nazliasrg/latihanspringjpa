package com.nazli.latihanspringjpa.repository;

import com.nazli.latihanspringjpa.model.entity.PendidikanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PendidikanRepository extends JpaRepository<PendidikanEntity, Integer> {

}
