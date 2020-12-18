package XML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLtilJava {
    public static void main(String[] args) {
        try {
            File file = new File("PatientData.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(PatientData.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            PatientData patientData = (PatientData) jaxbUnmarshaller.unmarshal(file);
            System.out.println("Cpr: " + patientData.getCpr());
            System.out.println("First Name: " + patientData.getForNavn());
            System.out.println("Last Name: " + patientData.getEfterNavn());
            System.out.println("Email: " + patientData.getEmail());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
