package com.example.shop_bd_spring.services;

import com.example.shop_bd_spring.dtos.PersonDto;
import com.example.shop_bd_spring.models.Person;

import java.util.List;

public interface PersonService {

    void createPerson(Person person);

    Person findByFirstName(String name);

    Person getPerson(Long id);

    void DeleteById(Long id);

    Person addCart(Long id);

    List<PersonDto> getAll();





}
