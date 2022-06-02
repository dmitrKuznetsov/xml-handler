package com.github.dmitrKuznetsov.patientreader;

import com.github.dmitrKuznetsov.dto.Patient;

import java.util.List;


public interface PatientReader {
    List<Patient> read(String fileName);
}
