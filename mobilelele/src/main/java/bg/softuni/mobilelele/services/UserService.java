package bg.softuni.mobilelele.services;

import bg.softuni.mobilelele.model.service.UserLoginServiceModel;



public interface UserService {

    void initializeUsers();

    boolean login(UserLoginServiceModel userLoginServiceModel);
}
