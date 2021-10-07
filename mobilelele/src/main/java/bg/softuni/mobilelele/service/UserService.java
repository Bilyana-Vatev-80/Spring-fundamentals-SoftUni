package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.service.UserLoginServiceModel;
import bg.softuni.mobilelele.model.service.UserRegistrationServiceModel;


public interface UserService {

    void initializeUsersAndRoles();

    boolean login(UserLoginServiceModel userLoginServiceModel);

    void logout();

    void registеrAndLoginUser(UserRegistrationServiceModel userRegistrationServiceModel);

    boolean isUserNameFree(String username);
}
