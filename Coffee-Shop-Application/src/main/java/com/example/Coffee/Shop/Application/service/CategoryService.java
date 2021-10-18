package com.example.Coffee.Shop.Application.service;

import com.example.Coffee.Shop.Application.model.entity.Category;
import com.example.Coffee.Shop.Application.model.entity.CategoryNameEnum;

public interface CategoryService {

    void initCategories();

    Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
