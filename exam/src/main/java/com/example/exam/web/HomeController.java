package com.example.exam.web;

import com.example.exam.model.binding.BattleBindingModel;
import com.example.exam.model.view.ShipViewModel;
import com.example.exam.service.ShipService;
import com.example.exam.user.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private ShipService shipService;

    public HomeController(CurrentUser currentUser, ShipService shipService) {
        this.currentUser = currentUser;
        this.shipService = shipService;
    }

    @GetMapping("/")
    public String home(Model model){
        if (currentUser.getId()==null){
            return "index";
        }
        model.addAttribute("AllShip",shipService.findAllShip());
        model.addAttribute("loggedUserShips", shipService.findByUser(currentUser.getId()).stream().map(ShipViewModel::getName)
                .collect(Collectors.toList()));
        model.addAttribute("notLoggedUserShips", shipService.findByUserNot(currentUser.getId()).stream().map(ShipViewModel::getName)
                .collect(Collectors.toList()));
        List<String> names = shipService.findAllShip().stream().map(ShipViewModel::getName)
                .collect(Collectors.toList());

        model.addAttribute("names", names);
        model.addAttribute("name1","");
        model.addAttribute("name2","");
        return "home";
    }

    @ModelAttribute
    public BattleBindingModel battleBindingModel() {
        return new BattleBindingModel();
    }

    @GetMapping("fire/{name1}/{name2}")
    public String fire(@PathVariable String name1, @PathVariable String name2, Model model) {
        model.addAttribute("name1");
        model.addAttribute("name2");
        shipService.fire(name1, name2);
        return "redirect:/";
    }
}
