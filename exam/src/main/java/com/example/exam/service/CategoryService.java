package com.example.exam.service;

import com.example.exam.model.entity.CategoryEntity;
import com.example.exam.model.entity.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    CategoryEntity findBy(CategoryNameEnum category);
}
