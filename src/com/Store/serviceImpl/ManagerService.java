package com.Store.serviceImpl;

import com.Store.Interface.ManagerInterface;
import com.Store.enumeration.Role;
import com.Store.model.Applicant;
import com.Store.model.Cashier;
import com.Store.model.Manager;

public class ManagerService implements ManagerInterface {
    @Override
    public Cashier hireACashier(Applicant applicant) {
        Cashier cashier = null;
        if (applicant.getAge() > 18 && applicant.getAge() < 30){
            if (applicant.getYearsOfExperience() > 2){
                cashier = new Cashier();
                cashier.setFirstName(applicant.getFirstName());
                cashier.setLastName(applicant.getLastName());
                cashier.setAge(applicant.getAge());
                cashier.setRole(Role.CASHIER);
                cashier.setGender(applicant.getGender());
                Manager.CASHIER_LIST.add(cashier);
                System.out.println("Successfully Hired");
            }else {
                System.out.println("Sorry, You Are InExperienced!");
            }
        }else {
            System.out.println("Sorry Unacceptable Age!!");
        }
        return cashier;
    }

    @Override
    public String fireACashier(String name) {
      if (findPositionOfCashierInList(name) > -1){
          Cashier cashier = Manager.CASHIER_LIST.get(findPositionOfCashierInList(name));
          Manager.CASHIER_LIST.remove(cashier);
          System.out.println("Contract Terminated");
      }
        return "Contract Terminated";
    }

    private int findPositionOfCashierInList(String name){
        for (Cashier cashier : Manager.CASHIER_LIST){
            if(cashier.getFirstName().equalsIgnoreCase(name) || cashier.getLastName().equalsIgnoreCase(name)){
                return Manager.CASHIER_LIST.indexOf(cashier);
            }
        }
        return  -1;
    }
//    Cashier cashier = new Cashier();
//    Scanner input = new Scanner(System.in);
//    ArrayList<String> employeeList = new ArrayList<>();
//
//    public void operations(){
//        displayMenu();
//        int option = input.nextInt();
//
//        while (true){
//            if (option == 1){
//                hire();
//            } else if (option == 2) {
//                fire();
//            } else if (option == 3) {
//                System.out.println("Hiring mode complete!");
//                break;
//            }
//            break;
//        }
//
//    }
//    @Override
//    public void hire() {
//        System.out.println("************Employee application data**************, " +
//                "Welcome to Los Polos!");
//        System.out.println(" ");
//        System.out.println("Enter your name: ");
//        cashier.setName(input.next());
//        System.out.println("Enter your age: ");
//        cashier.setAge(input.nextInt());
//        System.out.println("Enter your sex: ");
//        cashier.setSex(input.next());
//        System.out.println("Enter your year(s) of experience: ");
//        cashier.setLevelOfExp(input.nextInt());
//
//
//        String name = cashier.getName();
//        String sex = cashier.getSex();
//        int age = cashier.getAge();
//        int levelOfExp = cashier.getLevelOfExp();
//
//        while (true){
//            if (age >= 20 && age <= 30){
//                System.out.println("Suitable age!");
//            }
//            else {
//                System.out.println("You're not within the age limit. Try again next time, thank you!");
//                break;
//            }
//            if (levelOfExp < 2){
//                System.out.println("Not qualified for the job");
//                break;
//            }
//            else if (levelOfExp > 2){
//                System.out.println("All criteria met. You are qualified for the job!");
//                employeeList.add(name);
//                System.out.println("Name of Employees- " + employeeList);
//
//                break;
//            }
//        }
//        operations();
//    }
//
//    @Override
//    public void fire() {
//        System.out.println("*******EMPLOYEE CONTRACT TERMINATION DASHBOARD********");
//        System.out.println(" ");
//        System.out.println("Enter the name of employee whose contract is to be terminated: ");
//        String staffToBeSacked = input.next();
//        System.out.println("Mr " + staffToBeSacked + ", you violated the code of conduct of the company.");
//
//        employeeList.remove(staffToBeSacked);
//        System.out.println(" ");
//        System.out.println("Mr " + staffToBeSacked +
//                ", from this moment your Contract with Los Polos has been terminated, do have a successful life!");
//        System.out.println(employeeList);
//        operations();
//    }
//
//    private static void displayMenu() {
//        System.out.println("1. Hire option ");
//        System.out.println("2. Fire option");
//        System.out.println("3. Exit hiring mode");
//
//        System.out.println(" ");
//        System.out.print("Enter an option: ");
//
//    }


}
