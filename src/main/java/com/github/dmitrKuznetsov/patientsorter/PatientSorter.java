package com.github.dmitrKuznetsov.patientsorter;

import com.github.dmitrKuznetsov.dto.Patient;

import java.util.List;

public interface PatientSorter {
    void sort(List<Patient> patients);
}
