package com.example.exam.service.impl;

import com.example.exam.model.entity.CategoryEntity;
import com.example.exam.model.entity.ShipEntity;
import com.example.exam.model.entity.UserEntity;
import com.example.exam.model.service.ShipServiceModel;
import com.example.exam.model.view.ShipViewModel;
import com.example.exam.repository.ShipRepository;
import com.example.exam.service.CategoryService;
import com.example.exam.service.ShipService;
import com.example.exam.service.UserService;
import com.example.exam.user.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {
    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CurrentUser currentUser;
    private final CategoryService categoryService;

    public ShipServiceImpl(ShipRepository shipRepository, ModelMapper modelMapper, UserService userService, CurrentUser currentUser, CategoryService categoryService) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.currentUser = currentUser;
        this.categoryService = categoryService;
    }

    @Override
    public boolean add(ShipServiceModel shipServiceModel) {
        ShipEntity shipEntity = modelMapper.map(shipServiceModel, ShipEntity.class);
        CategoryEntity category = categoryService.findBy(shipServiceModel.getCategory());
        UserEntity userEntity = userService.findById(currentUser.getId());

        if(userEntity != null && category != null){
            shipEntity.setCategory(category);
            shipEntity.setUser(userEntity);
        }

        try {
            shipRepository.save(shipEntity);
        } catch (Exception e){
            return false;
        }
        return true;
    }


    @Override
    public List<ShipViewModel> findByUser(Long id) {
        UserEntity user = userService.findById(id);

        List<ShipEntity> ships = shipRepository.findAllByUser(user);
        return ships.stream().map(shipEntity -> modelMapper.map(shipEntity, ShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipViewModel> findByUserNot(Long id) {
        UserEntity user = userService.findById(id);

        List<ShipEntity> ships = shipRepository.findAllByUserNot(user);

        return ships.stream().map(shipEntity -> modelMapper.map(shipEntity, ShipViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void fire(String ship1, String ship2) {
        ShipEntity attacker = shipRepository.findByName(ship1);
        ShipEntity defender = shipRepository.findByName(ship1);

        if(attacker != null && defender != null){
            Integer power = attacker.getPower();
            Integer health = defender.getHealth();

            if(health - power <= 0){
                shipRepository.delete(defender);
            } else {
                defender.setHealth(health - power);
                shipRepository.save(defender);
            }
        }
    }

    @Override
    public List<ShipViewModel> findAllShip() {
        return shipRepository.findAll()
                .stream()
                .map(shipEntity -> modelMapper.map(shipEntity, ShipViewModel.class)).collect(Collectors.toList());
    }
}
