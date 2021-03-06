package com.example.exam.service;

import com.example.exam.model.entity.UserEntity;
import com.example.exam.model.service.UserServiceModel;

public interface UserService {
    boolean isUserNameFree(String userName);

    boolean registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(UserServiceModel userServiceModel);

    UserEntity findById(Long id);
}
