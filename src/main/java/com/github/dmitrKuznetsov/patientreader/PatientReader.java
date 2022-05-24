package com.github.dmitrKuznetsov.patientreader;

import com.github.dmitrKuznetsov.dto.Patient;

import java.util.ArrayList;

public interface PatientReader {
    ArrayList<Patient> read(String fileName);
}
