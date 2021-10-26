package com.example.exam.repository;

import com.example.exam.model.entity.ShipEntity;
import com.example.exam.model.entity.UserEntity;
import com.example.exam.model.view.ShipViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<ShipEntity,Long> {
    List<ShipEntity> findAllByUser(UserEntity user);

    List<ShipEntity> findAllByUserNot(UserEntity user);

    ShipEntity findByName(String ship1);
}
