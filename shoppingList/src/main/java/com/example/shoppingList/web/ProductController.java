package com.example.shoppingList.web;

import com.example.shoppingList.model.binding.ProductAddBindingModel;
import com.example.shoppingList.model.service.ProductServiceModel;
import com.example.shoppingList.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(){

        return "product-add";
    }

    @PostMapping("/add")
    public String productConfirm(@Valid ProductAddBindingModel productAddBindingModel,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel", bindingResult);

            return "redirect:add";
        }

        ProductServiceModel productServiceModel = modelMapper.map(productAddBindingModel, ProductServiceModel.class);
        productService.add(productServiceModel);

        return "redirect:/";

    }

    @GetMapping("buy/{id}")
    public String buy(@PathVariable Long id){
        productService.buy(id);

        return "redirect:/";
    }

    @GetMapping("buy/all")
    private String buyAll(){
        productService.buyAll();

        return "redirect:/";
    }

    @ModelAttribute
    public ProductAddBindingModel productAddBindingModel(){
        return new ProductAddBindingModel();
    }
}
