package com.example.MyMusic.web;

import com.example.MyMusic.model.view.AlbumViewModel;
import com.example.MyMusic.security.CurrentUser;
import com.example.MyMusic.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final AlbumService albumService;

    public HomeController(CurrentUser currentUser, AlbumService albumService) {
        this.currentUser = currentUser;
        this.albumService = albumService;
    }

    @GetMapping()
    public String index(Model model){

        if(currentUser.getId() == null){
            return "index";
        }
        List<AlbumViewModel> albums = albumService.findAllAlbums();
        int totalSoldCopies = albums.stream()
                .map(AlbumViewModel::getCopies)
                .reduce(Integer::sum).orElse(0);

        model.addAttribute("albums",albums);
        model.addAttribute("totalSoldCopies",totalSoldCopies);

        return "home";
    }
}
