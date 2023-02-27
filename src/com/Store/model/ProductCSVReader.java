package com.Store.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class ProductCSVReader {
    private String filePath;
    public  ProductCSVReader(String filePath){
        this.filePath = filePath;
    }

//    public static void createProductCSV() {
//        Product banana = new Product("banana", 111, 100, 150);
//        Product cement = new Product("cement", 121, 5000, 70);
//        Product biscuit = new Product("biscuit", 131, 50, 200);
//        Product peanut = new Product("peanut", 141, 100, 150);
//        Product fish = new Product("fish", 151, 1000, 50);
//        List<Product> productList = new ArrayList<>(List.of(banana, cement, biscuit, peanut, fish));
//
//
//        File productCSV = new File("C:\\Users\\HP-PC\\Ekene_Files\\store\\src\\com\\Store\\model\\Product_csv.csv");
//        PrintWriter pw = null;
//        try {
//            pw = new PrintWriter(productCSV);
//            for (Product product : productList) {
//                pw.printf("%s,%d,%d,%d\n", product.getProductName(), product.getProductId(),  product.getPrice(), product.getQuantity());
//            }
//            System.out.println("Created Successfully");
//        } catch (IOException e) {
//            System.out.println("An Error Occurred");
//            e.printStackTrace();
//        }
//        if (pw != null){
//            pw.close();
//        }
//    }

    public void readProductCsv(){
//        String path = "C:\\Users\\HP-PC\\Ekene_Files\\store\\src\\com\\Store\\model\\Product_csv.csv";
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.filePath));
            String line = " ";

            String productName = "";
            int productId = 0;
            int productPrice = 0;
            int productQty = 0;
            String[]  values = null;
            while ((line = br.readLine()) != null){
                values = line.split(",");

                productName = values[0];
                productId = Integer.parseInt(values[1]);
                productPrice = Integer.parseInt(values[2]);
                productQty = Integer.parseInt(values[3]);

                Product product = new Product(productName, productId, productPrice, productQty);
                Store.productList.add(product);
            }
        } catch (IOException e) {
            System.out.println("An Error Occurred");
            e.printStackTrace();
        }
        
    }

}


