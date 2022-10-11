package com.example.shop_bd_spring.services;

import com.example.shop_bd_spring.dtos.PersonDto;
import com.example.shop_bd_spring.models.Cart;
import com.example.shop_bd_spring.models.Person;
import com.example.shop_bd_spring.repositorys.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CartService cartService;

    @Override
    public void createPerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public Person findByFirstName(String name) {
        return personRepository.findByFirstName(name);

    }

    @Override
    public void DeleteById(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    public void addCart(Long productId, String name) {

        Person person = personRepository.findByFirstName(name);

        Cart cart = person.getCart();
        if (cart == null) {
            Cart newCart = cartService.createCart(person, Collections.singletonList(productId));
            person.setCart(newCart);
            save(person);
        } else {
            cartService.addProduct(cart,Collections.singletonList(productId));
        }
    }


    @Override
    public List<PersonDto> getAll() {
        return personRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());

    }

    private PersonDto toDto(Person person) {
        return PersonDto.builder()
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .email(person.getEmail())
                .cart(person.getCart())
                .build();
    }


}
