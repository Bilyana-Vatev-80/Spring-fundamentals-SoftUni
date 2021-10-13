package bg.softuni.pathfinder.web;

import bg.softuni.pathfinder.modul.binding.UserLoginBindingModel;
import bg.softuni.pathfinder.modul.binding.UserRegisterBindingModel;
import bg.softuni.pathfinder.modul.service.UserServiceModel;
import bg.softuni.pathfinder.modul.view.UserViewProfile;
import bg.softuni.pathfinder.service.UserService;
import bg.softuni.pathfinder.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel(){
        return new UserRegisterBindingModel();
    }

    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel(){
        return new UserLoginBindingModel();
    }

    @GetMapping("/register")
    public String register(Model model){

        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes){

        // Check for input errors
        if(bindingResult.hasErrors() || !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())){
            redirectAttributes.addFlashAttribute("userRegisterBindingModel",userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

            return "redirect:register";
        }

        // Check for username exist
        //TODO
        UserServiceModel userServiceModel = modelMapper.map(userRegisterBindingModel, UserServiceModel.class);
        if(userService.isNameExist(userServiceModel.getUsername())){
            redirectAttributes
                    .addFlashAttribute("userRegisterBindingModel",userRegisterBindingModel)
                    .addFlashAttribute("userNameOccupied", true);
            System.out.println("I'm there");

            return "redirect:register";
        }
        userService.registerUser(userServiceModel);

        return "redirect:login";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("isExists",true);
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid UserLoginBindingModel userLoginBindingModel,BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("userLoginBindingModel",userLoginBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

            return "redirect:login";
        }

        UserServiceModel user = userService.findUserByUsernameAndPassword(userLoginBindingModel.getUsername(),userLoginBindingModel.getPassword());

        if(user == null){
            redirectAttributes
                    .addFlashAttribute("isExists", false)
                    .addFlashAttribute("userLoginBindingModel",userLoginBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);

            return "redirect:login";
        }

        userService.loginUser(user.getId(),user.getUsername());


        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(){
        userService.logout();
        return "redirect:/";
    }

    @GetMapping("/profile/{id}")
    public String profile(@PathVariable Long id,Model model){

        model.addAttribute("user",modelMapper.map(userService.findById(id), UserViewProfile.class));
        return "profile";
    }

}
