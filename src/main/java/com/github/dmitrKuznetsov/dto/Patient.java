package com.github.dmitrKuznetsov.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.LocalDate;
import java.time.Period;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        return new EqualsBuilder()
                .append(firstName, patient.firstName)
                .append(middleName, patient.middleName)
                .append(lastName, patient.lastName)
                .append(birthday, patient.birthday)
                .append(gender, patient.gender)
                .append(phone, patient.phone)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(firstName)
                .append(middleName)
                .append(lastName)
                .append(birthday)
                .append(gender)
                .append(phone)
                .toHashCode();
    }
}

