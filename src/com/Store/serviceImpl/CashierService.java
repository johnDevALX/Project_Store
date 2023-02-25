package com.Store.serviceImpl;

import com.Store.Interface.CashierInterface;
import com.Store.enumeration.TransactionStatus;
import com.Store.model.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import static com.Store.enumeration.TransactionStatus.*;

public class CashierService implements CashierInterface {
    @Override
    public String sellProduct(Customer customer) {
        Store store = Store.getInstance();
        int total = checkTotal(customer);

        if (customer.getBal().compareTo(BigDecimal.valueOf(total)) >= 1) {
            customer.setBal(customer.getBal().subtract(BigDecimal.valueOf(total)));
            store.setStoreBal(store.getStoreBal().add(BigDecimal.valueOf(total)));
            saveTransactionRecord(SUCCESSFUL, customer);
            System.out.println("Successful!!!!");
            customersReceipt(customer);
            return "Successful!!!!";
        } else {
            saveTransactionRecord(FAILED_INSUFFICIENT_FUND, customer);
            System.out.println("Insufficient fund");
            return "Insufficient fund";
        }
    }

    private TransactionRecord saveTransactionRecord(TransactionStatus transactionStatus, Customer customer) {
        TransactionRecord transactionRecord;
        Random random = new Random();
        transactionRecord = new TransactionRecord(random.nextInt(5), customer,
                LocalDateTime.now(), transactionStatus);
        Store.transactionRecords.add(transactionRecord);
        return transactionRecord;
    }

    public void printAllTransactionRecords() {
        for (TransactionRecord records : Store.transactionRecords) {
            System.out.println("Company Sales Record-" + records);
        }
    }

    public void customersReceipt(Customer customer){
        int total = checkTotal(customer);
        System.out.println("Thank You For Your Patronage, Your Total is: " + total);
    }

    public void printCustomerReceipt(Order order) {
        Customer customer;
    }

    public List<Order> addToCart(Order order) {
        if (Store.productList.contains(checkForProduct(Store.productList , order.getOrderName()))) {
            Product product = checkForProduct(Store.productList , order.getOrderName());
            if (order.getDesiredQuantity() < product.getQuantity()) {
                if (order.getCustomer().getCart().contains(checkForDubOrder(order.getCustomer().getCart(), order.getOrderName()))){
//                    product.setQuantity(product.getQuantity() - order.getDesiredQuantity());
                    Order dubOrder = checkForDubOrder(order.getCustomer().getCart(), order.getOrderName());
                    product.setQuantity(product.getQuantity() - order.getDesiredQuantity());
                    dubOrder.setDesiredQuantity(dubOrder.getDesiredQuantity() + order.getDesiredQuantity());
                    System.out.println(order.getDesiredQuantity() + " More " + order.getOrderName() + " Added!!!!");
                }else {
                    order.getCustomer().getCart().add(order);
                    product.setQuantity(product.getQuantity() - order.getDesiredQuantity());
                    System.out.println(order.getOrderName() + " Added To Cart!!!!!!!!!");
                }
            } else {
                saveTransactionRecord(FAILED_OUT_OF_STOCK, order.getCustomer());
                System.out.println("Product Out Of Stock");
            }
        } else {
            saveTransactionRecord(FAILED_PRODUCT_NOT_FOUND, order.getCustomer());
            System.out.println("Product Not Found!!!");
        }
        return order.getCustomer().getCart();
    }

//    private Product getAvailableProduct(String name) {
//        for (Product product : Store.productList) {
//            if (product.getProductName().equalsIgnoreCase(name)) {
//                return product;
//            }
//        }
//        return null;
//    }
//    private Product checkForRepeatedProduct(Customer customer, String name) {
//        for (Product product : customer.getCart()) {
//            if (product.getProductName().equalsIgnoreCase(name)) {
//                return product;
//            }
//        }
//        return null;
//    }

//    Dynamic method of the above 2 methods
    private Product checkForProduct(List<Product> productList, String name) {
        for (Product product : productList) {
            if (product.getProductName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }
    private Order checkForDubOrder(List<Order> productList, String name) {
        for (Order order : productList) {
            if (order.getOrderName().equalsIgnoreCase(name)) {
                return order;
            }
        }
        return null;
    }

    private int checkTotal(Customer customer){
        int total = 0;
        for (Order order: customer.getCart()) {
            Product product = checkForProduct(Store.productList , order.getOrderName());
            if (product != null)
                total += product.getPrice() * order.getDesiredQuantity();
            return total;
        }

        return 0;
    }
}

