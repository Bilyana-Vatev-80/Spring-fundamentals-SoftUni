package com.example.exam.service;

import com.example.exam.model.entity.ShipEntity;
import com.example.exam.model.service.ShipServiceModel;
import com.example.exam.model.view.ShipViewModel;

import java.util.List;

public interface ShipService {

    boolean add(ShipServiceModel shipServiceModel);

   List<ShipViewModel> findAllShip();

    List<ShipViewModel> findByUser(Long id);

    List<ShipViewModel> findByUserNot(Long id);

    void fire(String ship1, String ship2);
}
