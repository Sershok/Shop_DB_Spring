package com.example.shop_bd_spring.controllers;

import com.example.shop_bd_spring.dtos.ProductDto;
import com.example.shop_bd_spring.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.shop_bd_spring.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public Long createProduct(@RequestBody ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        productService.createProduct(product);
        return product.getId();
    }

    @GetMapping("/get")
    public List<ProductDto> getProduct() {
        return productService.getAll();
    }

    @DeleteMapping("/delete_{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
