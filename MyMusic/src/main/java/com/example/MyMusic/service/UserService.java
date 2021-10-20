package com.example.MyMusic.service;

import com.example.MyMusic.model.entity.User;
import com.example.MyMusic.model.service.UserServiceModel;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    boolean loginUser(UserServiceModel userServiceModel);

    User findById(Long id);
}
