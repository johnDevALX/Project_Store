package com.Store.model;

import com.Store.enumeration.Gender;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Applicant extends Person{
    private int yearsOfExperience;
    private Gender gender;

    public Applicant() {
        super();
    }

    public Applicant( String firstName, String lastName, Double age, Gender gender, int yearsOfExperience ) {
        super( firstName, lastName , age);
        this.gender = gender;
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String toString() {
        return "Applicant{firstName" + super.getFirstName() + " lastName: " + super.getLastName() +
                " Age: " + super.getAge() + " Gender: " + gender +
                "yearsOfExperience=" + yearsOfExperience +
                 +
                '}';
    }
}
