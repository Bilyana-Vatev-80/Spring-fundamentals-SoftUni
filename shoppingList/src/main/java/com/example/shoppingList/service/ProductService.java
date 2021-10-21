package com.example.shoppingList.service;

import com.example.shoppingList.model.entity.CategoryNameEnum;
import com.example.shoppingList.model.service.ProductServiceModel;
import com.example.shoppingList.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void add(ProductServiceModel productServiceModel);

    List<ProductViewModel> findAllProducts();

    BigDecimal totalSum();

    List<ProductViewModel> findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);

    void buy(Long id);

    void buyAll();

}
