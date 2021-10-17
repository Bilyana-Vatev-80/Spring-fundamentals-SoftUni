package com.example.Coffee.Shop.Application.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping()
    public String index(){
        return "index";
    }
}
