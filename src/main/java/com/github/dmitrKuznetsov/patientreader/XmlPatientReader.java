package com.github.dmitrKuznetsov.patientreader;

import com.github.dmitrKuznetsov.dto.Patient;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class XmlPatientReader implements PatientReader {

    @Override
    public ArrayList<Patient> read(String fileName) {
        File xmlFile = getFileFromResource(fileName);

        ArrayList<Patient> patients = new ArrayList<>();
        fillListFromXmlFile(patients, xmlFile);

        return patients;
    }

    private void fillListFromXmlFile(ArrayList<Patient> patients, File xmlFile) {

        // Instantiate the Factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            // optional, but recommended
            // process XML securely, avoid attacks like XML External Entities (XXE)
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            // parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(xmlFile);

            // optional, but recommended
            // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            // get <staff>
            NodeList list = doc.getElementsByTagName("patient");
            for (int ii = 0; ii < list.getLength(); ii++) {

                Node node = list.item(ii);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    // get text
                    String firstName = element.getElementsByTagName("first_name").item(0).getTextContent();
                    String middleName = element.getElementsByTagName("middle_name").item(0).getTextContent();
                    String lastName = element.getElementsByTagName("last_name").item(0).getTextContent();
                    String birthday = element.getElementsByTagName("birthday").item(0).getTextContent();
                    String gender = element.getElementsByTagName("gender").item(0).getTextContent();
                    String phone = element.getElementsByTagName("phone").item(0).getTextContent();

                    patients.add(new Patient(firstName, middleName, lastName, birthday, gender, phone));
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private File getFileFromResource(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("File not found! " + fileName);
        } else {

            // failed if files have whitespaces or special characters
            //return new File(resource.getFile());
            File xmlFile;
            try {
                xmlFile = new File(resource.toURI());
            } catch (URISyntaxException e) {
                e.printStackTrace();
                throw new IllegalArgumentException("File not found! " + fileName);
            }

            return xmlFile;
        }
    }
}
