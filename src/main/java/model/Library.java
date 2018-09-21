package model;

import java.util.ArrayList;
import java.util.Collection;

public class Library {

    private Collection<Book> books;

    public Library(Collection<Book> books) {
        this.books = books;
    }

    public Collection<String> getBookDetails() {
        Collection<String> bookTitles = new ArrayList<>();
        for(Book book : books) {
            bookTitles.add(book.toString());
        }
        return bookTitles;
    }
}
