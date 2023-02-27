package com.Store.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
