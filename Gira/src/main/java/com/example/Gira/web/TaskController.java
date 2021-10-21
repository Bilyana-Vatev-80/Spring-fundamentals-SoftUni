package com.example.Gira.web;

import com.example.Gira.model.binding.TaskBindingModel;
import com.example.Gira.model.service.TaskServiceModel;
import com.example.Gira.servise.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;
    private final ModelMapper modelMapper;

    public TaskController(TaskService taskService, ModelMapper modelMapper) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("add")
    public String add(){

        return "add-task";
    }

    @PostMapping("add")
    public String addConfig(@Valid TaskBindingModel taskBindingModel,
                            BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
                redirectAttributes.addFlashAttribute("taskBindingModel",taskBindingModel);
                redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskBindingModel",bindingResult);

                return "redirect:add";
        }

        TaskServiceModel taskServiceModel = modelMapper.map(taskBindingModel, TaskServiceModel.class);
        taskService.add(taskServiceModel);

        return "redirect:/";
    }

    @GetMapping("progress/{id}")
    public String changeProgress(@PathVariable Long id){
        taskService.changeProgress(id);

        return "redirect:/";
    }

    @ModelAttribute
    public TaskBindingModel taskBindingModel(){
      return new TaskBindingModel();
    }
}
