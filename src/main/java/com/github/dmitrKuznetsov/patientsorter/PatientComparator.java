package com.github.dmitrKuznetsov.patientsorter;

import com.github.dmitrKuznetsov.dto.Patient;

import java.util.Comparator;

class PatientComparator implements Comparator<Patient> {

    private final String sortField;

    PatientComparator(String sortField) {
        this.sortField = sortField;
    }

    @Override
    public int compare(Patient p1, Patient p2) {
        if (sortField.equals("name"))
            return p1.lastName.compareTo(p2.lastName);
        else if (sortField.equals("age"))
            return p2.birthday.compareTo(p1.birthday);
        return 0;
    }
}
