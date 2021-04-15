package com.nazli.latihanspringjpa.repository;

import com.nazli.latihanspringjpa.model.entity.DetailUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailUserRepository extends JpaRepository<DetailUserEntity, Integer> {
    @Query(value = "SELECT * FROM tbl_detail_user WHERE user_id = ?", nativeQuery = true)
    DetailUserEntity findByUserEntityId(Integer id);
}
