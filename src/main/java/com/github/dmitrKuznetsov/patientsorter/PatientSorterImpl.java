package com.github.dmitrKuznetsov.patientsorter;

import com.github.dmitrKuznetsov.dto.Patient;

import java.util.Collections;
import java.util.List;

public class PatientSorterImpl implements PatientSorter {

    private final String field;

    public PatientSorterImpl(String field) {
        this.field = field;
    }

    @Override
    public void sort(List<Patient> patients) {
        patients.sort(new PatientComparator(field));
    }
}
