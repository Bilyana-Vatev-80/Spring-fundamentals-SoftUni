package com.example.shoppingList.web;

import com.example.shoppingList.model.entity.CategoryNameEnum;
import com.example.shoppingList.sec.CurrentUser;
import com.example.shoppingList.service.CategoryService;
import com.example.shoppingList.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ProductService productService;
    private final CategoryService categoryService;

    public HomeController(CurrentUser currentUser, ProductService productService, CategoryService categoryService) {
        this.currentUser = currentUser;
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping()
    public String index(Model model){
        if(currentUser.getId() == null){
            return "index";
        }

        // TODO mode.addAttributes();

        model.addAttribute("productViewModel",productService.findAllProducts());
        model.addAttribute("totalSum",productService.totalSum());

        model.addAttribute("drink", productService.findByCategoryNameEnum(CategoryNameEnum.DRINK));
        model.addAttribute("food",productService.findByCategoryNameEnum(CategoryNameEnum.FOOD));
        model.addAttribute("household",productService.findByCategoryNameEnum(CategoryNameEnum.HOUSEHOLD));
        model.addAttribute("other",productService.findByCategoryNameEnum(CategoryNameEnum.OTHER));
        return "home";
    }
}
