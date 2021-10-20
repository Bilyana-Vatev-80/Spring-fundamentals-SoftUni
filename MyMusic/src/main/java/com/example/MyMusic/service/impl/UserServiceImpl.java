package com.example.MyMusic.service.impl;

import com.example.MyMusic.model.entity.User;
import com.example.MyMusic.model.service.UserServiceModel;
import com.example.MyMusic.repository.UserRepository;
import com.example.MyMusic.security.CurrentUser;
import com.example.MyMusic.service.UserService;
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
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);
        return modelMapper.map(userRepository.save(user), UserServiceModel.class);
    }

    @Override
    public boolean loginUser(UserServiceModel userServiceModel) {
        User user = userRepository.findByUsernameAndPassword(userServiceModel.getUsername(),userServiceModel.getPassword());

        if(user == null){
            return false;
        }

        currentUser.setUsername(user.getUsername());
        currentUser.setId(user.getId());
        return true;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

}
