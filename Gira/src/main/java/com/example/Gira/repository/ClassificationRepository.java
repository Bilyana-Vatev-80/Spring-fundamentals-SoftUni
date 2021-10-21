package com.example.Gira.repository;

import com.example.Gira.model.entity.Classification;
import com.example.Gira.model.entity.enums.ClassificationNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification,Long>{
    Optional<Classification> findByClassificationName(ClassificationNameEnum name);
}
