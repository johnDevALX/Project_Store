import com.Store.enumeration.Gender;
import com.Store.model.*;
import com.Store.serviceImpl.*;

import java.math.BigDecimal;
import java.util.Scanner;


public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ManagerService managerService = new ManagerService();

//        System.out.print("Number Of Cashiers To Hire: ");
//        int numToHire = scanner.nextInt();
//        int i = 0;
//        while (i <= numToHire){
//            System.out.print("Enter First Name:");
//            String firstName = scanner.next();
//            System.out.print("Enter Last Name:");
//            String lastName = scanner.next();
//            System.out.print("Enter age:");
//            Double age = scanner.nextDouble();
//            System.out.println("Enter your gender (MALE, FEMALE, OTHERS):");
//            Gender gender = Gender.valueOf(scanner.next().toUpperCase());
//
//
//            System.out.print("Enter Years Of Experience:");
//            int years = scanner.nextInt();
//            Applicant applicant = new Applicant(firstName , lastName , age , gender, years);
//            managerService.hireACashier(applicant);
//            i++;
//        }
//       Applicant applicant2 = new Applicant("ekene", "ilo", 25.0, 1);
//       Applicant applicant4 = new Applicant("another", "guy", 25.0, 5);
//       Applicant applicant3 = new Applicant("pizza", "ro", 18.0, 3);

//       managerService.hireACashier(applicant2);
//       managerService.hireACashier(applicant3);
//       managerService.hireACashier(applicant4);

        System.out.println(Store.productList);
//       for (Cashier cashier : CASHIER_LIST){
//           System.out.println(cashier);
//       }

//       managerService.fireACashier("Vin");
//
//        for (Cashier cashier : CASHIER_LIST){
//            System.out.println(cashier);
//        }
        CashierService cashierService = new CashierService();
        Customer customer1 = new Customer("Ben",
                "Vin", 102,
                Gender.MALE, BigDecimal.valueOf(26000));
        Customer customer2 = new Customer("Roy",
                "Loy", 112,
                Gender.FEMALE, BigDecimal.valueOf(350000));


        Order order1 = new Order("cement", 5, customer2);
        Order order2 = new Order("cement", 2, customer1);
        Order order3 = new Order("cement", 2, customer1);
//        Order order2 = new Order("cement", 5, customer2);
//        Order order3 = new Order("cementfcd", 5, customer2);
//        Order order4 = new Order("biscuit", 50000, customer2);
//        Order order5 = new Order("peanut", 30, customer1);
//        Order order5 = new Order("peanut", 30, customer2);
//        Order order6 = new Order("banana", 20, customer2);
//        Order order7 = new Order("biscuit", 50, customer2);
//        Order order8 = new Order("cement", 2, customer2);
//        Order order1 = new Order("Banana", 20, customer1);

        cashierService.addToCart(order1);
        cashierService.addToCart(order2);
        cashierService.addToCart(order3);
//        cashierService.addToCart(order3);
//        cashierService.addToCart(order4);
//        cashierService.addToCart(order5);

//        cashierService.sellProduct(customer1);
        cashierService.sellProduct(customer2);
        cashierService.sellProduct(customer1);
//        cashierService.sellProduct(order5);
//        cashierService.sellProduct(order6);
//        cashierService.sellProduct(order7);
//        cashierService.sellProduct(order8);
        cashierService.printAllTransactionRecords();

        System.out.println("===================###############################============");
        for (Product product : Store.productList){
            System.out.println(product);
        }

        System.out.println("==========================================");

        System.out.println(Store.getInstance().getStoreBal());



        System.out.println("==========================================");

        System.out.println(customer1);
        System.out.println(customer2);


    }

}