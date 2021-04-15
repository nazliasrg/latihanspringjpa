package com.nazli.latihanspringjpa.repository;

import com.nazli.latihanspringjpa.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
    @Query(value = "select username from table_user where username = ?", nativeQuery = true)
    public String findUsernameByUsername(String username);
}
