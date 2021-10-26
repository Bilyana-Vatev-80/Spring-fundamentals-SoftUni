package com.example.exam.web;

import com.example.exam.model.binding.ShipAddBindingModel;
import com.example.exam.model.service.ShipServiceModel;
import com.example.exam.service.ShipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/ships")
public class ShipController {

    private final ShipService shipService;
    private final ModelMapper modelMapper;

    public ShipController(ShipService service, ModelMapper modelMapper) {
        this.shipService = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(){
        return "ship-add";
    }

    @ModelAttribute
    public ShipAddBindingModel shipAddBindingModel(){
        return new ShipAddBindingModel();
    }

    @PostMapping("/add")
    public String shipAddConfirm(@Valid ShipAddBindingModel shipAddBindingModel,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("shipAddBindingModel",shipAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.shipAddBindingModel", bindingResult);

            return "redirect:add";
        }

        ShipServiceModel shipServiceModel = modelMapper.map(shipAddBindingModel, ShipServiceModel.class);

        boolean success = shipService.add(shipServiceModel);

        if (!success){
            redirectAttributes.addFlashAttribute("shipAddBindingModel", shipAddBindingModel);
            redirectAttributes.addFlashAttribute("shipNameOccupied", true);
            return "redirect:add";
        }

        return "redirect:/";
    }
}
