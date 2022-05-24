package com.github.dmitrKuznetsov.patientsorter;

import com.github.dmitrKuznetsov.dto.Patient;

import java.util.Comparator;

class SortBy implements Comparator<Patient> {

    private String sortField;

    SortBy(String sortField) {
        this.sortField = sortField;
    }

    @Override
    public int compare(Patient p1, Patient p2) {
        if (sortField == "name")
            return p1.lastName.compareTo(p2.lastName);
        else if (sortField == "age")
            return p1.birthday.compareTo(p2.birthday);
        return 0;
    }
}
