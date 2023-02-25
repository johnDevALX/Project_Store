package com.Store.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Store {
    static Store store = new Store();
    public static List<Product> productList = new ArrayList<>();
    public static List<TransactionRecord> transactionRecords = new ArrayList<>();
    private BigDecimal storeBal = BigDecimal.valueOf(0.00);

    private Store(){
    }
    public static Store getInstance(){
        return store;
    }

    static {
        productList.addAll(List.of(
                new Product("banana", 111, 100, 150),
                new Product("cement", 131, 5000, 300),
                new Product("biscuit", 161, 50, 500),
                new Product("peanut", 121, 100, 150)
        ));
    }

    public BigDecimal getStoreBal() {
        return storeBal;
    }

    public void setStoreBal(BigDecimal storeBal) {
        this.storeBal = storeBal;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeBal=" + storeBal +
                '}';
    }
}
