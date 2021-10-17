package com.example.Coffee.Shop.Application.service.impl;

import com.example.Coffee.Shop.Application.model.entity.Category;
import com.example.Coffee.Shop.Application.model.entity.CategoryNameEnum;
import com.example.Coffee.Shop.Application.repository.CategoryRepository;
import com.example.Coffee.Shop.Application.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if(this.categoryRepository.count() != 0){
            return;
        }
        Arrays.stream(CategoryNameEnum.values())
                .forEach(categoryNameEnum -> {
                    Category category = new Category();
                    category.setName(categoryNameEnum);
                    switch (categoryNameEnum){
                        case Coffee:
                            category.setNeededTime(2);
                            break;
                        case Drink:
                            category.setNeededTime(1);
                            break;
                        case Cake:
                            category.setNeededTime(10);
                            break;
                        case Other:
                            category.setNeededTime(5);
                            break;
                    }
                    categoryRepository.save(category);
                });
    }

    @Override
    public Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum) {
        return categoryRepository.findByName(categoryNameEnum)
                .orElse(null);
    }
}
