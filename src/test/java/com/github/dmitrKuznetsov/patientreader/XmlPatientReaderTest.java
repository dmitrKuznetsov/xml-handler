package com.github.dmitrKuznetsov.patientreader;

import com.github.dmitrKuznetsov.dto.Patient;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class XmlPatientReaderTest {

    @Test
    void shouldProperlySortByLastName() {
        // given
        Patient patient1 = new Patient("Иван","Иванович","Иванов",
                "1980-06-01","male","+7-905-680-4476");
        Patient patient5 = new Patient("Михаил","Викторович","Медведев",
                "1995-02-15","male","+7-920-670-9643");
        // when
        ArrayList<Patient> patients = new XmlPatientReader().read("xml/sample.xml");

        // then
        assertEquals(patient1, patients.get(0));
        assertEquals(patient5, patients.get(4));
    }
}