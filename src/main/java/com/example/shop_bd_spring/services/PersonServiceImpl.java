package com.example.shop_bd_spring.services;

import com.example.shop_bd_spring.dtos.PersonDto;
import com.example.shop_bd_spring.models.Cart;
import com.example.shop_bd_spring.models.Person;
import com.example.shop_bd_spring.repositorys.CartRepository;
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

    @Autowired
    private CartRepository cartRepository;

    @Override
    public void createPerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public Person findByFirstName(String name) {
        return personRepository.findByFirstName(name);

    }

    @Override
    public Person getPerson(Long id) {
        Optional<Person> person = personRepository.findById(id);
        return person.filter(p -> Objects.equals(p.getId(), id)).get();
    }

    @Override
    public void DeleteById(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public Person addCart(Long id) {
      Cart cart = new Cart();

        return null;
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
                .build();
    }
//    List<Cart> carts = new ArrayList<>();
//        carts.add(cartRepository.getReferenceById(cartRepository.save(cart).getId()));
//        person.setCart(carts);

}
