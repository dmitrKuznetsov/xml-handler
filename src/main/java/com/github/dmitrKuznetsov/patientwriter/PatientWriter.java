package com.github.dmitrKuznetsov.patientwriter;

import com.github.dmitrKuznetsov.dto.Patient;

import java.util.List;

public interface PatientWriter {

    void write(List<Patient> patients);
}
