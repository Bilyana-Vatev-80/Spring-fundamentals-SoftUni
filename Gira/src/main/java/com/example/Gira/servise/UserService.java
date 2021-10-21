package com.example.Gira.servise;

import com.example.Gira.model.service.UserServiceModel;

public interface UserService {
    UserServiceModel registerLogin(UserServiceModel userServiceModel);

    boolean isUserExist(String email, String password);

    void loginUser(UserServiceModel userServiceModel);

}
