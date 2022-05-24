package com.github.dmitrKuznetsov.patientsorter;

import com.github.dmitrKuznetsov.dto.Patient;

import java.util.ArrayList;

public interface PatientSorter {
    void sort(ArrayList<Patient> patients);
}
