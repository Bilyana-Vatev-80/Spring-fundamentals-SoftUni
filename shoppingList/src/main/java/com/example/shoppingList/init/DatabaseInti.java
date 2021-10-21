package com.example.shoppingList.init;

import com.example.shoppingList.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInti implements CommandLineRunner {

    private final CategoryService categoryService;

    public DatabaseInti(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.initialisedCategory();
    }
}
