package Java;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class SimpleJava2XML {


    public static void main(String[] args) {
        try{

            XmlMapper xmlMapper = new XmlMapper();//import that shit
            xmlMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

            Person henning = new Person("10102020-2021");
            String xmlstring = xmlMapper.writeValueAsString(henning);
            System.out.println(xmlstring);

            //write this shit down into an XML file:

        }catch (Exception e){
            //https://www.baeldung.com/jackson-jsonmappingexception use this to locate problems with things not being where
            //they should be
            e.printStackTrace();
        }

    }



}




