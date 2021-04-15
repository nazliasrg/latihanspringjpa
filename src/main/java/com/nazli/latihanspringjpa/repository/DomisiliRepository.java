package com.nazli.latihanspringjpa.repository;

import com.nazli.latihanspringjpa.model.entity.DomisiliEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomisiliRepository extends JpaRepository<DomisiliEntity, Integer> {
}
