package com.Store.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {
    private String productName;
    private int productId;
    private int price;
    private int quantity;

    public Product() {
    }

    public Product(String name, int productId, int price, int quantity){
        this.productName = name;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }
}
