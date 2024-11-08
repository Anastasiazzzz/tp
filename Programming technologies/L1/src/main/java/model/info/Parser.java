package model.info;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static Library parse(String filePath) {
        Library library = new Library();
        try {
            // создание построителя документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // создание дерева
            Document document = documentBuilder.parse(filePath);
            document.getDocumentElement().normalize();

            NodeList bookNodes = document.getElementsByTagName("book");
            for (int i = 0; i < bookNodes.getLength(); i++) {
                Element bookElement = (Element) bookNodes.item(i);
                String id = bookElement.getAttribute("id");
                String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                String author = bookElement.getElementsByTagName("author").item(0).getTextContent();
                String year = bookElement.getElementsByTagName("year").item(0).getTextContent();
                String genre = bookElement.getElementsByTagName("genre").item(0).getTextContent();
                //String price = bookElement.getElementsByTagName("price").item(0).getAttributes().getNamedItem("currency").getTextContent();
                //String price = bookElement.getElementsByTagName("price").item(0).getTextContent();


                Price price = null;
                if (bookElement.getElementsByTagName("price").getLength() > 0) {
                    String currency = bookElement.getElementsByTagName("price").item(0).getAttributes().getNamedItem("currency").getTextContent();
                    String amount = bookElement.getElementsByTagName("price").item(0).getTextContent();
                    price = new Price(currency, amount);
                }

                Publisher publisherList = null;
                if (bookElement.getElementsByTagName("publisher").getLength() > 0) {
                    Element publisherElement = (Element) bookElement.getElementsByTagName("publisher").item(0);
                    String name = publisherElement.getElementsByTagName("name").item(0).getTextContent();
                    Address address = null;
                    if (publisherElement.getElementsByTagName("address").getLength() > 0) {
                        Element addressElement = (Element) publisherElement.getElementsByTagName("address").item(0);
                        String city = addressElement.getElementsByTagName("city").item(0).getTextContent();
                        String country = addressElement.getElementsByTagName("country").item(0).getTextContent();
                        address = new Address(city, country);
                    }
                    publisherList = new Publisher(name, address);
                }

                String language = null;
                if (bookElement.getElementsByTagName("language").getLength() > 0) {
                    language = bookElement.getElementsByTagName("language").item(0).getTextContent();
                }

                String translator = null;
                if (bookElement.getElementsByTagName("translator").getLength() > 0) {
                    translator = bookElement.getElementsByTagName("translator").item(0).getTextContent();
                }

                Reviews reviewsList = null;
                if (bookElement.getElementsByTagName("review").getLength() > 0) {
                    Element reviewElement = (Element) bookElement.getElementsByTagName("review").item(0);
                    String user = reviewElement.getElementsByTagName("user").item(0).getTextContent();
                    String rating = reviewElement.getElementsByTagName("rating").item(0).getTextContent();
                    String comment = reviewElement.getElementsByTagName("comment").item(0).getTextContent();
                    reviewsList = new Reviews(user, rating, comment);
                }

                List<Awards> awardsList = new ArrayList<>();
                NodeList awardNodes = bookElement.getElementsByTagName("award");
                for (int j = 0; j < awardNodes.getLength(); j++) {
                    awardsList.add(new Awards(awardNodes.item(j).getTextContent()));

                }

                Book book = new Book(id, title, author, year, genre, price, publisherList, language, translator, awardsList, reviewsList);
                library.addBook(book);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        } catch (SAXException e) {
            e.printStackTrace(System.out);
        }
        return library;
    }
}