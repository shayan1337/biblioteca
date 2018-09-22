package model;

import java.util.ArrayList;
import java.util.Collection;

public class Library {

    private Collection<Book> allBooks;
    private Collection<Book> availableBooks;

    public Library(Collection<Book> allBooks) {
        this.allBooks = allBooks;
        this.availableBooks = new ArrayList<>(allBooks);
    }

    public Collection<String> getBookDetails() {
        Collection<String> bookTitles = new ArrayList<>();

        for(Book book : availableBooks) {
            bookTitles.add(book.toString());
        }

        return bookTitles;
    }

    public Book checkoutBook(String bookTitle) {
        Book checkedOutBook = null;

        for(Book book : availableBooks) {
            if(book.hasTitle(bookTitle)) {
                checkedOutBook = book;
            }
        }
        availableBooks.remove(checkedOutBook);
        return checkedOutBook;
    }

    public boolean returnBook(String bookTitle) {

        for(Book book : allBooks) {
            if(book.hasTitle(bookTitle) && !availableBooks.contains(book)) {
                availableBooks.add(book);
                return true;
            }
        }
        return false;
    }
}
