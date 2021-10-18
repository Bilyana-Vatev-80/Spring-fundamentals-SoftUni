package com.example.Coffee.Shop.Application.service;

import com.example.Coffee.Shop.Application.model.service.OrderServiceModel;
import com.example.Coffee.Shop.Application.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {

    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrderOrderByPriceDescending();

    void readyOrder(Long id);
}
