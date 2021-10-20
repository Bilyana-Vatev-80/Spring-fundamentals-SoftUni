package com.example.MyMusic.web;

import com.example.MyMusic.model.binding.AlbumAddBindingModel;
import com.example.MyMusic.model.service.AlbumServiceModel;
import com.example.MyMusic.service.AlbumService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService albumService;
    private final ModelMapper modelMapper;

    public AlbumController(AlbumService albumService, ModelMapper modelMapper) {
        this.albumService = albumService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String artist(){

        return "add-album";
    }

    @PostMapping("/add")
    public String addAlbumConfirm(@Valid AlbumAddBindingModel albumAddBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("albumAddBindingModel",albumAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.albumAddBindingModel",bindingResult);

            return "redirect:add";
        }

        AlbumServiceModel albumServiceModel = modelMapper.map(albumAddBindingModel, AlbumServiceModel.class);
        albumService.addAlbum(albumServiceModel);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteAlbum(@PathVariable Long id){
        albumService.removeAlbum(id);
        return "redirect:/";
    }

    @ModelAttribute
    public AlbumAddBindingModel albumAddBindingModel(){
        return new AlbumAddBindingModel();
    }
}
