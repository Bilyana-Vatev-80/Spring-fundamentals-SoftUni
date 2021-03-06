package com.example.Coffee.Shop.Application.service;

import com.example.Coffee.Shop.Application.model.entity.User;
import com.example.Coffee.Shop.Application.model.service.UserServiceModel;
import com.example.Coffee.Shop.Application.model.view.UserViewModel;

import java.util.List;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findById(Long id);

    List<UserViewModel> findAllUserAndCountOfOrdersByCountDesc();
}
