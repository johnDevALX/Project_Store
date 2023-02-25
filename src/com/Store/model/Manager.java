package com.Store.model;

import com.Store.enumeration.Role;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Person{

    public static List<Cashier> CASHIER_LIST = new ArrayList<>();

    public Manager(String firstName, String lastName, int id, Role role) {

        super(firstName, lastName, id, role);
    }
}
