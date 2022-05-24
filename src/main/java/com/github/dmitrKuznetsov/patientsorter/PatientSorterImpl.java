package com.github.dmitrKuznetsov.patientsorter;

import com.github.dmitrKuznetsov.dto.Patient;

import java.util.ArrayList;
import java.util.Collections;

public class PatientSorterImpl implements PatientSorter {

    private String field;

    public PatientSorterImpl(String field) {
        this.field = field;
    }

    @Override
    public void sort(ArrayList<Patient> patients) {
        Collections.sort(patients, new SortBy(field));
    }
}
