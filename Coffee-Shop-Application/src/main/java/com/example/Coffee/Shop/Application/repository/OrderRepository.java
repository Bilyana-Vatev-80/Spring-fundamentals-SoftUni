package com.example.Coffee.Shop.Application.repository;

import com.example.Coffee.Shop.Application.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {


}
