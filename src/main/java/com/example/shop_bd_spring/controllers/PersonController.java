package com.example.shop_bd_spring.controllers;

import com.example.shop_bd_spring.dtos.PersonDto;
import com.example.shop_bd_spring.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.shop_bd_spring.services.PersonService;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/create")
    public Long createPerson(@RequestBody PersonDto personDto) {
        Person person = new Person();
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setEmail(personDto.getEmail());
        personService.createPerson(person);
        return person.getId();
    }

    @GetMapping("/get")
    public List<PersonDto> getPerson() {
        return personService.getAll();
    }

    @GetMapping("/get_'{id}'")
    public Person getByFirstName(@PathVariable String id) {
        return personService.findByFirstName(id);
    }

    @GetMapping("/cart_{personId}_'{name}'")
    public void addCart(@PathVariable Long personId, @PathVariable String name) {
        personService.addCart(personId, name);
    }

    @DeleteMapping("/delete_{id}")
    public void deleteById(@PathVariable Long id) {
        personService.DeleteById(id);
    }
}
