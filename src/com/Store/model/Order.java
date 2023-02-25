package com.Store.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Order {
    private String orderName;
    private int desiredQuantity;
    private Customer customer;

}
