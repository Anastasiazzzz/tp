package model.info;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        String xmlFilePath = "file:///C:\\Users\\в\\IdeaProjects\\Programming technologies\\L1\\src\\main\\java\\model\\info\\random_structure_39.xml";
        String xsdFilePath = "C:\\Users\\в\\IdeaProjects\\Programming technologies\\L1\\src\\main\\resources\\schema.xsd";

        //Парсинг XML
        Library library = Parser.parse(xmlFilePath);
        System.out.println(library);

        //Запись обратно в XML
        XMLWriter.write(library, "output.xml");

        //Валидация
        Validator.validate("output.xml", xsdFilePath);
    }
}


//public class Main {
//    public static void main(String[] args) throws FileNotFoundException {
//        try {
//            // создание построителя документа
//            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//            // создание дерева
//            Document document = documentBuilder.parse("file:///C:\\Users\\в\\IdeaProjects\\Programming technologies\\L1\\src\\main\\java\\model\\info\\random_structure_39.xml");
//            // получение корневого элемента
//            Node root = document.getDocumentElement();
//
//            System.out.println("Library:\n");
//            NodeList library = root.getChildNodes();
//            for (int i = 0; i < library.getLength(); i++) {
//                Node lib = library.item(i);
//                if (lib.getNodeType() != Node.TEXT_NODE) {
//                    NodeList libProps = lib.getChildNodes();
//                    for (int j = 0; j < libProps.getLength(); j++) {
//                        Node libProp = libProps.item(j);
//                        if (libProp.getNodeType() != Node.TEXT_NODE) {
//                            System.out.println(libProp.getNodeName() + ":" + libProp.getChildNodes().item(0).getTextContent());
//                        }
//                    }
//                    System.out.println("\n");
//                }
//            }
//
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace(System.out);
//        } catch (IOException e) {
//            e.printStackTrace(System.out);
//        } catch (SAXException e) {
//            e.printStackTrace(System.out);
//        }
//    }
//}