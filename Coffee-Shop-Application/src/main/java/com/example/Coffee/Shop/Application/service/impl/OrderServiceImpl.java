package com.example.Coffee.Shop.Application.service.impl;

import com.example.Coffee.Shop.Application.currentUser.CurrentUser;
import com.example.Coffee.Shop.Application.model.entity.Order;
import com.example.Coffee.Shop.Application.model.service.OrderServiceModel;
import com.example.Coffee.Shop.Application.repository.OrderRepository;
import com.example.Coffee.Shop.Application.service.CategoryService;
import com.example.Coffee.Shop.Application.service.OrderService;
import com.example.Coffee.Shop.Application.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void addOrder(OrderServiceModel orderServiceModel) {
        Order order = modelMapper.map(orderServiceModel, Order.class);
        order.setEmployee(userService.findById(currentUser.getId()));
        order.setCategory(categoryService.findByCategoryNameEnum(orderServiceModel.getCategory()));

        orderRepository.save(order);
    }
}
