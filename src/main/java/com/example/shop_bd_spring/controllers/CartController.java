package com.example.shop_bd_spring.controllers;

import com.example.shop_bd_spring.dtos.CartDto;
import com.example.shop_bd_spring.models.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.shop_bd_spring.services.CartService;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/get")
    public List<CartDto> getCart() {
        return cartService.getAll();
    }

    @GetMapping("/get_{id}")
    public List<Cart> getCart(@PathVariable Long id){
        return cartService.getCart(id);
    }

    @DeleteMapping("/delete_{id}")
    public void deleteById(@PathVariable Long id) {
        cartService.deleteById(id);
    }
}
