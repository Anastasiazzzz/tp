package model.info;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class XMLWriter {
    public static void write(Library library, String filePath) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // создание дерева
            Document document = documentBuilder.newDocument();
            // создание корневого элемента
            Element libraryElement = document.createElement("library");
            document.appendChild(libraryElement);

            for (Book book : library.getBooks()) {
                Element bookElement = document.createElement("book");
                bookElement.setAttribute("id", book.getId());

                Element title = document.createElement("title");
                title.appendChild(document.createTextNode(book.getTitle()));
                bookElement.appendChild(title);

                Element author = document.createElement("author");
                author.appendChild(document.createTextNode(book.getAuthor()));
                bookElement.appendChild(author);

                Element year = document.createElement("year");
                year.appendChild(document.createTextNode(book.getYear()));
                bookElement.appendChild(year);

                Element genre = document.createElement("genre");
                genre.appendChild(document.createTextNode(book.getGenre()));
                bookElement.appendChild(genre);

                Element price = document.createElement("price");
                price.appendChild(document.createTextNode(String.valueOf(book.getPrice())));
                bookElement.appendChild(price);

                if (book.getPublisher() != null) {
                    Element publisherElement = document.createElement("publisher");
                    Element publisherNameElement = document.createElement("name");
                    publisherNameElement.appendChild(document.createTextNode(book.getPublisher().getName()));
                    publisherElement.appendChild(publisherNameElement);

                    if (book.getPublisher().getAddress() != null) {
                        Element addressElement = document.createElement("address");
                        Element cityElement = document.createElement("city");
                        cityElement.appendChild(document.createTextNode(book.getPublisher().getAddress().getCity()));
                        addressElement.appendChild(cityElement);
                        Element countryElement = document.createElement("country");
                        countryElement.appendChild(document.createTextNode(book.getPublisher().getAddress().getCountry()));
                        addressElement.appendChild(countryElement);
                        publisherElement.appendChild(addressElement);
                    }
                    bookElement.appendChild(publisherElement);
                }

                Element language = document.createElement("language");
                language.appendChild(document.createTextNode(book.getLanguage()));
                bookElement.appendChild(language);

                Element translator = document.createElement("translator");
                translator.appendChild(document.createTextNode(book.getTranslator()));
                bookElement.appendChild(translator);

                // Добавление наград
                if (!book.getAwards().isEmpty()) {
                    Element awards = document.createElement("awards");
                    for (Awards award : book.getAwards()) {
                        Element awardElement = document.createElement("award");
                        awardElement.appendChild(document.createTextNode(award.getAward()));
                        awards.appendChild(awardElement);
                    }
                    bookElement.appendChild(awards);
                }

                if (book.getReviews() != null) {
                    Element reviews = document.createElement("reviews");
                    Element reviewsUser = document.createElement("user");
                    reviews.appendChild(document.createTextNode(book.getReviews().getUser()));
                    reviews.appendChild(reviewsUser);
                    Element reviewsRating = document.createElement("rating");
                    reviews.appendChild(document.createTextNode(book.getReviews().getRating()));
                    reviews.appendChild(reviewsRating);
                    Element reviewsComment = document.createElement("comment");
                    reviews.appendChild(document.createTextNode(book.getReviews().getComment()));
                    reviews.appendChild(reviewsComment);

                    bookElement.appendChild(reviews);
                }

                libraryElement.appendChild(bookElement);
            }
            //Запись в новый файл
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(filePath));

            transformer.transform(source, result);

            System.out.println("New file created: " + filePath);

        } catch (TransformerConfigurationException e) {
            e.printStackTrace(System.out);
        } catch (ParserConfigurationException e) {
            e.printStackTrace(System.out);
        } catch (TransformerException e) {
            e.printStackTrace(System.out);
        }
    }
}