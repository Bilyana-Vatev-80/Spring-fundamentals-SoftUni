package com.example.MyMusic.repository;

import com.example.MyMusic.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByUsername(String username);

    User findByUsernameAndPassword(String username, String password);
}
