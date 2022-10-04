package com.example.shop_bd_spring.services;

import com.example.shop_bd_spring.dtos.CartDto;
import com.example.shop_bd_spring.models.Cart;

import java.util.List;

public interface CartService {

    Long createCart(Long personId, Long productId);

    List<Cart> getCart (Long cartId);

    List<CartDto> getAll();
}
