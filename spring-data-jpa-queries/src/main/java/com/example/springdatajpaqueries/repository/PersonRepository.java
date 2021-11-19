package com.example.springdatajpaqueries.repository;

import com.example.springdatajpaqueries.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.*;
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query(value = "select * from person", nativeQuery = true)
    List<Person> findAllNative();

    Optional<Person> findByAge(int age);

    @Query("select p from Person p")
    Page<Person> findThreePagination(Pageable pageable);
}
