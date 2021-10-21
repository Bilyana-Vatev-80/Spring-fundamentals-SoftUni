package com.example.shoppingList.service.impl;

import com.example.shoppingList.model.entity.CategoryNameEnum;
import com.example.shoppingList.model.entity.Product;
import com.example.shoppingList.model.service.ProductServiceModel;
import com.example.shoppingList.model.view.ProductViewModel;
import com.example.shoppingList.repository.ProductRepository;
import com.example.shoppingList.service.CategoryService;
import com.example.shoppingList.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void add(ProductServiceModel productServiceModel) {
        Product product = modelMapper.map(productServiceModel,Product.class);
        product.setCategory(categoryService.findByName(productServiceModel.getCategory()));

        productRepository.save(product);
    }

    @Override
    public List<ProductViewModel> findAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList.stream()
                .map(product -> modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal totalSum() {
        return findAllProducts().stream()
                .map(ProductViewModel::getPrice)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    @Override
    public List<ProductViewModel> findByCategoryNameEnum(CategoryNameEnum categoryNameEnum) {
        List<Product> productList = productRepository.findByCategory_Name(categoryNameEnum);
        return productList.stream().map(product -> modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void buy(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAll() {
        productRepository.deleteAll();
    }
}
