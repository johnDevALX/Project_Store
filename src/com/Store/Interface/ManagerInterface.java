package com.Store.Interface;

import com.Store.model.Applicant;
import com.Store.model.Cashier;

public interface ManagerInterface {
     Cashier hireACashier(Applicant applicant);

     String fireACashier(String name);

}
