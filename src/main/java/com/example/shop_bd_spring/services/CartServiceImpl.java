package com.example.shop_bd_spring.services;

import com.example.shop_bd_spring.dtos.CartDto;
import com.example.shop_bd_spring.models.Cart;
import com.example.shop_bd_spring.models.Person;
import com.example.shop_bd_spring.models.Product;
import com.example.shop_bd_spring.repositorys.CartRepository;
import com.example.shop_bd_spring.repositorys.PersonRepository;
import com.example.shop_bd_spring.repositorys.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartRepository cartRepository;

    @Override
    public Long createCart(Long personId, Long productId) {
        Person person = personRepository.findById(personId).get();
        Cart cart = new Cart();
        cart.setPerson(person);

        List<Product> products = new ArrayList<>();
        products.add(productRepository.findById(productId).get());
        cart.setProduct(products);

        return cartRepository.save(cart).getId();
    }

    @Override
    public List<Cart> getCart(Long cartId) {
        //    Optional<Cart> cart = cartRepository.findById(cartId);
        List<Cart> carts = new ArrayList<>();
        carts.add(cartRepository.findById(cartId).get());
        return carts;
    }


    @Override
    public List<CartDto> getAll() {

        return cartRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());

    }


    private CartDto toDto(Cart cart) {
        return CartDto.builder()
                .firstName(cart.getPerson().getFirstName())
                .lastName(cart.getPerson().getLastName())
                .email(cart.getPerson().getEmail())
                .product(cart.getProduct())
                .sum(cart.getSum())
                .build();

    }

}
