package model.info;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class Validator {
    public static void validate(String xmlFilePath, String xsdFilePath) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdFilePath));
            javax.xml.validation.Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlFilePath)));

            System.out.println("\nXML is valid.");

        } catch (Exception e) {
            System.out.println("\nXML is not valid: " + e.getMessage());
        }
    }
}
