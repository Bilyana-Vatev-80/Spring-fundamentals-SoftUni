package com.example.Gira.repository;

import com.example.Gira.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByEmailAndPassword(String email, String password);

    Optional<User> findUserByEmail(String email);
}
