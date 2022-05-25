package com.github.dmitrKuznetsov.patientsorter;

import com.github.dmitrKuznetsov.dto.Patient;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PatientSorterTest {

    @Test
    void shouldProperlySortByLastName() {
        // given
        Patient patient2 = new Patient("A", "A", "D", "1990-03-20", "male", "+7-...");
        Patient patient1 = new Patient("A", "A", "C", "1990-03-20", "male", "+7-...");
        Patient patient3 = new Patient("A", "A", "J", "1990-03-20", "female", "+7-...");
        Patient patient4 = new Patient("A", "A", "CCC", "1990-03-20", "male", "+7-...");
        Patient patient5 = new Patient("A", "A", "Ccc", "1990-03-20", "female", "+7-...");

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(patient1);
        patients.add(patient2);
        patients.add(patient3);
        patients.add(patient4);
        patients.add(patient5);

        // when
        new PatientSorterImpl("name").sort(patients);

        // then
        assertEquals(patient1, patients.get(0));
        assertEquals(patient4, patients.get(1));
        assertEquals(patient5, patients.get(2));
        assertEquals(patient2, patients.get(3));
        assertEquals(patient3, patients.get(4));
    }

    @Test
    void shouldProperlySortByLastAge() {
        // given
        Patient patient1 = new Patient("A", "A", "A", "1990-03-20", "male", "+7-...");
        Patient patient2 = new Patient("A", "A", "B", "1990-04-20", "male", "+7-...");
        Patient patient3 = new Patient("A", "A", "C", "1990-03-19", "male", "+7-...");
        Patient patient4 = new Patient("A", "A", "D", "1922-03-20", "male", "+7-...");
        Patient patient5 = new Patient("A", "A", "E", "2010-03-20", "male", "+7-...");


        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(patient1);
        patients.add(patient2);
        patients.add(patient3);
        patients.add(patient4);
        patients.add(patient5);

        // when
        new PatientSorterImpl("age").sort(patients);

        // then
        assertEquals(patient5, patients.get(0));
        assertEquals(patient2, patients.get(1));
        assertEquals(patient1, patients.get(2));
        assertEquals(patient3, patients.get(3));
        assertEquals(patient4, patients.get(4));
    }
}