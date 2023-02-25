package com.Store.model;


import com.Store.enumeration.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Person {
    private String firstName;
    private String lastName;
    private int id;
    private Double age;
    private Role role;

    public Person() { }

    public Person(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    //Applicant
    public Person(String firstName, String lastName, Double age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person(String firstName, String lastName , int id, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.role = role;
    }
}
