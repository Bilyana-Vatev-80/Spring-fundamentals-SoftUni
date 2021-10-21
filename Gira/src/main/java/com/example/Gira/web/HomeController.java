package com.example.Gira.web;

import com.example.Gira.model.entity.enums.ClassificationNameEnum;
import com.example.Gira.model.entity.enums.ProgressEnum;
import com.example.Gira.sec.CurrentUser;
import com.example.Gira.servise.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final TaskService taskService;

    public HomeController(CurrentUser currentUser, TaskService taskService) {
        this.currentUser = currentUser;
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String index(Model model){
        if(currentUser.getId() == null){
            return "index";
        }
        model.addAttribute("task",taskService.findAll());
        model.addAttribute("progresses", ProgressEnum.values());
        model.addAttribute("classifications", ClassificationNameEnum.values());
        return "home";
    }
}
