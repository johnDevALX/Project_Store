package com.Store.model;

import com.Store.enumeration.Gender;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Customer extends Person{
    private Gender gender;
    private BigDecimal bal;
    private List<Order> cart;
    public Customer (){
        super();
    }

    public Customer(String firstName, String lastName, int id, Gender gender, BigDecimal bal) {
        super(firstName, lastName, id);
        cart = new ArrayList<>();
        this.gender = gender;
        this.bal = bal;
    }

    @Override
    public String toString() {
        return "Customer{Firstname: " + super.getFirstName() + " Lastname: " + super.getLastName() +
                " id: " + super.getId() +
                "gender=" + gender +
                ", bal=" + bal +
                ", listOfItemInCart= " + cart +
                '}';
    }
}
