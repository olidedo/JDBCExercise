package com.example.springdatajpaqueries;

import com.example.springdatajpaqueries.controller.EmployeeController;
import com.example.springdatajpaqueries.controller.PersonController;
import com.example.springdatajpaqueries.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringDataJpaQueriesApplication {

    @Autowired
    PersonController personController;
    @Autowired
    EmployeeController employeeController;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaQueriesApplication.class, args);
    }

    @PostConstruct
    public void startService() {
        //Print all people
        /*List<Person> people = personController.findAllPeople();
        people.forEach(System.out::println);*/

        //Print all people with native query
        /*List<Person> people = personController.findAllPeopleNative();
        people.forEach(System.out::println);*/

        //Print all ex employees
        /*List<Employee> exEmployees = employeeController.findExEmployees();
        exEmployees.forEach(System.out::println);*/

        //See if a person is employeed by ID
        /*System.out.println(employeeController.isEmployeed(1));
        System.out.println(employeeController.isEmployeedParam(2));*/

        //Find by age with Optional
        /*Optional<Person> foundByAge = personController.findByAge(99);
        if (foundByAge.isPresent()) {
            foundByAge.stream().forEach(System.out::println);
        } else {
            System.out.println("No person with this age");
        }*/

        //Show people with pagination
        final Sort.Direction sortOrder = Sort.Direction.ASC;
        final Sort.Order order = new Sort.Order(sortOrder, "surname").ignoreCase();
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(order));

        Page<Person> threePeople = personController.findThreePagination(pageRequest);
        threePeople.forEach(System.out::println);

    }

}
