package XML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class objekterTilXML {

    private static final String patientData_XML = "PatientData.xml";

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(isr);
        PatientData patientData = getPatientData(bf);
        convertObjectToXML(patientData);
    }

    private static PatientData getPatientData(BufferedReader bf)  {
        PatientData patientData = new PatientData();
        try {
            System.out.println("Type a Cpr: ");
            String cpr = bf.readLine();
            System.out.println("Type a First name: ");
            String ForNavn = bf.readLine();
            System.out.println("Type a Last name: ");
            String EfterNavn = bf.readLine();
            System.out.println("Type an Email: ");
            String email = bf.readLine();
            patientData.setCpr(cpr);
            patientData.setForNavn(ForNavn);
            patientData.setEfterNavn(EfterNavn);
            patientData.setEmail(email);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return patientData;
    }

    private static void convertObjectToXML(PatientData patientData) {
        try {
            // create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(PatientData.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // Write to System.out
            m.marshal(patientData, System.out);
            // Write to File
            m.marshal(patientData, new File(patientData_XML));
        } catch (JAXBException je) {
            je.printStackTrace();
        }
    }
}