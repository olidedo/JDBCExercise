package com.example.springdatajpaqueries.controller;

import com.example.springdatajpaqueries.entity.Person;
import com.example.springdatajpaqueries.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class PersonController {
    @Autowired
    PersonService personService;

    public List<Person> findAllPeople() {
        return personService.findAllPeople();
    }

    public List<Person> findAllPeopleNative() {
        return personService.findAllPeopleNative();
    }

    public Optional<Person> findByAge(int age){
        return personService.findByAge(age);
    }
    public Page<Person> findThreePagination(Pageable pageable){
        return personService.findThreePagination(pageable);
    }
}
