package model.info;

import java.util.List;

class Book {
    private String id;
    private String title;
    private String author;
    private String year;
    private String genre;
    private Price price;
    private String language;
    private String translator;
    private Publisher publisherList;
    private List<Awards> awardsList;
    private Reviews reviewsList;
//
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("id");
//        sb.append((this.id == null) ? "null" : this.id);
//        sb.append("title");
//        sb.append((this.title == null) ? "null" : this.title);
//        sb.append("author");
//        sb.append((this.author == null) ? "null" : this.author);
//        sb.append("year");
//        sb.append((this.year == null) ? "null" : this.year);
//        sb.append("genre");
//        sb.append((this.genre == null) ? "null" : this.genre);
//        sb.append("price");
//        sb.append((this.price == null) ? "null" : this.price);
//        sb.append("language");
//        sb.append((this.language == null) ? "null" : this.language);
//        sb.append("translator");
//        sb.append((this.translator == null) ? "null" : this.translator);
//        for (Publisher publisher : publisherList) {
//            sb.append(publisher);
//            sb.append("\n");
//        }
//        for (Awards award : awardsList) {
//            sb.append(award);
//            sb.append("\n");
//        }
//        return "Book [id=" + id + ", title=" + title + ", author=" + author +
//                ", year=" + year + ", genre=" + genre + ", price=" + price +
//                ", publisher=" + publisherList + ", language=" + language +
//                ", translator=" + translator + ", awards=" + awardsList + "]";
//    }

//    public Book(String id, String title, String author, String year,
//                String genre, String price, Publisher publisher,
//                String language, String translator, List<Awards> awards) {
//        this.id = id;
//        this.title = title;
//        this.author = author;
//        this.year = year;
//        this.genre = genre;
//        this.price = price;
//        this.publisherList = publisherList;
//        this.language = language;
//        this.translator = translator;
//        this.awardsList = awardsList;
//    }

    public Book(String id, String title, String author, String year, String genre, Price price, Publisher publisherList, String language, String translator, List<Awards> awardsList, Reviews reviewsList) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.price = price;
        this.language = language;
        this.translator = translator;
        this.publisherList = publisherList;
        this.awardsList = awardsList;
        this.reviewsList = reviewsList;
    }

    @Override
    public String toString() {
        return "Book id: " + id + ", title: " + title + ", author: " + author +
                ", year: " + year + ", genre: " + genre + ", price: " + price +
                ", publisher " + publisherList + ", language: " + language +
                ", translator: " + translator + ", reviews: " + reviewsList + ", awards: " + awardsList;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public Price getPrice() {
        return price;
    }

    public String getLanguage() {
        return language;
    }

    public String getTranslator() {
        return translator;
    }

    public Publisher getPublisher() {
        return publisherList;
    }

    public List<Awards> getAwards() {
        return awardsList;
    }

    public Reviews getReviews() {
        return reviewsList;
    }
}
