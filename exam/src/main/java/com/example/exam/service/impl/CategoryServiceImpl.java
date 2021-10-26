package com.example.exam.service.impl;

import com.example.exam.model.entity.CategoryEntity;
import com.example.exam.model.entity.CategoryNameEnum;
import com.example.exam.repository.CategoryRepository;
import com.example.exam.service.CategoryService;
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
        if(this.categoryRepository.count() == 0){
            Arrays.stream(CategoryNameEnum.values())
                    .forEach(categoryNameEnum -> {
                        CategoryEntity categoryEntity = new CategoryEntity();
                        categoryEntity.setName(categoryNameEnum);
                        switch (categoryNameEnum){
                            case BATTLE:
                                categoryEntity.setDescription("This is Battle: ");
                                break;
                            case CARGO:
                                categoryEntity.setDescription("This is Cargo: ");
                                break;
                            case PATROL:
                                categoryEntity.setDescription("This is Patrol: ");
                                break;
                        }

                        categoryRepository.save(categoryEntity);
                    });
        }
    }

    @Override
    public CategoryEntity findBy(CategoryNameEnum category) {
        return categoryRepository.findByName(category).orElse(null);
    }
}
