package com.example.shop_bd_spring.services;

import com.example.shop_bd_spring.dtos.ProductDto;
import com.example.shop_bd_spring.models.Product;

import java.util.List;

public interface ProductService {

    Long createProduct(Product product);

    void deleteById(Long id);

    List<ProductDto> getAll();

}
