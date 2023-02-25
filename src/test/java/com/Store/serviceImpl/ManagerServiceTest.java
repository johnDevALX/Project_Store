package com.Store.serviceImpl;

import com.Store.enumeration.Gender;
import com.Store.enumeration.Role;
import com.Store.model.Applicant;
import com.Store.model.Cashier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerServiceTest {
    ManagerService managerService;
    @BeforeEach
    void setUp() {
        managerService = new ManagerService();
    }

    @Test
    void hireACashierReturnsNotNull() {
       // String expected = "Successfully Hired";
        Applicant applicant = new Applicant("Ben", "Loy", 25.0, Gender.FEMALE, 5);
//        Cashier cashier = new Cashier("Ben", "Loy", Gender.FEMALE, 111, Role.CASHIER);
        assertNotNull( managerService.hireACashier(applicant));

    }

    @Test
    void hireACashierReturnsNullBcOfExperience() {
        Applicant applicant = new Applicant("Ben", "Loy", 25.0, Gender.FEMALE, 1);
        assertNull( managerService.hireACashier(applicant));

    }
    @Test
    void hireACashierReturnsNullBcOfAge() {
        Applicant applicant = new Applicant("Ben", "Loy", 15.0, Gender.FEMALE, 1);
        assertNull( managerService.hireACashier(applicant));

    }

    @Test
    void fireACashier() {
        String expected = "Contract Terminated";
        Cashier cashier = new Cashier("Ben", "Loy", Gender.FEMALE, 111, Role.CASHIER);
        assertEquals(expected, managerService.fireACashier(cashier.getFirstName()));
    }
}