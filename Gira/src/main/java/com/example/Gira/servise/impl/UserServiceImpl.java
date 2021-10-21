package com.example.Gira.servise.impl;

import com.example.Gira.model.entity.User;
import com.example.Gira.model.service.UserServiceModel;
import com.example.Gira.repository.UserRepository;
import com.example.Gira.sec.CurrentUser;
import com.example.Gira.servise.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public UserServiceModel registerLogin(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);
        return modelMapper.map(userRepository.save(user), UserServiceModel.class);
    }

    @Override
    public boolean isUserExist(String email, String password) {
        return userRepository.existsByEmailAndPassword(email,password);
    }

    @Override
    public void loginUser(UserServiceModel userServiceModel) {
        User user = userRepository.findUserByEmail(userServiceModel.getEmail()).orElse(null);

        assert user != null;
        currentUser.setId(user.getId());
        currentUser.setUsername(user.getUsername());
    }


}
