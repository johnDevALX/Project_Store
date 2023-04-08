package com.Store.serviceImpl;

import com.Store.enumeration.Gender;
import com.Store.model.Customer;
import com.Store.model.Order;
import com.Store.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CashierServiceTest {
    CashierService cashierService;
    @BeforeEach
    void setUp() {
        cashierService = new CashierService();
    }

    @Test
    void sellProductSuccessful() {
        String expected = "Successful!!!!";
        Customer customer = new Customer("Ben", "loy", 111, Gender.MALE, new BigDecimal(35000));
        Order order = new Order("banana", 50, customer);
        var c = cashierService.addToCart(order);
        var actual = cashierService.sellProduct(customer);
        assertEquals(expected , actual);
    }

    @Test
    void sellProductUnSuccessful() {
        String expected = "Insufficient fund";
        Customer customer = new Customer("Ben", "loy", 111, Gender.MALE, new BigDecimal(0));
        Order order = new Order("banana", 50, customer);
        var c = cashierService.addToCart(order);
        var actual = cashierService.sellProduct(customer);
        assertEquals(expected , actual);
    }

    @Test
    void ProductAddedToCart() {
        int expected = 2;
        Customer customer = new Customer("Ben", "loy", 111, Gender.MALE, new BigDecimal(350000));
//        Product product = new Product("banana", 12, 150, 300);
        Order order = new Order("banana", 50, customer);
        Order order2 = new Order("banana", 20, customer);
        Order order1 = new Order("cement", 5, customer);
        var c= cashierService.addToCart(order);
        var d= cashierService.addToCart(order1);
        var e= cashierService.addToCart(order2);
        assertEquals(expected , customer.getCart().size());
    }

    @Test
    void ProductNotAddedToCart() {
        int expected = 0;
        Customer customer = new Customer("Ben", "loy", 111, Gender.MALE, new BigDecimal(35000));
//        Product product = new Product("banana", 12, 150, 300);
        Order order = new Order("banana", 500000, customer);
        Order order1 = new Order("cementeee", 50, customer);
        var c= cashierService.addToCart(order);
        var d= cashierService.addToCart(order1);
        assertEquals(expected , customer.getCart().size());
    }



}