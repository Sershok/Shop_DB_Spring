package com.example.shop_bd_spring.services;

import com.example.shop_bd_spring.dtos.CartDto;
import com.example.shop_bd_spring.models.Cart;
import com.example.shop_bd_spring.models.Person;
import com.example.shop_bd_spring.models.Product;
import com.example.shop_bd_spring.repositorys.CartRepository;
import com.example.shop_bd_spring.repositorys.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart createCart(Person person, List<Long> productId) {
        Cart cart = new Cart();
        cart.setPerson(person);

        List<Product> products = getProductRef(productId);
        cart.setProduct(products);
        cart.setSum(sumCart(cart));
        return cartRepository.save(cart);
    }

    private List<Product> getProductRef(List<Long> productId) {
        return productId.stream().map(productRepository::getOne).collect(Collectors.toList());
    }

    @Override
    public List<Cart> getCart(Long cartId) {
        List<Cart> carts = new ArrayList<>();
        carts.add(cartRepository.findById(cartId).get());
        return carts;
    }


    @Override
    public List<CartDto> getAll() {

        return cartRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());

    }

    @Override
    public void deleteById(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public void addProduct(Cart cart, List<Long> productId) {
        List<Product> products = cart.getProduct();
        List<Product> newProducts = products == null ? new ArrayList<>() : new ArrayList<>(products);
        newProducts.addAll(getProductRef(productId));
        cart.setProduct(newProducts);

        cart.setSum(sumCart(cart));

        cartRepository.save(cart);
    }

    private BigDecimal sumCart(Cart cart) {
        Iterator<Product> itr = cart.getProduct().listIterator();
        BigDecimal add = new BigDecimal("0.00");
        while (itr.hasNext()) {
            add = cart.getSum().add(itr.next().getPrice());
        }

        return add;
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
