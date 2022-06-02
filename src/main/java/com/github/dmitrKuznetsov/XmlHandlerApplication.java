package com.github.dmitrKuznetsov;

import com.github.dmitrKuznetsov.dto.Patient;
import com.github.dmitrKuznetsov.patientreader.XmlPatientReader;
import com.github.dmitrKuznetsov.patientsorter.PatientSorterImpl;
import com.github.dmitrKuznetsov.patientwriter.ConsolePatientWriter;

import java.util.List;

public class XmlHandlerApplication {
    public static void main(String[] args) {
        if (args.length == 0)
            throw new RuntimeException("Use XML file name as the first program argument");

        String fileName = args[0];
        String sortField = args.length > 1 ? args[1] : "";

        List<Patient> patients = new XmlPatientReader().read("xml/" + fileName);

        new PatientSorterImpl(sortField).sort(patients);

        new ConsolePatientWriter().write(patients);
    }
}
