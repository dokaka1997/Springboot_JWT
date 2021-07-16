package com.dvdo.repository;

import com.dvdo.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> getByUsernameAndPassword(String username, String password);

    Optional<UserEntity> getByUsername(String username);
}
