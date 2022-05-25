package com.github.dmitrKuznetsov.dto;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

public class Patient {

    public String firstName;
    public String middleName;
    public String lastName;
    public LocalDate birthday;
    public Gender gender;
    public String phone;

    public Patient(String firstName, String middleName, String lastName,
                   String birthday, String gender, String phone) {

        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthday = LocalDate.parse(birthday);

        try { this.gender = Gender.valueOf(gender); }
        catch (IllegalArgumentException e) { this.gender = Gender.undefined; }

        this.phone = phone;
    }

    public String name() {
        return String.format("%s %s %s", lastName, firstName, middleName );
    }

    public int age() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }

        if (!(o instanceof Patient)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Patient patient = (Patient) o;

        // Compare the data members and return accordingly
        return name().equals(patient.name())
                && birthday.equals(patient.birthday)
                && gender == patient.gender
                && phone.equals(patient.phone);
    }
}

