package com.example.learn_spring_security.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.learn_spring_security.entities.CustomUser;

@Repository
public interface UserRepository  extends JpaRepository<CustomUser, Long>{
    Optional<CustomUser>findByUsername(String username);
}
