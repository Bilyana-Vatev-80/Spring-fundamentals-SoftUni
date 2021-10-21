package com.example.shoppingList.service.impl;

import com.example.shoppingList.model.entity.Category;
import com.example.shoppingList.model.entity.CategoryNameEnum;
import com.example.shoppingList.repository.CategoryRepository;
import com.example.shoppingList.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Locale;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initialisedCategory() {
        if(categoryRepository.count() == 0){
            Arrays.stream(CategoryNameEnum.values())
                    .forEach(categoryNameEnum -> {
                        Category category = new Category();
                        category.setName(categoryNameEnum);
                        switch (categoryNameEnum){
                            case FOOD:
                                category.setDescription("This food category");
                                break;
                            case DRINK:
                                category.setDescription("This drink category");
                                break;
                            case HOUSEHOLD:
                                category.setDescription("This household category");
                                break;
                            case OTHER:
                                category.setDescription("This other category");
                                break;
                        }
                        categoryRepository.save(category);
                    });
        }
    }

    @Override
    public Category findByName(CategoryNameEnum category) {
        return categoryRepository.findByName(category)
                .orElse(null);
    }
}
