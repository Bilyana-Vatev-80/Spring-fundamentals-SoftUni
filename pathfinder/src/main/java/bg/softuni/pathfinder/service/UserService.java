package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.modul.service.UserServiceModel;

public interface UserService {

    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    void logout();

    UserServiceModel findById(Long id);
}
