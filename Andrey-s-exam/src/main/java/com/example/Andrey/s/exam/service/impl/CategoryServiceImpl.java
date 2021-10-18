package com.example.Andrey.s.exam.service.impl;

import com.example.Andrey.s.exam.model.entity.Category;
import com.example.Andrey.s.exam.model.entity.enums.CategoryNameEnum;
import com.example.Andrey.s.exam.repository.CategoryRepository;
import com.example.Andrey.s.exam.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initCategories() {
        if(this.categoryRepository.count() != 0){
            return;
        }
        Arrays.stream(CategoryNameEnum.values())
                .forEach(categoryNameEnum -> {
                    this.categoryRepository.save(new Category(categoryNameEnum,
                            String.format("Description for %s", categoryNameEnum.name())));
                });
    }
}
