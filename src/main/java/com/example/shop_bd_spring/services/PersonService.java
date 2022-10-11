package com.example.shop_bd_spring.services;

import com.example.shop_bd_spring.dtos.PersonDto;
import com.example.shop_bd_spring.models.Person;

import java.util.List;

public interface PersonService {

    void createPerson(Person person);

    Person findByFirstName(String name);

    void DeleteById(Long id);

    void save(Person person);

    void addCart(Long productId, String name);

    List<PersonDto> getAll();


}
