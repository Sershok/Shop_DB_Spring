package com.example.shop_bd_spring.services;

import com.example.shop_bd_spring.dtos.CartDto;
import com.example.shop_bd_spring.models.Cart;
import com.example.shop_bd_spring.models.Person;

import java.util.List;

public interface CartService {

    Cart createCart(Person person, List<Long> productId);

    List<Cart> getCart (Long cartId);

    List<CartDto> getAll();

    void deleteById(Long id);

    void addProduct(Cart cart, List<Long> productId);
}
