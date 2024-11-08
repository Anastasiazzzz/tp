package model.info;

import java.util.ArrayList;
import java.util.List;
import  model.info.Book;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        StringBuilder str_b = new StringBuilder("Library:\n");
        for (Book book : books) {
            str_b.append(book.toString()).append("\n");
        }
        return str_b.toString();
    }
}

//package model.info;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Library {
//    private List<Book> bookList = new ArrayList<>();
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("Library\n");
//        for (Book book : bookList) {
//            sb.append(book);
//            sb.append("\n");
//        }
//        return sb.toString();
//    }
//}