package com.example.springdatajpaqueries.service;

import com.example.springdatajpaqueries.entity.Person;
import com.example.springdatajpaqueries.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public List<Person> findAllPeople(){
        return personRepository.findAll();
    }
    public List<Person> findAllPeopleNative(){
        return personRepository.findAllNative();
    }
    public Optional<Person> findByAge(int age){
        return personRepository.findByAge(age);
    }
    public Page<Person> findThreePagination(Pageable pageable){
        return personRepository.findThreePagination(pageable);
    }
}
