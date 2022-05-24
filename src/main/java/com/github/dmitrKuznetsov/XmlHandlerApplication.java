package com.github.dmitrKuznetsov;

import com.github.dmitrKuznetsov.dto.Patient;
import com.github.dmitrKuznetsov.patientreader.XmlPatientReader;
import com.github.dmitrKuznetsov.patientsorter.PatientSorterImpl;
import com.github.dmitrKuznetsov.patientwriter.ConsolePatientWriter;

import java.util.ArrayList;

public class XmlHandlerApplication {
    public static void main(String[] args) {
        String fileName;
        if (args.length > 0)
            fileName = args[0];
        else {
            throw new RuntimeException("Use XML file name as the first program argument");
        }

        String sortField = null;
        if (args.length > 1)
            sortField = args[1];


        ArrayList<Patient> patients = new XmlPatientReader().read("xml/" + fileName);

        new PatientSorterImpl(sortField).sort(patients);

        new ConsolePatientWriter().write(patients);
    }
}
