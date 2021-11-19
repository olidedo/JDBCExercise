package com.example.springdatajpaqueries.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString @Getter @Setter
public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int employeeId;
    @Column
    private String jobTitle;
    @Column
    private boolean isEmployeed;
    @OneToOne
    private Person person;

}
