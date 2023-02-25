package com.Store.model;

import com.Store.enumeration.Gender;
import com.Store.enumeration.Role;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cashier extends Person{
    private Gender gender;
    public Cashier(){
        super();
    }
    public Cashier(String firstName, String lastName, Gender gender , int id, Role role) {
        super(firstName, lastName , id, role);
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Cashier{Firstname: " + super.getFirstName() +
                " Lastname: " + super.getLastName() +
                " gender=" + gender +
                ", Id: " + super.getId() +
                " Role: " + super.getRole() +
                '}';
    }
}
