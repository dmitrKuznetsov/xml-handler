package com.github.dmitrKuznetsov.patientwriter;

import com.github.dmitrKuznetsov.dto.Patient;

import java.util.ArrayList;

public interface PatientWriter {

    void write(ArrayList<Patient> patients);
}
