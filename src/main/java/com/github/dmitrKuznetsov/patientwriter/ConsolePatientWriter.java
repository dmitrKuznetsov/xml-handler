package com.github.dmitrKuznetsov.patientwriter;

import com.github.dmitrKuznetsov.dto.Patient;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.ArrayList;

public class ConsolePatientWriter implements PatientWriter {
    @Override
    public void write(ArrayList<Patient> patients) {
        if (patients.isEmpty()) {
            System.out.printf("No patients found %n");
            return;
        }

        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow("ФИО", "Возраст", "Пол", "Телефон");
        at.addRule();

        patients.forEach(patient -> {
            at.addRow(patient.name(), patient.age(), patient.gender.alias(), patient.phone);
            at.addRule();
        });

        at.getContext().setWidth(120);
        String rend = at.render();

        System.out.println(rend);
    }
}
